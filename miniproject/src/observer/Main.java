package observer;

public class Main {

	public static void main(String[] args) {
		Baedi baedi = new Baedi();
		Crew tiber = new Tiber();
		Crew jay = new Jay();
		baedi.subscribe(tiber);
		baedi.subscribe(jay);
		
		baedi.eatFood();

	}

}
