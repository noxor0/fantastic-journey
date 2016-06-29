package bots;

import shared.Planet;
import shared.PlanetWars;

public class RageBot {
	public static void doTurn(PlanetWars pw) {
		for (Planet source : pw.myPlanets()) {
			if (source.numShips() < 10 * source.growthRate()) {
				continue;
			}
			
			Planet dest = null;
			int bestDistance = 999999;
			for (Planet p : pw.enemyPlanets()) {
				int dist = pw.distance(source, p);
				if (dist < bestDistance) {
					bestDistance = dist;
					dest = p;
				}
			}
			
			if (dest != null) {
				pw.issueOrder(source, dest, source.numShips());
			}
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
