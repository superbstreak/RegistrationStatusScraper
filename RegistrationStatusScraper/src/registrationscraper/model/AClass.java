package registrationscraper.model;


public class AClass {
  
  private String classIdentifier;
  private String sectionIdentifier;
  private int typeOfSeatToMonitor;
  private boolean autoRegister;
  private String url;
  
  public AClass (String name, String section, int monitorType, boolean register, String url) {
    this.classIdentifier = name;
    this.sectionIdentifier = section;
    this.typeOfSeatToMonitor = monitorType;
    this.autoRegister = register;
    this.url = url;
  }
  
  public String getClassIdentifier() {
    return classIdentifier;
  }
  
  public void setClassIdentifier(String classIdentifier) {
    this.classIdentifier = classIdentifier;
  }
  
  public String getSectionIdentifier() {
    return sectionIdentifier;
  }
  
  public void setSectionIdentifier(String sectionIdentifier) {
    this.sectionIdentifier = sectionIdentifier;
  }
  
  public int getTypeOfSeatToMonitor() {
    return typeOfSeatToMonitor;
  }
  
  public void setTypeOfSeatToMonitor(int typeOfSeatToMonitor) {
    this.typeOfSeatToMonitor = typeOfSeatToMonitor;
  }
  
  public boolean isAutoRegister() {
    return autoRegister;
  }
  
  public void setAutoRegister(boolean autoRegister) {
    this.autoRegister = autoRegister;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }
  
}
