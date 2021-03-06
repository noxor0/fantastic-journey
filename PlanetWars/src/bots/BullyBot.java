package bots;

import shared.Planet;
import shared.PlanetWars;

public class BullyBot {
	public static void doTurn(PlanetWars pw) {
		// (1) If we currently have a fleet in flight, just do nothing.
		if (pw.myFleets().size() >= 1) {
			return;
		}
		
		// (2) Find my strongest planet.
		Planet source = null;
		double sourceScore = Double.MIN_VALUE;
		for (Planet p : pw.myPlanets()) {
			double score = (double) p.numShips();
			if (score > sourceScore) {
				sourceScore = score;
				source = p;
			}
		}
		
		// (3) Find the weakest enemy or neutral planet.
		Planet dest = null;
		double destScore = Double.MIN_VALUE;
		for (Planet p : pw.notMyPlanets()) {
			double score = 1.0 / (1 + p.numShips());
			if (score > destScore) {
				destScore = score;
				dest = p;
			}
		}
		
		// (4) Send half the ships from my strongest planet to the weakest
		// planet that I do not own.
		if (source != null && dest != null) {
			int numShips = source.numShips() / 2;
			pw.issueOrder(source, dest, numShips);
		}
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
