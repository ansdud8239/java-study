package prob03;

import java.util.Objects;

public class Money {

	private int amount;
	
	/* 코드 작성 */
	public Money(int amount) {
		this.amount = amount;
	}

	public Object add(Money m) {
		int result = this.amount+m.amount;
		Money money = new Money(result);
		return money;
	}

	public Object minus(Money m) {
		int result = this.amount-m.amount;
		Money money = new Money(result);
		return money;
	}

	public Object multiply(Money m) {
		int result = this.amount*m.amount;
		Money money = new Money(result);
		return money;
	}

	public Object devide(Money m) {
		;int result = this.amount/m.amount;
		Money money = new Money(result);
		return money;
	}

	@Override
	public int hashCode() {
		return Objects.hash(amount);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Money other = (Money) obj;
		return amount == other.amount;
	}
	
	
}
