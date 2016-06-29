
public class Person implements Comparable<Person>{
	private	String name, lastName;
	private double score;
	public Person(String lastName, String name, double score){
		this.name = name;
		this.lastName = lastName;
		this.score = score;
	}
	public String toString(){
		return this.lastName + "," + this.name + " " + this.score;
	}
	public int compareTo(Person other) {
		int lnc = lastName.compareTo(other.lastName);
		if(lnc != 0) return lnc;
		return name.compareTo(other.name);
	}
	public boolean isEquals(Person other){
		return lastName.equals(other.lastName)
				&& name.equals(other.name);
	}
	//get/set
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public double getScore() {
		return score;
	}
	public void setScore(double score) {
		this.score = score;
	}
}
