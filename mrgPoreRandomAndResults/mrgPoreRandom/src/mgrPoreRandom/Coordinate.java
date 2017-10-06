package mgrPoreRandom;

/**
 * Created by Michal-Desktop on 15.12.2016.
 */
public class Coordinate {
    private int x;
    private int y;
    private int z;

    public Coordinate(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Coordinate(Coordinate coord) {
        this.x = coord.x;
        this.y = coord.y;
        this.z = coord.z;
    }

    public int getX() {
        return this.x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return this.y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getZ() {
        return this.z;
    }

    public void setZ(int z) {
        this.z = z;
    }

    public boolean inRange(Coordinate coord) {
        return !this.equals(coord) && Math.abs(this.x - coord.x) <= 1 && Math.abs(this.y - coord.y) <= 1 && Math.abs(this.z - coord.z) <= 1;
    }

    public int hashCode() {
        int prime = 31;
        int result = 1;
        result = 31 * result + this.x;
        result = 31 * result + this.y;
        result = 31 * result + this.z;
        return result;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (this.getClass() != obj.getClass()) {
            return false;
        }
        Coordinate other = (Coordinate)obj;
        if (this.x != other.x) {
            return false;
        }
        if (this.y != other.y) {
            return false;
        }
        if (this.z != other.z) {
            return false;
        }
        return true;
    }
}