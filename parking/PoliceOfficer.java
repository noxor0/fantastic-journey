class PoliceOfficer{
  public String name;
  public String badgeNumber;

  public PoliceOfficer(String sName, String sBadge){
    this.name = sName;
    this.badgeNumber = sBadge;
  }

  public ParkingTicket patrol(ParkedCar car, ParkingMeter meter){
    ParkingTicket ticket = null;
    int illegalMinutes = car.getMinutesParked()
                        - meter.getMinutesPurchased();

    if(illegalMinutes > 0){
    ticket = new ParkingTicket(car, this, illegalMinutes);
    return ticket;
    }

    return ticket;
  }
}
