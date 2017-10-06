package mgr;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class DistanceMap {
	private Map<Coordinate, Integer> distance = new HashMap<Coordinate, Integer>();

	public DistanceMap(Coordinate start, List<Coordinate> allCoordinatesList) {
		System.out.println("Inicjalizacja mapy");
		for (Coordinate coord : allCoordinatesList) {
			distance.put(coord, Integer.MAX_VALUE);
		}
		distance.put(start, 0);
		System.out.println("Rozpoczecie obliczania");
		do {
			List<Coordinate> unvisitedCoordinates = new ArrayList<Coordinate>(
					allCoordinatesList);
			Coordinate currentCoord;
			while (!unvisitedCoordinates.isEmpty()) {
				int counter = 0;
				currentCoord = unvisitedCoordinates.get(counter++);
				while (distance.get(currentCoord) == Integer.MAX_VALUE
						&& counter < unvisitedCoordinates.size()) {
					currentCoord = unvisitedCoordinates.get(counter++);
				}
				if (distance.get(currentCoord) != Integer.MAX_VALUE) {
					for (Coordinate neighbourCoord : allCoordinatesList) {
						if (currentCoord.inRange(neighbourCoord)) {
							if (distance.get(neighbourCoord) > distance
									.get(currentCoord) + 1) {
								distance.put(neighbourCoord,
										distance.get(currentCoord) + 1);
							}
						}
					}
				}
				unvisitedCoordinates.remove(currentCoord);
			}
		} while (!this.checkIfcorrect());
	}

	private boolean checkIfcorrect() {
		boolean result = true;
		System.out.println("Poprawiam mape");
		for (Coordinate coord : distance.keySet()) {
			for (Coordinate neighbour : distance.keySet()) {
				if (coord.inRange(neighbour)
						&& distance.get(coord) != Integer.MAX_VALUE
						&& distance.get(neighbour) != Integer.MAX_VALUE) {
					if (Math.abs(distance.get(neighbour) - distance.get(coord)) > 1) {
						System.out.println("Poprawiam mape");
						return false;
					}
				}
			}
		}
		return result;
	}

	// na podstawie mapy pozycji wylicza graf o najkrotszej drodze;
	private static int mapCount = 0;

	public void printMap() {
		try {
			PrintStream out3 = new PrintStream(new FileOutputStream("map"
					+ mapCount++ + ".txt"));
			for (Coordinate coord : distance.keySet()) {
				out3.println(coord.getX() + " " + coord.getY() + " "
						+ distance.get(coord));
			}
			out3.flush();
			out3.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// delegacje
	public int get(Coordinate coord) {
		return distance.get(coord);
	}

	public Set<Coordinate> keySet() {
		return distance.keySet();
	}

}
