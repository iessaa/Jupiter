package jupiter.us;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.opencsv.CSVReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;

/*
 * @Auther teamUSM1
 */

public class GenerateRequirDocController {
	@FXML
	private Button myButton;
        @FXML
        private CheckBox storyID;
        @FXML
        private CheckBox title;
        @FXML
        private CheckBox storyDetails;
        @FXML
        private CheckBox AcceptCriter;
        @FXML
        private CheckBox elaboration;
        @FXML
        private CheckBox createdBy;
        @FXML
        private CheckBox assignedTo;
        @FXML
        private CheckBox requierType;
        @FXML
        private CheckBox estimatedTime;
        @FXML
        private CheckBox status;
        @FXML
        private CheckBox parentStory;
        @FXML
        private CheckBox priority;
        @FXML
	private ComboBox sortedBy;
    private ObservableList sortedByData = FXCollections.observableArrayList();
	@FXML
	private TextArea outputTextArea;
                
	public GenerateRequirDocController() {
        // Create sorting data for the ComboBox.
            sortedByData.add("Requierment Type");
            sortedByData.add("Status");
            sortedByData.add("Priority");
	}

        boolean t=true;
        int count=0;
        String [] tilte_list= new String[15];
        int[] fields = new int[15];
        int[] label = new int[15];
        String sort; 
        String sortBy;
        int s, colect;
        int numberOfStories, completed, incompleted;
    /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML
    private void initialize()  {
		// Handle Button event. 
		myButton.setOnAction((event) -> {
                    outputTextArea.appendText("\n\n***** Document Generated *****\n");
                      handleRequirDoc();   
		});
		
		// Handle CheckBox event.
                storyID.setOnAction((s) -> {
                if (storyID.isSelected() == t){
                    outputTextArea.appendText("Story ID"+ "\n");
                    tilte_list [count] = "Story ID";
                    fields [count]=0;
                    label [count]=0;
                    count++;
                }
                else{
                    outputTextArea.clear();
                }});
                // Handle CheckBox event.
                title.setOnAction((s) -> {
                if (title.isSelected() == t){
                    outputTextArea.appendText("Title"+ "\n");
                    tilte_list [count] = "Title";
                    fields [count]=1;
                    label [count]=1;
                    count++;
                }
                else{
                    outputTextArea.clear();
                }});
                // Handle CheckBox event.
                storyDetails.setOnAction((s) -> {
                if (storyDetails.isSelected() == t){
                    outputTextArea.appendText("Story Details"+ "\n");
                    tilte_list [count] = "Story Details";
                    fields [count]=2;
                    label [count]=2;
                    colect++;
                    count++;    
                }
                else{
                    outputTextArea.clear();
                }});
                // Handle CheckBox event.
                AcceptCriter.setOnAction((s) -> {
                if (AcceptCriter.isSelected() == t){
                    outputTextArea.appendText("Acceptance Criteria"+ "\n");
                    tilte_list [count] = "Acceptance Criteria";
                    fields [count]=7;
                    label [count]=3;
                    count++;  
                }
                else{
                    outputTextArea.clear();
                }});
                // Handle CheckBox event.
                elaboration.setOnAction((s) -> {
                if (elaboration.isSelected() == t){
                    outputTextArea.appendText("Elaboration"+ "\n");
                    tilte_list [count] = "Elaboration";
                    fields [count]=8;
                    label [count]=4;
                    count++;
                }
                else{
                    outputTextArea.clear();
                }});
                // Handle CheckBox event.
                createdBy.setOnAction((s) -> {
                if (createdBy.isSelected() == t){
                    outputTextArea.appendText("Created By"+ "\n");
                    tilte_list [count] = "Created By";
                    fields [count]=9;
                    label [count]=5;
                    count++;
                }
                else{
                    outputTextArea.clear();
                }});
                // Handle CheckBox event.
                assignedTo.setOnAction((s) -> {
                if (assignedTo.isSelected() == t){
                    outputTextArea.appendText("Assigned To"+ "\n");
                    tilte_list [count] = "Assigned To";
                    fields [count]=10;
                    label [count]=6;
                    count++;
                }
                else{
                    outputTextArea.clear();
                }});
                // Handle CheckBox event.
                requierType.setOnAction((s) -> {
                if (requierType.isSelected() == t){
                    outputTextArea.appendText("Requierment Type"+ "\n");
                    tilte_list [count] = "Requierment Type";
                    fields [count]=11;
                    label [count]=7;
                    count++;
                }
                else{
                    outputTextArea.clear();
                }});
                // Handle CheckBox event.
                estimatedTime.setOnAction((s) -> {
                if (estimatedTime.isSelected() == t){
                    outputTextArea.appendText("Estimated Time"+ "\n");
                    tilte_list [count] = "Estimated Time";
                    fields [count]=12;
                    label [count]=8;
                    count++;
                }
                else{
                    outputTextArea.clear();
                }});
                // Handle CheckBox event.
                status.setOnAction((s) -> {
                if (status.isSelected() == t){
                    outputTextArea.appendText("Status"+ "\n");
                    tilte_list [count] = "Status";
                    fields [count]=13;
                    label [count]=9;
                    count++;
                }
                else{
                    outputTextArea.clear();
                }});
                // Handle CheckBox event.
                parentStory.setOnAction((s) -> {
                if (parentStory.isSelected() == t){
                    outputTextArea.appendText("Parent Story"+ "\n");
                    tilte_list [count] = "Parent Story";
                    fields [count]=14;
                    label [count]=10;
                    count++;
                }
                else{
                    outputTextArea.clear();
                }});
                // Handle CheckBox event.
                priority.setOnAction((s) -> {
                if (priority.isSelected() == t){
                    outputTextArea.appendText("Priority"+ "\n");
                    tilte_list [count] = "Priority";
                    fields [count]=15;
                    label [count]=11;
                    count++;
                }
                else{
                    outputTextArea.clear();
                }});
                
		// Init ComboBox items.
                sortedBy.setItems(sortedByData);
                
		// Handle ComboBox event.
		sortedBy.setOnAction((event) -> {
                    Object selectedSort = sortedBy.getSelectionModel().getSelectedItem();
                    sort = selectedSort.toString();
                    outputTextArea.appendText("___________________________________");
                    outputTextArea.appendText("\n\nSort By "+selectedSort.toString() + "\n");
                    outputTextArea.appendText("___________________________________");
		});
		
		
	}
    @FXML
    private void handleRequirDoc(){
                try {
                storyID.setOnAction((s) ->
                {
                    if (storyID.isSelected() == t)
                    {
                        outputTextArea.appendText("Story ID"+ "\n");
                    }
                });
                String inputCSVFile = "stories.csv";
                CSVReader reader = new CSVReader(new FileReader(inputCSVFile));
                String [] nextLine;           
                int lnNum = 0;
                Document RequirementDocuments = new Document();
                PdfWriter.getInstance(RequirementDocuments, new FileOutputStream("Requirement Document.pdf"));
                RequirementDocuments.open(); 
                PdfPTable Table1 = new PdfPTable(count);
                PdfPTable Table2 = new PdfPTable(count);
                PdfPTable SortBy = new PdfPTable(1);
                PdfPTable title = new PdfPTable(count);
                PdfPCell table_cell;
                nextLine = reader.readNext();
                // Sorting by list
                if (sort.equals("Requierment Type")){sortBy="Functional";s=11;}
                if (sort.equals("Status")){sortBy="complete";s=13;}
                if (sort.equals("Priority")){sortBy="high";s=15;}
                // Showing the title of the fields that is picked
                for(int i=0; i<count;){
                    table_cell=new PdfPCell(new Phrase(tilte_list[i]));
                    title.addCell(table_cell);
                    i++;
                }
                // header
                table_cell=new PdfPCell(new Phrase("                                           Requirment Document "));
                SortBy.addCell(table_cell);
                table_cell=new PdfPCell(new Phrase("\t\t\tUser stories sorted by "+sort));
                SortBy.addCell(table_cell);
                table_cell=new PdfPCell(new Phrase("  "));
                SortBy.addCell(table_cell);
                // set of conditions to generate the document
                while ((nextLine = reader.readNext()) != null) {
                    numberOfStories++;
                    lnNum++; 
                    if (sortBy.equals(nextLine[s])){
                        for(int i=0; i<count;){
                            if(colect==1 && tilte_list[i]=="Story Details")
                            {
                                table_cell=new PdfPCell(new Phrase(nextLine[2]+" "+nextLine[3]+" "+nextLine[4]+" "+nextLine[5]+" "+nextLine[6])); 
                                Table1.addCell(table_cell);
                                i++;
                            }
                        table_cell=new PdfPCell(new Phrase(nextLine[fields[i]]));
                        Table1.addCell(table_cell); 
                        i++;

                        }
                        }
                    
                    else{
                        for(int i=0; i<count;){
                        if(colect==1 && tilte_list[i]=="Story Details")
                            {
                            table_cell=new PdfPCell(new Phrase(nextLine[2]+" "+nextLine[3]+" "+nextLine[4]+" "+nextLine[5]+" "+nextLine[6])); 
                            Table2.addCell(table_cell);
                            i++;
                            }
                        table_cell=new PdfPCell(new Phrase(nextLine[fields[i]]));
                        Table2.addCell(table_cell); 
                        i++;
                        }         
                    }
                    
                }
                // print out the data to the pdf file
                System.out.printf("number of stories"+numberOfStories);
                RequirementDocuments.add(SortBy);
                RequirementDocuments.add(title); 
                RequirementDocuments.add(Table1);
                RequirementDocuments.newPage();
                RequirementDocuments.add(SortBy);
                RequirementDocuments.add(title); 
                RequirementDocuments.add(Table2);
                RequirementDocuments.close();            
            } catch (FileNotFoundException ex) {
                Logger.getLogger(GenerateRequirDocController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (DocumentException ex) {
                Logger.getLogger(GenerateRequirDocController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(GenerateRequirDocController.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    
}