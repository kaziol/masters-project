package mgr;
import java.util.ArrayList;
import java.util.List;

public class Graph {
	private List<Coordinate> visited;

	public Graph move(Coordinate coordinate) {
		if (visited.contains(coordinate)) {
			System.out
					.println("Dodaje koordynat ktory juz jest w historii grafu!");
		} else {
			visited.add(coordinate);
		}
		return this;
	}

	public List<Coordinate> getVisitedNodesList() {
		return visited;
	}

	public Graph(Graph graph) {
		this.visited = new ArrayList<Coordinate>(graph.visited);
	}

	public Coordinate currentCoordinate() {
		return visited.get(visited.size() - 1);
	}

	public void replaceCurrentCoordinate(Coordinate coord) {
		visited.remove(visited.size() - 1);
		visited.add(coord);
	}

	public boolean isFinished(final int targetZcoord) {
		return currentCoordinate().getZ() == targetZcoord - 1;
	}

	public boolean visitedNode(Coordinate coordinate) {
		return visited.contains(coordinate);
	}

	public int directionChanges(boolean[] directions) {
		int delta = 0;
		if (directions[1] || directions[0]) {
			for (int i = 0; i < visited.size() - 1; i++) {
				if (visited.get(i).getY() != visited.get(i + 1).getY()) {
					delta++;
				}
				if (visited.get(i).getZ() != visited.get(i + 1).getZ()) {
					delta++;
				}
			}
		}
		if (directions[2] || directions[3]) {
			for (int i = 0; i < visited.size() - 1; i++) {
				if (visited.get(i).getX() != visited.get(i + 1).getX()) {
					delta++;
				}
				if (visited.get(i).getZ() != visited.get(i + 1).getZ()) {
					delta++;
				}
			}
		}
		if (directions[4] || directions[5]) {
			for (int i = 0; i < visited.size() - 1; i++) {
				if (visited.get(i).getY() != visited.get(i + 1).getY()) {
					delta++;
				}
				if (visited.get(i).getX() != visited.get(i + 1).getX()) {
					delta++;
				}
			}
		}

		return delta;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((visited == null) ? 0 : visited.hashCode());
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
		Graph other = (Graph) obj;
		if (visited == null) {
			if (other.visited != null)
				return false;
		} else if (!visited.equals(other.visited))
			return false;
		return true;
	}

	public Graph(Coordinate start, Coordinate stop, DistanceMap distance,
			boolean[] directions) {
		// jesli stop=int.max nie da sie dojsc
		// jesli start=stop jestesmy u celu juz na poczatku
		visited = new ArrayList<Coordinate>();
		int stopDis = distance.get(stop);
		if (stopDis != Integer.MAX_VALUE) {
			move(stop);
			while (!currentCoordinate().equals(start)) {
				boolean notMoved = true;
				for (Coordinate coord : distance.keySet()) {
					if (currentCoordinate().inRange(coord)) {
						int currDist = distance.get(currentCoordinate());
						int dist = distance.get(coord);
						Coordinate secondToLast;
						if (getVisitedNodesList().size() > 1) {
							secondToLast = getVisitedNodesList().get(
									getVisitedNodesList().size() - 2);
						} else
							secondToLast = getVisitedNodesList().get(0);
						try {
							if (currDist > dist && notMoved) {
								move(coord);
								notMoved = false;
								continue;
							}

							else if (currDist == dist
									&& secondToLast.inRange(coord)) {
								double absCurrentDist, absCoordDist;
								absCurrentDist = Math.pow(currentCoordinate()
										.getX() - stop.getX(), 2)
										+ Math.pow(currentCoordinate().getY()
												- stop.getY(), 2)
										+ Math.pow(currentCoordinate().getZ()
												- stop.getZ(), 2);

								absCoordDist = Math.pow(
										coord.getX() - stop.getX(), 2)
										+ Math.pow(coord.getY() - stop.getY(),
												2)
										+ Math.pow(coord.getZ() - stop.getZ(),
												2);

								if (absCoordDist < absCurrentDist) {
									replaceCurrentCoordinate(coord);
								}
							}

						} catch (ArrayIndexOutOfBoundsException ex) {
						}
					}
				}
			}
		}
	}

	/*
	 * public void paintPaths(String[] fileList, String folderPath) {
	 * BufferedImage img; int r, g, b; Random rand = new Random(); r =
	 * rand.nextInt(253) + 1; g = rand.nextInt(253) + 1; b = rand.nextInt(253) +
	 * 1; Color rgb = new Color(r, g, b); int color = rgb.getRGB(); String
	 * filename = null; for (Coordinate coord : this.getVisitedNodesList()) {
	 * try {
	 * 
	 * ImageIO.setUseCache(false); File imageFile = new File(folderPath + "\\" +
	 * fileList[coord.getZ()]); filename = imageFile.getName(); img =
	 * ImageIO.read(imageFile); img.setRGB(coord.getX(), coord.getY(), color);
	 * String extension = new String(imageFile.getName().substring(1 +
	 * imageFile.getName().lastIndexOf('.'))); if (imageFile.canWrite() &&
	 * imageFile.exists()) { ImageIO.write(img, extension, imageFile);
	 * img.flush(); } else System.out.println("NIE MOZNA ZAPISAC!");
	 * System.out.println("Pokolorowano pixel"); } catch (IOException e) {
	 * e.getStackTrace(); System.exit(-1); } } }
	 */
}
