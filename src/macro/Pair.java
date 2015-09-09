package macro;

import java.io.Serializable;

/**
 *
 * @author thinkredstone
 * @param <T>
 * @param <S>
 */
public class Pair<T, S> implements Serializable {
	T firstValue;
	S secondValue;

    /**
     *
     * @param firstValue
     * @param secondValue
     */
    public Pair(T firstValue, S secondValue) {
		super();
		this.firstValue = firstValue;
		this.secondValue = secondValue;
	}

    /**
     *
     * @return
     */
    public T getFirstValue() {
		return firstValue;
	}

    /**
     *
     * @param firstValue
     */
    public void setFirstValue(T firstValue) {
		this.firstValue = firstValue;
	}

    /**
     *
     * @return
     */
    public S getSecondValue() {
		return secondValue;
	}

    /**
     *
     * @param secondValue
     */
    public void setSecondValue(S secondValue) {
		this.secondValue = secondValue;
	}

}
