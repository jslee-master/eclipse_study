package pattern;

class Ton {
	private Ton() {
		System.out.println("singleton");
	}

	private static Ton singletion = new Ton();

	public static Ton getInstance() {
		return singletion;
	}

}


public class Single {

	public static void main(String[] args) {
		Ton singleton1 = Ton.getInstance();
		Ton singleton2 = Ton.getInstance();
		Ton singleton3 = Ton.getInstance();

	}

}
