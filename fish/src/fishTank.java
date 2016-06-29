import java.util.*;
public class fishTank { // fishTank + program
// counting amount of fish
  public static int argCounter = 0;
  public static int fishCounter = 0;
  static int tank = 3; //just need to change this number to change size of tank
  static int tankFix = tank + 1;
  static fish[] allFishie = new fish[tankFix];

  // making a fish method
  // this probably should've been in a fishTank class, whatever it works
  public static fish fishMaker() {
    Scanner sc = new Scanner(System.in);
    // too many fishes
    if (fishCounter == tank) {
      System.out.println("Too many fishies!");
      return null;
    } else {
      // making sure that fishes are moderated
      System.out.println("Lets make a fishie, what do you want to name it?");
      String name = sc.nextLine();
      System.out.println("Disposition? Type 'aggressive' or 'hippie'");
      String ag = sc.nextLine();
      if (ag.equalsIgnoreCase("Aggressive") && argCounter == 1) {
        System.out.println("Too many mad fishies!");
        return null;
      }
      if (ag.equalsIgnoreCase("Aggressive") && argCounter < 1) {
        argCounter++;
      }
			long timeCreated = System.currentTimeMillis();
      // actually making the fish
      fish fishDone = new fish(name, ag, timeCreated);
      fishCounter++;
      // assigns each fish to a place in the list
      int iMinus = 0;
      boolean yay = false;
      for (int i = 1; !yay && i < allFishie.length; i++){
        if (fishCounter == i) {
            iMinus = i - 1;
            allFishie[iMinus] = fishDone;
            yay = true;
        }
      }
      return fishDone;
    }
  }

  // the program!
  public static void main(String[] args) {
  // makes all fish empty
    String empty = "empty";
    fish e = new fish(empty, empty, 0);
    for (int i = 0; i < allFishie.length; i++){
      allFishie[i] = e;
    }
    Scanner sc = new Scanner(System.in);
  // sets up tank
    System.out.println("Welcome to Digital Fishie Simulator 2014");
  /*  System.out.println("How many fish do you want in your tank?");
    tank = sc.nextInt();*/
    System.out.println("What do you want to name your new tank?");
    String tankName = sc.nextLine();
    fishMaker();
    // the menu, a loop that ends on exit
		double totalTime = System.nanoTime();
    String c = "info";
    while (!c.equalsIgnoreCase("exit")) {
      System.out.println("Now what do you want to do?");
      System.out.println("Make a fish? Kill a fish? Get Info?");
      System.out.println("Type 'make', 'kill', 'reset' or 'info'");
      System.out.println("-------------------------------------");
      c = sc.nextLine();
    // makes fish
      if (c.equalsIgnoreCase("Make")) {
        fishMaker();
      }
    //Kills fish
      if (c.equalsIgnoreCase("Kill")) {
        System.out.println("Which fishie do you want to kill?");
        String execution = sc.nextLine();
        for (int i = 0; i < allFishie.length; i++){
          if (execution.equalsIgnoreCase(allFishie[i].name)) {
              fishCounter--;
            if (allFishie[i].aggressive.equalsIgnoreCase("Aggressive")) {
              argCounter = 0;
            }
            allFishie[i] = e;
          }
        }
      }
      // global reset.
      if (c.equalsIgnoreCase("Reset")) {
        for (int i = 0; i < allFishie.length; i++){
          allFishie[i] = e;
        }
        fishCounter = 0;
        argCounter = 0;
      }
      // lists everything
      // TODO:get timer working
      if (c.equalsIgnoreCase("Info")) {
        long endTime = System.currentTimeMillis();
        System.out.println("The name of your tank is " + tankName);
        for (int i = 0; i < allFishie.length; i++) {
          if (!allFishie[i].name.equals("empty")) {
            System.out.print(allFishie[i].name + " is "
                + allFishie[i].aggressive
                + " and has been alive for ");
            long aliveTime = endTime - allFishie[i].time;
            aliveTime = aliveTime/1000;
            System.out.print(aliveTime);
            System.out.println(" seconds");
          }
        }
        System.out.println("-------------------------------------");
      }
    }
  }
}
