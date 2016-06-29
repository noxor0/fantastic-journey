package game;

public class whoILove {
	public static void main(String[] args) {
		char[] who = new char[6];
		System.out.print("I love... ");
		for (int i = 0; i < 6; i++) {
			switch (i) {
				case 0: who[i] = 'k';
				break;
				case 1: who[i] = 'e';
				break;
				case 2: who[i] = '1';
				break;
				case 3: who[i] = 's';
				break;
				case 4: who[i] = 'e';
				break;
				case 5: who[i] = 'y';
				break;
			}
		}
		System.out.println(who);
	}
}
