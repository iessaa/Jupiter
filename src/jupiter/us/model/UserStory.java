/**
 * 
 */
package jupiter.us.model;

/**
 * @author teamUSM1
 *
 */
public class UserStory {
	
	 private int usID;
	 private String usTitle;
	 private String usRole;
	 private String usDescription;
	 private String usReason;
	 private String usCriteria;
	 private String usElaboration;
	 private String usCreatedBy;
	 private String usAssignedTo;
	 private String usRequirementType;
	 private int usEstimatedTime;
	 private String usStatus;
	 private int usParentID;
	 private String usPriority;
	 private String usType;
	 
	 
	 
	/**
	 * 
	 */
	 public UserStory() {this.usPriority=" ";}
	 
	/**
	 * @param usID
	 * @param usTitle
	 * @param usRole
	 * @param usDescription
	 * @param usReason
	 * @param usCriteria
	 * @param usElaboration
	 * @param usCreatedBy
	 * @param usAssignedTo
	 * @param usRequirementType
	 * @param usEstimatedTime
	 * @param usStatus
	 * @param usParentID
	 * @param usPriority
	 */
	public UserStory(int usID, String usTitle, String usRole,
			String usDescription, String usReason, String usCriteria,
			String usElaboration, String usCreatedBy, String usAssignedTo,
			String usRequirementType, int usEstimatedTime, String usStatus,
			int usParentID, String usPriority) {
		super();
		this.usID = usID;
		this.usTitle = usTitle;
		this.usRole = usRole;
		this.usDescription = usDescription;
		this.usReason = usReason;
		this.usCriteria = usCriteria;
		this.usElaboration = usElaboration;
		this.usCreatedBy = usCreatedBy;
		this.usAssignedTo = usAssignedTo;
		this.usRequirementType = usRequirementType;
		this.usEstimatedTime = usEstimatedTime;
		this.usStatus = usStatus;
		this.usParentID = usParentID;
		this.usPriority = usPriority;
	}



	/**
	 * @return the usTitle
	 */
	public String getUsTitle() {
		return usTitle;
	}
	/**
	 * @param usTitle the usTitle to set
	 */
	public void setUsTitle(String usTitle) {
		this.usTitle = usTitle;
	}
	/**
	 * @return the usID
	 */
	public int getUsID() {
		return usID;
	}
	/**
	 * @param usID the usID to set
	 */
	public void setUsID(int usID) {
		this.usID = usID;
	}
	/**
	 * @return the usRole
	 */
	public String getUsRole() {
		return usRole;
	}
	/**
	 * @param usRole the usRole to set
	 */
	public void setUsRole(String usRole) {
		this.usRole = usRole;
	}
	/**
	 * @return the usDescription
	 */
	public String getUsDescription() {
		return usDescription;
	}
	/**
	 * @param usDescription the usDescription to set
	 */
	public void setUsDescription(String usDescription) {
		this.usDescription = usDescription;
	}
	/**
	 * @return the usReason
	 */
	public String getUsReason() {
		return usReason;
	}
	/**
	 * @param usReason the usReason to set
	 */
	public void setUsReason(String usReason) {
		this.usReason = usReason;
	}
	/**
	 * @return the usCriteria
	 */
	public String getUsCriteria() {
		return usCriteria;
	}
	/**
	 * @param usCriteria the usCriteria to set
	 */
	public void setUsCriteria(String usCriteria) {
		this.usCriteria = usCriteria;
	}
	/**
	 * @return the usElaboration
	 */
	public String getUsElaboration() {
		return usElaboration;
	}
	/**
	 * @param usElaboration the usElaboration to set
	 */
	public void setUsElaboration(String usElaboration) {
		this.usElaboration = usElaboration;
	}
	/**
	 * @return the usCreatedBy
	 */
	public String getUsCreatedBy() {
		return usCreatedBy;
	}
	/**
	 * @param usCreatedBy the usCreatedBy to set
	 */
	public void setUsCreatedBy(String usCreatedBy) {
		this.usCreatedBy = usCreatedBy;
	}
	/**
	 * @return the usAssignedTo
	 */
	public String getUsAssignedTo() {
		return usAssignedTo;
	}
	/**
	 * @param usAssignedTo the usAssignedTo to set
	 */
	public void setUsAssignedTo(String usAssignedTo) {
		this.usAssignedTo = usAssignedTo;
	}
	/**
	 * @return the usRequirementType
	 */
	public String getUsRequirementType() {
		return usRequirementType;
	}
	/**
	 * @param usRequirementType the usRequirementType to set
	 */
	public void setUsRequirementType(String usRequirementType) {
		this.usRequirementType = usRequirementType;
	}
	/**
	 * @return the usEstimatedTime
	 */
	public int getUsEstimatedTime() {
		return usEstimatedTime;
	}
	/**
	 * @param usEstimatedTime the usEstimatedTime to set
	 */
	public void setUsEstimatedTime(int usEstimatedTime) {
		this.usEstimatedTime = usEstimatedTime;
	}
	/**
	 * @return the usStatus
	 */
	public String getUsStatus() {
		return usStatus;
	}
	/**
	 * @param usStatus the usStatus to set
	 */
	public void setUsStatus(String usStatus) {
		this.usStatus = usStatus;
	}
	/**
	 * @return the usParentID
	 */
	public int getUsParentID() {
		return usParentID;
	}
	/**
	 * @param usParentID the usParentID to set
	 */
	public void setUsParentID(int usParentID) {
		this.usParentID = usParentID;
	}
	/**
	 * @return the usPriority
	 */
	public String getUsPriority() {
		return usPriority;
	}
	/**
	 * @param usPriority the usPriority to set
	 */
	public void setUsPriority(String usPriority) {
		this.usPriority = usPriority;
	}
	/**
	 * @return the usType
	 */
	public String getUsType() {
		return usType;
	}
	/**
	 * @param usType the usType to set
	 */
	public void setUsType(String usType) {
		this.usType = usType;
	}
	 
	 
}
