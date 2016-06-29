import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import shared.*;


public class myBot {

  public static void doTurn(PlanetWars pw) {
    //Is a fleet attacking one of our planets?
    Planet source = pw.myPlanets().get(0);
    int boob = 0;
    int boo = 0;
    boolean y = false;
    for(int i = 0;y != true && i < pw.enemyFleets().size(); i++){
      for(int i2 = 0; i2 < pw.myPlanets().size(); i2++){
        if(pw.enemyFleets().get(i).destinationPlanet() == pw.myPlanets().get(i2).planetID()){
          boob = i;
          boo = i2;
          y = true;
        }
      }
    }
    //info about attacking fleet :P
    //yes then defend y == true then do this
    //attacking fleet.turnsremaning && numplanets
    // then do the totalHP THANG
    //total HP =(( growth* enemyturnsremaning) + currentHP) - enemyfleet
    if(y == true){
      Fleet atkFleet = pw.enemyFleets().get(boob);
      Planet undrAtkPlanet = pw.myPlanets().get(boo);
      int dmg = atkFleet.numShips();
      int timeLeft = atkFleet.turnsRemaining();
      int undrAtkGR = undrAtkPlanet.growthRate();
      int undrAtkHP = undrAtkPlanet.numShips();
      int totalHP = (undrAtkGR*timeLeft)+undrAtkHP-dmg;
      //if planet is to be taken over, send help

      while(totalHP < 0){
        //for each planet in myplanet list that is less than time left
      int assistance = 0;
        for(int i3 = 0; i3 < pw.myPlanets().size(); i3++){
          if(pw.distance(pw.myPlanets().get(i3), undrAtkPlanet) < timeLeft){
            if(pw.myPlanets().get(i3).numShips() > totalHP){
              assistance = totalHP + 1;
            } else{
              assistance = pw.myPlanets().get(i3).numShips();
            }
              pw.issueOrder(pw.myPlanets().get(i3), undrAtkPlanet, assistance);
          }
        }
        //add friendly fleets in flight to total hp
        for(int i3 = 0; i3 < pw.myFleets().size(); i3++){
          //for each plant in array list if destination = undrAtkPlanetID then
          //add numfleet to totalHp
          if(pw.myFleets().get(i3).destinationPlanet() == undrAtkPlanet.planetID()){
            totalHP += pw.myFleets().get(i3).numShips();
          }
        }
      }
    }

    //no then get a neutral planet


    /*Planet dest = null;
    double destScore = Double.MIN_VALUE;
    for (Planet p : pw.notMyPlanets()) {
      double score = 1.0 / (1 + p.numShips());
      if (score > destScore) {
        destScore = score;
        dest = p;
      }*/

      // which planet to attack? use magic number gr/hp
      // also include distance to enemy?
    //or no attack
      // is one of their planets vulnerable (check enemy hp)
      // is that planet close to ours?
      // how far away and how many ships needed to attack? planet.numships
        //include gr of enemy planet
          // dunno
        //include checking for reinforcements
          //fleet.destinationplanet + fleet.turnsremaning
  }
  public static void main(String[] args) {
      String line = "";
      String message = "";
      int c;
      try {
        while ((c = System.in.read()) >= 0) {
          switch (c) {
          case '\n':
            if (line.equals("go")) {
              PlanetWars pw = new PlanetWars(message);
              doTurn(pw);
              pw.finishTurn();
              message = "";
            } else {
              message += line + "\n";
            }
            line = "";
            break;
          default:
            line += (char) c;
            break;
          }
        }
      } catch (Exception e) {
        // Owned.
      }
    }
  }
