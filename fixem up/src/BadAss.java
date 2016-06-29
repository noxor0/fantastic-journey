
public class BadAss {
	String name;
	double score;
	public BadAss(String namePassedIn, double scorePassedIn){
		this.name =  namePassedIn;
		this.score = scorePassedIn;
	}
	public String toString(){
		return name + " " +score;
	}
	public double addScore(){
		score += 50;
		return score;
	}
}
