package awilcherCSC202Mod3;

public class Team implements Comparable<Team> {
	private String nickname;
	private int wins;
	private int losses;

	public Team(String nickname, int wins, int losses) {
		setNickname(nickname);
		setWins(wins);
		setLosses(losses);
	}

//assume teams are equal if their nickname is the same
	public boolean equals(Team t) {
		return nickname.equals(t.nickname);

	}

	public String toString() {
		return ("nickname: " + nickname + "\t# of wins: " + wins + "\t# of losses: " + losses);
	}

	public double winningPercentage() {
		if ((wins + losses) != 0)
			return ((double) wins / (wins + losses));
		else
			return 0.0;
	}
	
	@Override
	public int compareTo(Team o) {
		if (o.getWins() < this.getWins())
			return -1;
		else if (o.getWins() > this.getWins())
			return 1;
		else
			return 0;
	}

	public String getNickname() {
		return nickname;
	}

	public int getWins() {
		return wins;
	}

	public int getLosses() {
		return losses;
	}

	public Team setNickname(String nickname) {
		this.nickname = nickname;
		return this;
	}

	public Team setWins(int wins) {
		if (wins >= 0)
			this.wins = wins;
		return this;
	}

	public Team setLosses(int losses) {
		if (losses >= 0)
			this.losses = losses;
		return this;
	}

	

}
