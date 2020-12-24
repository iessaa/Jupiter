package jupiter.us;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Dialogs;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import jupiter.us.model.UserStory;

/**
 * The controller for the overview with address table and details view.
 * 
 * @author Essa
 */

public class USOverviewController {
	@FXML
    private TableView<UserStory> usTable;
    @FXML
    private TableColumn<UserStory, String> usIDColumn;
    @FXML
    private TableColumn<UserStory, String> usTitleColumn;
    @FXML
    private TableColumn<UserStory, String> usEstimatedTimeColumn;
    @FXML
    private TableColumn<UserStory, String> usStatusColumn;
    @FXML
    private Label idLabel;
    @FXML
    private Label titleLabel;
    @FXML
    private Label roleLabel;
    @FXML
    private Label descriptionLabel;
    @FXML
    private Label reasonLabel;
    @FXML
    private Label criteriaLabel;
    @FXML
    private Label elaborationLabel;
    @FXML
    private Label createdByLabel;
    @FXML
    private Label assignedToLabel;
    @FXML
    private Label requirementTypeLabel;
    @FXML
    private Label estimatedTimeLabel;
    @FXML
    private Label statusLabel;
    @FXML
    private Label parentLabel;
    @FXML
    private Label priorityLabel;

    // Reference to the main application
    private MainApp mainApp;

    /**
     * The constructor.
     * The constructor is called before the initialize() method.
     */
    public USOverviewController() {
   
    }

    /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML
    private void initialize() {
    	// Initialize the US table
    	//to determine which field inside the UserStory objects should be used for the particular column.
    	usIDColumn.setCellValueFactory(new PropertyValueFactory<UserStory, String>("usID"));
    	usTitleColumn.setCellValueFactory(new PropertyValueFactory<UserStory, String>("usTitle"));
        usEstimatedTimeColumn.setCellValueFactory(new PropertyValueFactory<UserStory, String>("usEstimatedTime"));
        usStatusColumn.setCellValueFactory(new PropertyValueFactory<UserStory, String>("usStatus"));
        
        // Auto resize columns
        usTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        // clear US
        showUSDetails(null);

        // Listen for selection changes
        usTable.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<UserStory>() {
        
        @Override
        public void changed(ObservableValue<? extends UserStory> observable,
        		  UserStory oldValue, UserStory newValue) {
            showUSDetails(newValue);
          }
        });
    }
    
    /**
	 * Fills all text fields to show details about the US.
	 * If the specified US is null, all text fields are cleared.
	 * 
	 * @param US the US or null
	 */
	private void showUSDetails(UserStory userStory) {
		if (userStory != null) {
			idLabel.setText(Integer.toString(userStory.getUsID()));
		    titleLabel.setText(userStory.getUsTitle());
		    roleLabel.setText(userStory.getUsRole());
		    descriptionLabel.setText(userStory.getUsDescription());
		    reasonLabel.setText(userStory.getUsReason());
		    criteriaLabel.setText(userStory.getUsCriteria());
		    elaborationLabel.setText(userStory.getUsElaboration());
		    createdByLabel.setText(userStory.getUsCreatedBy());
		    assignedToLabel.setText(userStory.getUsAssignedTo());
		    requirementTypeLabel.setText(userStory.getUsRequirementType());
		    estimatedTimeLabel.setText(Integer.toString(userStory.getUsEstimatedTime()));
		    statusLabel.setText(userStory.getUsStatus());
		    parentLabel.setText(Integer.toString(userStory.getUsParentID()));
		    priorityLabel.setText(userStory.getUsPriority());
		} else {
			idLabel.setText("");
		    titleLabel.setText("");
		    roleLabel.setText("");
		    descriptionLabel.setText("");
		    reasonLabel.setText("");
		    criteriaLabel.setText("");
		    elaborationLabel.setText("");
		    createdByLabel.setText("");
		    assignedToLabel.setText("");
		    requirementTypeLabel.setText("");
		    estimatedTimeLabel.setText("");
		    statusLabel.setText("");
		    parentLabel.setText("");
		    priorityLabel.setText("");
		}
	}
	
	/**
	 * Called when the user clicks on the delete button.
	 */
	@FXML
	private void handleDeleteUS() {
		int selectedIndex = usTable.getSelectionModel().getSelectedIndex();
		  if (selectedIndex >= 0) {
			  usTable.getItems().remove(selectedIndex);
		  } else {
		    // Nothing selected
		    Dialogs.showWarningDialog(mainApp.getPrimaryStage(),
		        "Please select a US in the table.",
		        "No US Selected", "No Selection");
		  }
	}
	
	/**
	 * Called when the user clicks the new button.
	 * Opens a dialog to edit details for a new US.
	 */
	@FXML
	private void handleNewUS() {
	  UserStory tempUS = new UserStory();
	  tempUS.setUsID(mainApp.getMax());
	  boolean okClicked = mainApp.showUSEditDialog(tempUS);
	  if (okClicked) {
	    mainApp.getUSData().add(tempUS);
	  }
	}

	/**
	 * Called when the user clicks the edit button.
	 * Opens a dialog to edit details for the selected US.
	 */
	@FXML
	private void handleEditUS() {
	  UserStory selectedUS = usTable.getSelectionModel().getSelectedItem();
	  if (selectedUS != null) {
	    boolean okClicked = mainApp.showUSEditDialog(selectedUS);
	    if (okClicked) {
	      refreshUSTable();
	      showUSDetails(selectedUS);
	    }

	  } else {
	    // Nothing selected
	    Dialogs.showWarningDialog(mainApp.getPrimaryStage(),
	        "Please select a US in the table.",
	        "No US Selected", "No Selection");
	  }
	}

	/**
	 * Refreshes the table. This is only necessary if an item that is already in
	 * the table is changed. New and deleted items are refreshed automatically.
	 * 
	 * This is a workaround because otherwise we would need to use property
	 * bindings in the model class and add a *property() method for each
	 * property. Maybe this will not be necessary in future versions of JavaFX
	 * (see http://javafx-jira.kenai.com/browse/RT-22599)
	 */
	private void refreshUSTable() {
	  int selectedIndex = usTable.getSelectionModel().getSelectedIndex();
	  usTable.setItems(null);
	  usTable.layout();
	  usTable.setItems(mainApp.getUSData());
	  // Must set the selected index again (see http://javafx-jira.kenai.com/browse/RT-26291)
	  usTable.getSelectionModel().select(selectedIndex);
	}
	
	@FXML
	public void svaeToFile(){
		mainApp.push();
	}
	
	/**
     * Is called by the main application to give a reference back to itself.
     * 
     * @param mainApp
     */
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;

        // Add observable list data to the table
        usTable.setItems(mainApp.getUSData());
    }
}
