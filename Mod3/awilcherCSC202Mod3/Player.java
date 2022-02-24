package awilcherCSC202Mod3;

public class Player implements Comparable<Player> {

	private String name;
	private int score;
	
	public Player() {
		super();
	}

	public Player(String name, int score) {
		super();
		this.name = name;
		this.score = score;
	}
	
	@Override
	public String toString() {
		return "Player name " + name + ", score = " + score;}
	
	@Override
	public int compareTo(Player o) {
		if(o.score < this.score)
			return -1;
		else if (o.score > this.score)
			return 1;
		else 
			return 0;
	}
	
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	
	
	
	
}
