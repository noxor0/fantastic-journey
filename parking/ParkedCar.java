class ParkedCar{
  public String make, model, color, licenseNumber;
  //public String sMake, sModel, sColor,sLicenseNumber;
  public int minutesParked, sParked;


  public ParkedCar(String sMake, String sModel, String sColor, String
                    sLicenseNumber, int sParked){
    this.make = sMake;
    this.model = sModel;
    this.color = sColor;
    this.licenseNumber = sLicenseNumber;
    this.minutesParked = sParked;
  }

  public int getMinutesParked(){
    return this.minutesParked;
  }

}
