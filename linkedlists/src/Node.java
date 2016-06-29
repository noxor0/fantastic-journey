//Connor Cox
public class Node {
	Person person;
	Node prev;
	Node next;
	public Node(Person x){
		this.person = x;		
	}
	public String toString(){
		return this.person.name;
	}
}
