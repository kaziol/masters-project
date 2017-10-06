package bezier;

public class Coordinate {
	public Coordinate(double x, double y, double z) {
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

	private double x, y, z;

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public double getZ() {
		return z;
	}

	public void setZ(double z) {
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
		int result;
		long temp;
		temp = Double.doubleToLongBits(x);
		result = (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(y);
		result = 31 * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(z);
		result = 31 * result + (int) (temp ^ (temp >>> 32));
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
