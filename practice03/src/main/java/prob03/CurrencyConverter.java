package prob03;

public class CurrencyConverter {
	private static double rate;

	public static double getRate() {
		return rate;
	}

	public static void setRate(double rate) {
		CurrencyConverter.rate = rate;
	}

	public static double toDollar(double d) {
		double result = d * 0.00078;
		return result;
	}

	public static double toKRW(double d) {
		double result = d * 1283.30;
		return result;
	}

}
