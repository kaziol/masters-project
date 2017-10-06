package mgr;
import java.util.HashSet;
import java.util.Set;

public class Pore {
	private int maxX, minX, maxY, minY, maxZ, minZ;
	private Set<Coordinate> coordinatesPore = new HashSet<Coordinate>();

	public Pore(Coordinate coord) {
		add(coord);
		maxX = coord.getX();
		minX = coord.getX();
		maxY = coord.getY();
		minY = coord.getY();
		maxZ = coord.getZ();
		minZ = coord.getZ();
	}

	public boolean inRange(Coordinate coord) {
		for (Coordinate inPore : coordinatesPore) {
			if (inPore.inRange(coord)) {
				return true;
			}
		}
		return false;
	}

	public boolean inRange(Pore pore) {
		for (Coordinate poreCoord : pore.coordinatesPore) {
			if (inRange(poreCoord)) {
				return true;
			}
		}
		return false;
	}

	public void add(Pore pore) {
		for (Coordinate coord : pore.coordinatesPore) {
			add(coord);
		}
	}

	public void add(Coordinate coord) {
		coordinatesPore.add(coord);
		if (coord.getX() > maxX) {
			maxX = coord.getX();
		}
		if (coord.getX() < minX) {
			minX = coord.getX();
		}
		if (coord.getY() > maxY) {
			maxY = coord.getY();
		}
		if (coord.getX() < minX) {
			minY = coord.getY();
		}
		if (coord.getZ() > maxZ) {
			maxZ = coord.getZ();
		}
		if (coord.getZ() < minZ) {
			minZ = coord.getZ();
		}
	}

	public int size() {
		return coordinatesPore.size();
	}

	public int getX() {
		return Math.abs(maxX - minX);
	}

	public int getY() {
		return Math.abs(maxY - minY);
	}

	public int getZ() {
		return Math.abs(maxZ - minZ);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((coordinatesPore == null) ? 0 : coordinatesPore.hashCode());
		result = prime * result + maxX;
		result = prime * result + maxY;
		result = prime * result + maxZ;
		result = prime * result + minX;
		result = prime * result + minY;
		result = prime * result + minZ;
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
		Pore other = (Pore) obj;
		if (coordinatesPore == null) {
			if (other.coordinatesPore != null)
				return false;
		} else if (!coordinatesPore.equals(other.coordinatesPore))
			return false;
		if (maxX != other.maxX)
			return false;
		if (maxY != other.maxY)
			return false;
		if (maxZ != other.maxZ)
			return false;
		if (minX != other.minX)
			return false;
		if (minY != other.minY)
			return false;
		if (minZ != other.minZ)
			return false;
		return true;
	}

	public Set<Coordinate> get() {
		return coordinatesPore;
	}
}
