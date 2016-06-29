//Connor Cox - Assignment 4
public class Person {
	private	String name;
	private double score;
	public Person(String name, double score){
		this.name = name;
		this.score = score;
	}
	public String toString(){
		return this.name + " " + this.score;
	}
	//get/set
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getScore() {
		return score;
	}
	public void setScore(double score) {
		this.score = score;
	}
}
