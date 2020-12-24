package jupiter.us;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import jupiter.us.model.UserStory;

public class MainApp extends Application {
	
	private Stage primaryStage;
    private BorderPane rootLayout;
    
    /**
     * The data as an observable list of USs.
     */
    private ObservableList<UserStory> usData = FXCollections.observableArrayList();

    /**
     * Constructor
     */
    public MainApp() {
      
    	String csvFile = "file.csv";
    	BufferedReader br = null;
    	String line = "";
    	String cvsSplitBy = ",";
    	
    	try {
    		 
    		br = new BufferedReader(new FileReader(csvFile));
    		while ((line = br.readLine()) != null) {
    			
    		    // use comma as separator
    			String[] usArr = line.split(cvsSplitBy);
    			
    			usData.add(new UserStory(Integer.parseInt(usArr[0]), usArr[1]
    					, usArr[2], usArr[3], usArr[4], usArr[5], usArr[6],
    					usArr[7], usArr[8], usArr[9], Integer.parseInt(usArr[10])
    					, usArr[11], Integer.parseInt(usArr[12]), usArr[13]));					
    		}
     
    	} catch (FileNotFoundException e) {
    		e.printStackTrace();
    	} catch (IOException e) {
    		e.printStackTrace();
    	} finally {
    		if (br != null) {
    			try {
    				br.close();
    			} catch (IOException e) {
    				e.printStackTrace();
    			}
    		}
    	}
    }

    /**
     * Returns the data as an observable list of USs. 
     * @return
     */
    public ObservableList<UserStory> getUSData() {
        return usData;
    }
    
	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
        this.primaryStage.setTitle("userStoryApp");

        try {
            // Load the root layout from the fxml file
            FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("view/rootLayout.fxml"));
            rootLayout = (BorderPane) loader.load();
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            // Exception gets thrown if the fxml file could not be loaded
            e.printStackTrace();
        }

        showUSOverview();
	}
	
	/**
     * Returns the main stage.
     * @return
     */
    public Stage getPrimaryStage() {
        return primaryStage;
    }

    /**
     * Shows the US overview scene.
     */
    public void showUSOverview() {
        try {
            // Load the fxml file and set into the center of the main layout
            FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("view/MainDashboard.fxml"));
            AnchorPane overviewPage = (AnchorPane) loader.load();
            rootLayout.setCenter(overviewPage);

            // Give the controller access to the main app
            USOverviewController controller = loader.getController();
            controller.setMainApp(this);

        } catch (IOException e) {
            // Exception gets thrown if the fxml file could not be loaded
            e.printStackTrace();
        }
    }
    
    /**
     * Opens a dialog to edit details for the specified US. If the user
     * clicks OK, the changes are saved into the provided US object and
     * true is returned.
     * 
     * @param US the US object to be edited
     * @return true if the user clicked OK, false otherwise.
     */
    public void getAllIDs(){
    	final Iterator<UserStory> iterator= usData.iterator();
    	String collector="";
    	while (iterator.hasNext()){
    		final UserStory us= iterator.next();
    		collector += us.getUsID() + ",";
    	}
    	System.out.println(collector);
    }
    public int getMax(){
    	return usData.get(usData.size()-1).getUsID() + 1;
    }
    public void push(){
    	
    	final Iterator<UserStory> iterator= usData.iterator();
    	String csvFile = "file.csv";
    	String collector="";
    	FileWriter writer=null;
    	
    	while (iterator.hasNext()){
    		final UserStory us= iterator.next();
            try
        	{
        	    writer = new FileWriter(csvFile);
        	    
        	    collector += us.getUsID();
        	    collector += "," + us.getUsTitle();
        	    collector += "," + us.getUsRole();
        	    collector += "," + us.getUsDescription();
        	    collector += "," + us.getUsReason();
        	    collector += "," + us.getUsCriteria();
        	    collector += "," + us.getUsElaboration();
        	    collector += "," + us.getUsCreatedBy();
        	    collector += "," + us.getUsAssignedTo();
        	    collector += "," + us.getUsRequirementType();
        	    collector += "," + us.getUsEstimatedTime();
        	    collector += "," + us.getUsStatus();
        	    collector += "," + us.getUsParentID();
        	    collector += "," + us.getUsPriority() + "\n";
        	    writer.write(collector);
        	    
        	} catch(IOException e1){
    	     	e1.printStackTrace();
    	    }finally{
    		        try{
    			        if(writer!=null) writer.close();
    	        	}catch(IOException e2){
    			       e2.printStackTrace();
    		        }
    	    }
    	}
    	
    }
    public boolean showUSEditDialog(UserStory userStory) {
      try {
        // Load the fxml file and create a new stage for the popup
        FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("view/USEditDialog1.fxml"));
        AnchorPane page = (AnchorPane) loader.load();
        Stage dialogStage = new Stage();
        dialogStage.setTitle("Edit US");
        dialogStage.initModality(Modality.WINDOW_MODAL);
        dialogStage.initOwner(primaryStage);
        Scene scene = new Scene(page);
        dialogStage.setScene(scene);

        // Set the US into the controller
        USEditDialogController controller = loader.getController();
        controller.setDialogStage(dialogStage);
        controller.setUS(userStory);

        // Show the dialog and wait until the user closes it
        dialogStage.showAndWait();

        return controller.isOkClicked();

      } catch (IOException e) {
        // Exception gets thrown if the fxml file could not be loaded
        e.printStackTrace();
        return false;
      }
    }
    
	public static void main(String[] args) {
		launch(args);
	}
}
