package bots;

import java.util.List;
import java.util.Random;

import shared.Planet;
import shared.PlanetWars;

public class EnemyBot {
	public static void doTurn(PlanetWars pw) {
		// (1) If we current have a fleet in flight, then do nothing until 
		// it arrives.
		if (pw.myFleets().size() >= 1) {
			return;
		}

		// (2) Pick one of my planets at random.
		Random r = new Random();
		Planet source = null;
		List<Planet> p = pw.myPlanets();
		if (p.size() > 0) {
			source = p.get(r.nextInt(p.size()));
		}

		// (3) Pick a target planet at random.
		Planet dest = null;
		p = pw.planets();
		if (p.size() > 0) {
			dest = p.get(r.nextInt(p.size()));
		}

		// (4) Send half the ships from source to destination.
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
