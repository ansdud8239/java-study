package prob3;

public abstract class Bird {
	protected String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public abstract void fly();
	public abstract void sing();
	
	@Override
	public String toString() {
		if(this instanceof Duck) {
			return "오리의 이름은 "+name+"입니다.";
		}
			return "참새의 이름은 "+name+"입니다";
		
		
	}
}