package awilcherCSC202Mod1;

public class ArrayRecursion {

	private Integer[] array;

	public ArrayRecursion() {

	}

	public ArrayRecursion(Integer[] ar) {
		this.array = ar;
	}

	public String toString() {
		return "";
	}

	public int sumArray(int len) {
		if (len == 1)
			return array[0];
		else
			return array[len-1] + sumArray(len - 1);

	}

	public int maxValue(int len) {
		if (len == 0)
			return array[0];
		else {
			return Math.max(array[len-1], maxValue(len - 1));

		}

	}

	public Integer[] getArray() {
		return array;
	}

	public void setArray(Integer[] array) {
		this.array = array;
	}

}
