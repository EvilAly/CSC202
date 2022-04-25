package awilcherCSC202Mod7;

public class Words {

	private String word;
	private int value;

	public Words() {

	}

	public Words(String word, int value) {
		this.word = word;
		this.value = value;
	}

	public String toString() {
		return "The word '" + this.word + "' was used a total of " + this.value + " times.";
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

}
