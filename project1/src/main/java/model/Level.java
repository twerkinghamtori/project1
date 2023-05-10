package model;

public class Level {
	private int level;
	private int maxexp;
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public int getMaxexp() {
		return maxexp;
	}
	public void setMaxexp(int maxexp) {
		this.maxexp = maxexp;
	}
	@Override
	public String toString() {
		return "Level [level=" + level + ", maxexp=" + maxexp + "]";
	}
	
}
