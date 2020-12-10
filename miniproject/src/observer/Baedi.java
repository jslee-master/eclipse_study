package observer;

import java.util.ArrayList;
import java.util.List;

public class Baedi implements Coach {

	private List<Crew> crews = new ArrayList<>();
	
	public void eatFood() {
		System.out.println("베디코치가 밥을 먹는다");
		notifyCrew("나 밥 먹음");
	}
	
	@Override
	public void subscribe(Crew crew) {
		crews.add(crew);
	}

	@Override
	public void unsubscribe(Crew crew) {
		crews.remove(crew);
	}

	@Override
	public void notifyCrew(String msg) {
		crews.forEach(crew -> crew.update(msg));
	}
	
}
