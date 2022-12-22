package prob3;

public class Sparrow extends Bird {

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		super.name = name;
		this.name = name;
	}

	@Override
	public void fly() {
		System.out.println("참새("+name+")는 날아다닙니다.");
	}

	@Override
	public void sing() {
		System.out.println("참새("+name+")가 소리내어 웁니다.");

	}


}
