package shared;
public class Planet implements Cloneable {
	
	private int planetID;
	private int owner;
	private int numShips;
	private int growthRate;
	private double x, y;

	public Planet(int planetID, int owner, int numShips, int growthRate,
			double x, double y) {
		this.planetID = planetID;
		this.owner = owner;
		this.numShips = numShips;
		this.growthRate = growthRate;
		this.x = x;
		this.y = y;
	}

	public int planetID() {
		return planetID;
	}

	public int owner() {
		return owner;
	}

	public int numShips() {
		return numShips;
	}

	public int growthRate() {
		return growthRate;
	}

	public double x() {
		return x;
	}

	public double y() {
		return y;
	}

	public void owner(int newOwner) {
		this.owner = newOwner;
	}

	public void numShips(int newNumShips) {
		this.numShips = newNumShips;
	}

	public void addShips(int amount) {
		numShips += amount;
	}

	public void removeShips(int amount) {
		numShips -= amount;
	}

	private Planet(Planet _p) {
		planetID = _p.planetID;
		owner = _p.owner;
		numShips = _p.numShips;
		growthRate = _p.growthRate;
		x = _p.x;
		y = _p.y;
	}

	public Object clone() {
		return new Planet(this);
	}
}
