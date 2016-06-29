class ParkingTicket{
  public ParkedCar car;
  public PoliceOfficer officer;
  public double fine;
  public int minutes;

  public final double FINE_PRIME = 25.0;
  public final double FINE_ADD = 10.0;

  public ParkingTicket(ParkedCar car, PoliceOfficer officer, int minutes){
    //super();
    this.car = car;
    this.officer = officer;
    this.minutes = minutes;

    calculateFine();
  }

  public String toString(){
    return "Make: "+car.make+"\nModel: "+car.model+"\nColor: "+car.color
                   +"\nLicense Number: "+car.licenseNumber+"\nFine: "+fine
                   +"\nPolice Name: "+officer.name+"\nPolice Badge: "
                   +officer.badgeNumber+"\n";
  }

  private void calculateFine(){
    double hours = minutes / 60.0;
    int intHours = (int) hours;

    if((hours - intHours) > 0){
      intHours++;
    }

    fine = FINE_PRIME;
    fine += (intHours * FINE_ADD);
  }
}
