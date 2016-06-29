
public class tester<T> {
	public static <T> void main(String[] args){
		Person test1 = new Person("aLast", "b", 12);
		Person test2 = new Person("bLast", "b", 32);
		int i = test1.compareTo(test2);
		boolean i2 = test1.equals(test2);
		if( i > 0) System.out.println("test 1 comes after test 2");
		if( i < 0) System.out.println("test 2 comes after test 1");
		if (i == 0) System.out.println("both are equal");
		System.out.println(i2);
		System.out.println(test1.compareTo(test2));
	}
	public T returnT(T item){
		return item;
	}
}
