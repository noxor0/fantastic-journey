public class Main {
  public static void main(String[] args){
    ParkedCar bobCar = new ParkedCar("Tesla", "S", "Pink", "ZYX987", 72);
    ParkingMeter bobMeter = new ParkingMeter(69);
    PoliceOfficer bobOfficer = new PoliceOfficer("Bob", "ABC123");
    ParkingTicket ticket = bobOfficer.patrol(bobCar, bobMeter);

    if(ticket != null){
      System.out.println(ticket);
    } else {
      System.out.println("He's good, yo");
    }
  }
}
