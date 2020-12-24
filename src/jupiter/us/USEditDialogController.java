package jupiter.us;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Dialogs;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import jupiter.us.model.UserStory;

/*
 * @Auther teamUSM1
 */

public class USEditDialogController {

    @FXML
    private TextField usTitleField;
    @FXML
	private TextField usIDField;
    @FXML
	private TextField usRoleField;
    @FXML
	private TextField usDescriptionField;
    @FXML
	private TextField usReasonField;
	@FXML
	private TextField usCriteriaField;
	@FXML
	private TextField usElaborationField;
	@FXML
	private TextField usCreatedByField;
	@FXML
	private TextField usAssignedToField;
	@FXML
	private TextField usRequirementTypeField;
	@FXML
    private ComboBox usEstimCbox;
	@FXML
    private ComboBox usStatusCbox;
	@FXML
    private ComboBox usParentCbox;
	@FXML
    private ComboBox usPriorityCbox;
	
    private Stage dialogStage;
    private UserStory userStory;
    private boolean okClicked = false;
    
    private MainApp mainApp;

    /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML
    private void initialize() {
  
    }
    
    

    /**
	 * 
	 */
	public USEditDialogController() {
	
	}



	/**
     * Sets the stage of this dialog.
     * @param dialogStage
     */
    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    /**
     * Sets the user story to be edited in the dialog.
     * 
     * @param US
     */
    public void setUS(UserStory userStory) {
        this.userStory = userStory;
        
        usIDField.setText(Integer.toString(userStory.getUsID()));
    	usTitleField.setText(userStory.getUsTitle());
    	usRoleField.setText(userStory.getUsRole());
    	usDescriptionField.setText(userStory.getUsDescription());
    	usReasonField.setText(userStory.getUsReason());
    	usCriteriaField.setText(userStory.getUsCriteria());
    	usElaborationField.setText(userStory.getUsElaboration());
    	usCreatedByField.setText(userStory.getUsCreatedBy());
    	usAssignedToField.setText(userStory.getUsAssignedTo());
    	usRequirementTypeField.setText(userStory.getUsRequirementType());
    	usEstimCbox.setValue(Integer.toString(userStory.getUsEstimatedTime()));
    	usStatusCbox.setValue(userStory.getUsStatus());
       // usPriorityCbox.setValue(userStory.getUsPriority());
    	//usParentCbox.setValue(Integer.toString(userStory.getUsParentID()));
    	
    	//usPriorityCbox.setValue(userStory.getUsPriority());
    }

    /**
     * Returns true if the user clicked OK, false otherwise.
     * @return
     */
    public boolean isOkClicked() {
        return okClicked;
    }

    /**
     * Called when the user clicks ok.
     */
    @FXML
    private void handleOk() {
    	
        if (isInputValid()) {
        	
        	userStory.setUsID(Integer.parseInt(usIDField.getText()));
        	userStory.setUsTitle(usTitleField.getText());
        	userStory.setUsRole(usRoleField.getText());
        	userStory.setUsDescription(usDescriptionField.getText());
        	userStory.setUsReason(usReasonField.getText());
        	userStory.setUsCriteria(usCriteriaField.getText());
        	userStory.setUsElaboration(usElaborationField.getText());
        	userStory.setUsCreatedBy(usCreatedByField.getText());
        	userStory.setUsAssignedTo(usAssignedToField.getText());
        	userStory.setUsRequirementType(usRequirementTypeField.getText());
        	userStory.setUsEstimatedTime(Integer.parseInt((String) usEstimCbox.getValue()));
        	userStory.setUsStatus((String) usStatusCbox.getValue());
        	//userStory.setUsParentID(Integer.parseInt((String) usParentCbox.getValue()));
        	userStory.setUsPriority("High");
        	String rPriority= (String) usPriorityCbox.getValue();
        	//System.out.println(usPriorityCbox.getValue());
        	
            okClicked = true;
            dialogStage.close();
        }
    }

    /**
     * Called when the user clicks cancel.
     */
    @FXML
    private void handleCancel() {
        dialogStage.close();
    }

    /**
     * Validates the user input in the text fields.
     * 
     * @return true if the input is valid
     */
    private boolean isInputValid() {
 
        String errorMessage = "";
        
        /*userStory.setUsID(Integer.parseInt(usIDField.getText()));
    	userStory.setUsTitle(usTitleField.getText());
    	userStory.setUsRole(usRoleField.getText());
    	userStory.setUsDescription(usDescriptionField.getText());
    	userStory.setUsReason(usReasonField.getText());
    	userStory.setUsCriteria(usCriteriaField.getText());
    	userStory.setUsElaboration(usElaborationField.getText());
    	userStory.setUsCreatedBy(usCreatedByField.getText());
    	userStory.setUsAssignedTo(usAssignedToField.getText());
    	userStory.setUsRequirementType(usRequirementTypeField.getText());
    	userStory.setUsEstimatedTime(Integer.parseInt((String) usEstimCbox.getValue()));
    	userStory.setUsStatus((String) usStatusCbox.getValue());
    	userStory.setUsParentID(Integer.parseInt((String) usParentCbox.getValue()));
    	userStory.setUsPriority((String) usPriorityCbox.getValue());*/
        
        if (usIDField.getText() == null || usIDField.getText().length() == 0) {
            errorMessage += "No valid id!\n"; 
        } else {
            // try to parse the postal code into an int
            try {
                Integer.parseInt(usIDField.getText());
            } catch (NumberFormatException e) {
                errorMessage += "No valid id (must be an integer)!\n"; 
            }
        }
        
        if (usTitleField.getText() == null || usTitleField.getText().length() == 0) {
            errorMessage += "No valid title!\n"; 
        }
        
        if (usRoleField.getText() == null || usRoleField.getText().length() == 0) {
            errorMessage += "No valid role!\n"; 
        }
        
        if (usDescriptionField.getText() == null || usDescriptionField.getText().length() == 0) {
            errorMessage += "No valid description!\n"; 
        }

        if (usReasonField.getText() == null || usReasonField.getText().length() == 0) {
            errorMessage += "No valid reason!\n"; 
        }

        if (usCriteriaField.getText() == null || usCriteriaField.getText().length() == 0) {
            errorMessage += "No valid priority!\n"; 
        }

        if (usElaborationField.getText() == null || usElaborationField.getText().length() == 0) {
            errorMessage += "No valid elaboration!\n"; 
        }
        
        if (usAssignedToField.getText() == null || usAssignedToField.getText().length() == 0) {
            errorMessage += "No valid elaboration!\n"; 
        }
        
       if (usRequirementTypeField.getText() == null || usRequirementTypeField.getText().length() == 0) {
            errorMessage += "No valid elaboration!\n"; 
        }
        
        if (usEstimCbox.getValue() == null) {
            errorMessage += "No valid id!\n"; 
        } else {
            // try to parse the postal code into an int
            try {
                Integer.parseInt((String) usEstimCbox.getValue());
            } catch (NumberFormatException e) {
                errorMessage += "No valid estimated time (must be an integer)!\n"; 
            }
        }
        
        if (usStatusCbox.getValue() == null) {
            errorMessage += "No valid status!\n"; 
        }
        
        /*if (usParentCbox.getValue() == null) {
            errorMessage += "No valid id!\n"; 
        } else {
            // try to parse the postal code into an int
            try {
                Integer.parseInt((String) usParentCbox.getValue());
            } catch (NumberFormatException e) {
                errorMessage += "No valid estimated time (must be an integer)!\n"; 
            }
        }*/
        
      /* if (usPriorityCbox.getValue() == null) {
            errorMessage += "No valid priority!\n"; 
        }*/

        if (errorMessage.length() == 0) {
            return true;
        } else {
            // Show the error message
            Dialogs.showErrorDialog(dialogStage, errorMessage,
                    "Please correct invalid fields", "Invalid Fields");
            return false;
        }
    
    }
}