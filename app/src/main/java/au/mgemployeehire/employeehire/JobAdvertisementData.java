package au.mgemployeehire.employeehire;

public class JobAdvertisementData {

    private String fromDate;
    private String toDate;
    private String jobPosition;
    private String jobDescription;
    private String companyName;
    private String street;
    private String suburb;
    private String state;
    private String nameOfThePerson;
    private String phone;
    private String ppe;
    private String transportRequirements;
    private String engRequirement;
    private String liftingCapacity;
    private String additionalRequirement;
    private String licenseRequired;
    private String environment;

    public JobAdvertisementData(String fromDate, String toDate, String jobPosition, String jobDescription, String companyName, String street, String suburb, String state, String nameOfThePerson, String phone, String ppe, String transportRequirements, String engRequirement, String liftingCapacity, String additionalRequirement, String licenseRequired, String environment) {
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.jobPosition = jobPosition;
        this.jobDescription = jobDescription;
        this.companyName = companyName;
        this.street = street;
        this.suburb = suburb;
        this.state = state;
        this.nameOfThePerson = nameOfThePerson;
        this.phone = phone;
        this.ppe = ppe;
        this.transportRequirements = transportRequirements;
        this.engRequirement = engRequirement;
        this.liftingCapacity = liftingCapacity;
        this.additionalRequirement = additionalRequirement;
        this.licenseRequired = licenseRequired;
        this.environment = environment;
    }

    public String getFromDate() {
        return fromDate;
    }

    public void setFromDate(String fromDate) {
        this.fromDate = fromDate;
    }

    public String getToDate() {
        return toDate;
    }

    public void setToDate(String toDate) {
        this.toDate = toDate;
    }

    public String getJobPosition() {
        return jobPosition;
    }

    public void setJobPosition(String jobPosition) {
        this.jobPosition = jobPosition;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getSuburb() {
        return suburb;
    }

    public void setSuburb(String suburb) {
        this.suburb = suburb;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getNameOfThePerson() {
        return nameOfThePerson;
    }

    public void setNameOfThePerson(String nameOfThePerson) {
        this.nameOfThePerson = nameOfThePerson;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPpe() {
        return ppe;
    }

    public void setPpe(String ppe) {
        this.ppe = ppe;
    }

    public String getTransportRequirements() {
        return transportRequirements;
    }

    public void setTransportRequirements(String transportRequirements) {
        this.transportRequirements = transportRequirements;
    }

    public String getEngRequirement() {
        return engRequirement;
    }

    public void setEngRequirement(String engRequirement) {
        this.engRequirement = engRequirement;
    }

    public String getLiftingCapacity() {
        return liftingCapacity;
    }

    public void setLiftingCapacity(String liftingCapacity) {
        this.liftingCapacity = liftingCapacity;
    }

    public String getAdditionalRequirement() {
        return additionalRequirement;
    }

    public void setAdditionalRequirement(String additionalRequirement) {
        this.additionalRequirement = additionalRequirement;
    }

    public String getLicenseRequired() {
        return licenseRequired;
    }

    public void setLicenseRequired(String licenseRequired) {
        this.licenseRequired = licenseRequired;
    }

    public String getEnvironment() {
        return environment;
    }

    public void setEnvironment(String environment) {
        this.environment = environment;
    }
}
