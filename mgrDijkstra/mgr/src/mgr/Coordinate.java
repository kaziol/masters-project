package mgr;
public class Coordinate {
	public Coordinate(int x, int y, int z) {
		super();
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public Coordinate(Coordinate coord) {
		x = coord.x;
		y = coord.y;
		z = coord.z;
	}

	private int x, y, z;

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getZ() {
		return z;
	}

	public void setZ(int z) {
		this.z = z;
	}

	/*
	 * private double distance(Coordinate coord){ return
	 * Math.sqrt(x*x+y*y+z*z-coord.x*coord.x-coord.y*coord.y-coord.z*coord.x); }
	 */
	public boolean inRange(Coordinate coord) {
		return (!this.equals(coord) && (Math.abs(this.x - coord.x) <= 1
				&& Math.abs(this.y - coord.y) <= 1 && Math
				.abs(this.z - coord.z) <= 1));
		// return distance(coord)<=Math.sqrt(3.0d);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
		result = prime * result + z;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Coordinate other = (Coordinate) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		if (z != other.z)
			return false;
		return true;
	}

}
