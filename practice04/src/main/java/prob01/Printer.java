package prob01;

public class Printer {

//	public void println(int i) {
//		System.out.println(i);
//		
//	}
//	public void println(Boolean b) {
//		System.out.println(b);
//		
//	}
//	public void println(String s) {
//		System.out.println(s);
//		
//	}
//	public void println(double d) {
//		System.out.println(d);
//		
//	}
	public <T> void println(T t) {
		System.out.println(t);
		
	}

	public int sum(Integer...integers) {
		int sum=0;
		for(int i : integers) {
			sum+=i;
		}
		return sum;
	}
	
	public <T> void println(T... ts) {
		for(T t : ts) {
			System.out.println(t);
		}
	
		
	}
	

}
