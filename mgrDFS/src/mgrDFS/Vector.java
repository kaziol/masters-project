package mgrDFS;

public class Vector {
	public Vector(int x, int y, int z) {
		super();
		this.x = x;
		this.y = y;
		this.z = z;
	}

	private int x,y,z;
	public boolean checkRange(boolean [][][] table, int gX, int gY, int gZ){
		if(gX+x<table.length && gY+y <table[0].length  && gZ+z <table[0][0].length && gX+x>=0 && gY+y >=0 && gZ+z>=0){
			return table[gX+x][gY+y][gZ+z];
		}
		return false;
	}
	public boolean checkVisited(boolean [][][] table, int gX, int gY, int gZ){
		return table[gX+x][gY+y][gZ+z];
	}
	public void setVisited(boolean [][][] table, int gX, int gY, int gZ){
		table[gX+x][gY+y][gZ+z]=true;
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public int getZ() {
		return z;
	}	
}
