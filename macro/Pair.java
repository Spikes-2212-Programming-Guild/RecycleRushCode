package macro;

import java.io.Serializable;

public class Pair<T, S> implements Serializable {
	T firstValue;
	S secondValue;

	public Pair(T firstValue, S secondValue) {
		super();
		this.firstValue = firstValue;
		this.secondValue = secondValue;
	}

	public T getFirstValue() {
		return firstValue;
	}

	public void setFirstValue(T firstValue) {
		this.firstValue = firstValue;
	}

	public S getSecondValue() {
		return secondValue;
	}

	public void setSecondValue(S secondValue) {
		this.secondValue = secondValue;
	}

}
