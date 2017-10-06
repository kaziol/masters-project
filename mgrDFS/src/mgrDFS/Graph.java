package mgrDFS;

import java.util.Stack;

public class Graph {
	private Stack<Coordinate> graph = new Stack<Coordinate>();
	private boolean[][][] coordinates;
	private boolean[][][] visited;

	public Stack<Coordinate> getGraph() {
		return graph;
	}

	public boolean isEmpty() {
		return graph.isEmpty();
	}

	public int getX() {
		return graph.get(graph.size() - 1).getX();
	}

	public int getY() {
		return graph.get(graph.size() - 1).getY();
	}

	public int getZ() {
		return graph.get(graph.size() - 1).getZ();
	}

	public Graph(Coordinate coord, boolean[][][] _coordinates,
			boolean[][][] _visited) {
		coordinates = _coordinates;
		visited = _visited;
		graph.add(coord);
		visited[coord.getX()][coord.getY()][coord.getZ()] = true;
	}

	public void move(boolean[] directions) {
		int gX, gY, gZ;
		gX = graph.get(graph.size() - 1).getX();
		gY = graph.get(graph.size() - 1).getY();
		gZ = graph.get(graph.size() - 1).getZ();
		Vector vector;
		if (directions[0]) {
			vector = new Vector(1, 0, 0);
			if (vector.checkRange(coordinates, gX, gY, gZ)
					&& !vector.checkVisited(visited, gX, gY, gZ)) {
				vector.setVisited(visited, gX, gY, gZ);
				graph.add(new Coordinate(gX + vector.getX(),
						gY + vector.getY(), gZ + vector.getZ()));
				return;
			}
			vector = new Vector(1, -1, 0);
			if (vector.checkRange(coordinates, gX, gY, gZ)
					&& !vector.checkVisited(visited, gX, gY, gZ)) {
				vector.setVisited(visited, gX, gY, gZ);
				graph.add(new Coordinate(gX + vector.getX(),
						gY + vector.getY(), gZ + vector.getZ()));
				return;
			}
			vector = new Vector(1, 1, 0);
			if (vector.checkRange(coordinates, gX, gY, gZ)
					&& !vector.checkVisited(visited, gX, gY, gZ)) {
				vector.setVisited(visited, gX, gY, gZ);
				graph.add(new Coordinate(gX + vector.getX(),
						gY + vector.getY(), gZ + vector.getZ()));
				return;
			}
			vector = new Vector(1, 0, 1);
			if (vector.checkRange(coordinates, gX, gY, gZ)
					&& !vector.checkVisited(visited, gX, gY, gZ)) {
				vector.setVisited(visited, gX, gY, gZ);
				graph.add(new Coordinate(gX + vector.getX(),
						gY + vector.getY(), gZ + vector.getZ()));
				return;
			}
			vector = new Vector(1, 0, -1);
			if (vector.checkRange(coordinates, gX, gY, gZ)
					&& !vector.checkVisited(visited, gX, gY, gZ)) {
				vector.setVisited(visited, gX, gY, gZ);
				graph.add(new Coordinate(gX + vector.getX(),
						gY + vector.getY(), gZ + vector.getZ()));
				return;
			}
			vector = new Vector(1, -1, 1);
			if (vector.checkRange(coordinates, gX, gY, gZ)
					&& !vector.checkVisited(visited, gX, gY, gZ)) {
				vector.setVisited(visited, gX, gY, gZ);
				graph.add(new Coordinate(gX + vector.getX(),
						gY + vector.getY(), gZ + vector.getZ()));
				return;
			}
			vector = new Vector(1, -1, -1);
			if (vector.checkRange(coordinates, gX, gY, gZ)
					&& !vector.checkVisited(visited, gX, gY, gZ)) {
				vector.setVisited(visited, gX, gY, gZ);
				graph.add(new Coordinate(gX + vector.getX(),
						gY + vector.getY(), gZ + vector.getZ()));
				return;
			}
			vector = new Vector(1, 1, 1);
			if (vector.checkRange(coordinates, gX, gY, gZ)
					&& !vector.checkVisited(visited, gX, gY, gZ)) {
				vector.setVisited(visited, gX, gY, gZ);
				graph.add(new Coordinate(gX + vector.getX(),
						gY + vector.getY(), gZ + vector.getZ()));
				return;
			}
			vector = new Vector(1, 1, -1);
			if (vector.checkRange(coordinates, gX, gY, gZ)
					&& !vector.checkVisited(visited, gX, gY, gZ)) {
				vector.setVisited(visited, gX, gY, gZ);
				graph.add(new Coordinate(gX + vector.getX(),
						gY + vector.getY(), gZ + vector.getZ()));
				return;
			}
			vector = new Vector(0, -1, 0);
			if (vector.checkRange(coordinates, gX, gY, gZ)
					&& !vector.checkVisited(visited, gX, gY, gZ)) {
				vector.setVisited(visited, gX, gY, gZ);
				graph.add(new Coordinate(gX + vector.getX(),
						gY + vector.getY(), gZ + vector.getZ()));
				return;
			}
			vector = new Vector(0, -1, 1);
			if (vector.checkRange(coordinates, gX, gY, gZ)
					&& !vector.checkVisited(visited, gX, gY, gZ)) {
				vector.setVisited(visited, gX, gY, gZ);
				graph.add(new Coordinate(gX + vector.getX(),
						gY + vector.getY(), gZ + vector.getZ()));
				return;
			}
			vector = new Vector(0, -1, -1);
			if (vector.checkRange(coordinates, gX, gY, gZ)
					&& !vector.checkVisited(visited, gX, gY, gZ)) {
				vector.setVisited(visited, gX, gY, gZ);
				graph.add(new Coordinate(gX + vector.getX(),
						gY + vector.getY(), gZ + vector.getZ()));
				return;
			}
			vector = new Vector(0, 0, 1);
			if (vector.checkRange(coordinates, gX, gY, gZ)
					&& !vector.checkVisited(visited, gX, gY, gZ)) {
				vector.setVisited(visited, gX, gY, gZ);
				graph.add(new Coordinate(gX + vector.getX(),
						gY + vector.getY(), gZ + vector.getZ()));
				return;
			}
			vector = new Vector(0, 0, -1);
			if (vector.checkRange(coordinates, gX, gY, gZ)
					&& !vector.checkVisited(visited, gX, gY, gZ)) {
				vector.setVisited(visited, gX, gY, gZ);
				graph.add(new Coordinate(gX + vector.getX(),
						gY + vector.getY(), gZ + vector.getZ()));
				return;
			}
			vector = new Vector(0, 1, 0);
			if (vector.checkRange(coordinates, gX, gY, gZ)
					&& !vector.checkVisited(visited, gX, gY, gZ)) {
				vector.setVisited(visited, gX, gY, gZ);
				graph.add(new Coordinate(gX + vector.getX(),
						gY + vector.getY(), gZ + vector.getZ()));
				return;
			}
			vector = new Vector(0, 1, 1);
			if (vector.checkRange(coordinates, gX, gY, gZ)
					&& !vector.checkVisited(visited, gX, gY, gZ)) {
				vector.setVisited(visited, gX, gY, gZ);
				graph.add(new Coordinate(gX + vector.getX(),
						gY + vector.getY(), gZ + vector.getZ()));
				return;
			}
			vector = new Vector(0, 1, -1);
			if (vector.checkRange(coordinates, gX, gY, gZ)
					&& !vector.checkVisited(visited, gX, gY, gZ)) {
				vector.setVisited(visited, gX, gY, gZ);
				graph.add(new Coordinate(gX + vector.getX(),
						gY + vector.getY(), gZ + vector.getZ()));
				return;
			}
			vector = new Vector(-1, -1, 0);
			if (vector.checkRange(coordinates, gX, gY, gZ)
					&& !vector.checkVisited(visited, gX, gY, gZ)) {
				vector.setVisited(visited, gX, gY, gZ);
				graph.add(new Coordinate(gX + vector.getX(),
						gY + vector.getY(), gZ + vector.getZ()));
				return;
			}
			vector = new Vector(-1, -1, 1);
			if (vector.checkRange(coordinates, gX, gY, gZ)
					&& !vector.checkVisited(visited, gX, gY, gZ)) {
				vector.setVisited(visited, gX, gY, gZ);
				graph.add(new Coordinate(gX + vector.getX(),
						gY + vector.getY(), gZ + vector.getZ()));
				return;
			}
			vector = new Vector(-1, -1, -1);
			if (vector.checkRange(coordinates, gX, gY, gZ)
					&& !vector.checkVisited(visited, gX, gY, gZ)) {
				vector.setVisited(visited, gX, gY, gZ);
				graph.add(new Coordinate(gX + vector.getX(),
						gY + vector.getY(), gZ + vector.getZ()));
				return;
			}
			vector = new Vector(-1, 0, 1);
			if (vector.checkRange(coordinates, gX, gY, gZ)
					&& !vector.checkVisited(visited, gX, gY, gZ)) {
				vector.setVisited(visited, gX, gY, gZ);
				graph.add(new Coordinate(gX + vector.getX(),
						gY + vector.getY(), gZ + vector.getZ()));
				return;
			}
			vector = new Vector(-1, 0, -1);
			if (vector.checkRange(coordinates, gX, gY, gZ)
					&& !vector.checkVisited(visited, gX, gY, gZ)) {
				vector.setVisited(visited, gX, gY, gZ);
				graph.add(new Coordinate(gX + vector.getX(),
						gY + vector.getY(), gZ + vector.getZ()));
				return;
			}
			vector = new Vector(-1, 1, 0);
			if (vector.checkRange(coordinates, gX, gY, gZ)
					&& !vector.checkVisited(visited, gX, gY, gZ)) {
				vector.setVisited(visited, gX, gY, gZ);
				graph.add(new Coordinate(gX + vector.getX(),
						gY + vector.getY(), gZ + vector.getZ()));
				return;
			}
			vector = new Vector(-1, 1, 1);
			if (vector.checkRange(coordinates, gX, gY, gZ)
					&& !vector.checkVisited(visited, gX, gY, gZ)) {
				vector.setVisited(visited, gX, gY, gZ);
				graph.add(new Coordinate(gX + vector.getX(),
						gY + vector.getY(), gZ + vector.getZ()));
				return;
			}
			vector = new Vector(-1, 1, -1);
			if (vector.checkRange(coordinates, gX, gY, gZ)
					&& !vector.checkVisited(visited, gX, gY, gZ)) {
				vector.setVisited(visited, gX, gY, gZ);
				graph.add(new Coordinate(gX + vector.getX(),
						gY + vector.getY(), gZ + vector.getZ()));
				return;
			}
			vector = new Vector(-1, 0, 0);
			if (vector.checkRange(coordinates, gX, gY, gZ)
					&& !vector.checkVisited(visited, gX, gY, gZ)) {
				vector.setVisited(visited, gX, gY, gZ);
				graph.add(new Coordinate(gX + vector.getX(),
						gY + vector.getY(), gZ + vector.getZ()));
				return;
			}
		} else if (directions[1]) {
			vector = new Vector(-1, 0, 0);
			if (vector.checkRange(coordinates, gX, gY, gZ)
					&& !vector.checkVisited(visited, gX, gY, gZ)) {
				vector.setVisited(visited, gX, gY, gZ);
				graph.add(new Coordinate(gX + vector.getX(),
						gY + vector.getY(), gZ + vector.getZ()));
				return;
			}
			vector = new Vector(-1, -1, 0);
			if (vector.checkRange(coordinates, gX, gY, gZ)
					&& !vector.checkVisited(visited, gX, gY, gZ)) {
				vector.setVisited(visited, gX, gY, gZ);
				graph.add(new Coordinate(gX + vector.getX(),
						gY + vector.getY(), gZ + vector.getZ()));
				return;
			}
			vector = new Vector(-1, 1, 0);
			if (vector.checkRange(coordinates, gX, gY, gZ)
					&& !vector.checkVisited(visited, gX, gY, gZ)) {
				vector.setVisited(visited, gX, gY, gZ);
				graph.add(new Coordinate(gX + vector.getX(),
						gY + vector.getY(), gZ + vector.getZ()));
				return;
			}
			vector = new Vector(-1, 0, 1);
			if (vector.checkRange(coordinates, gX, gY, gZ)
					&& !vector.checkVisited(visited, gX, gY, gZ)) {
				vector.setVisited(visited, gX, gY, gZ);
				graph.add(new Coordinate(gX + vector.getX(),
						gY + vector.getY(), gZ + vector.getZ()));
				return;
			}
			vector = new Vector(-1, 0, -1);
			if (vector.checkRange(coordinates, gX, gY, gZ)
					&& !vector.checkVisited(visited, gX, gY, gZ)) {
				vector.setVisited(visited, gX, gY, gZ);
				graph.add(new Coordinate(gX + vector.getX(),
						gY + vector.getY(), gZ + vector.getZ()));
				return;
			}
			vector = new Vector(-1, -1, 1);
			if (vector.checkRange(coordinates, gX, gY, gZ)
					&& !vector.checkVisited(visited, gX, gY, gZ)) {
				vector.setVisited(visited, gX, gY, gZ);
				graph.add(new Coordinate(gX + vector.getX(),
						gY + vector.getY(), gZ + vector.getZ()));
				return;
			}
			vector = new Vector(-1, -1, -1);
			if (vector.checkRange(coordinates, gX, gY, gZ)
					&& !vector.checkVisited(visited, gX, gY, gZ)) {
				vector.setVisited(visited, gX, gY, gZ);
				graph.add(new Coordinate(gX + vector.getX(),
						gY + vector.getY(), gZ + vector.getZ()));
				return;
			}
			vector = new Vector(-1, 1, 1);
			if (vector.checkRange(coordinates, gX, gY, gZ)
					&& !vector.checkVisited(visited, gX, gY, gZ)) {
				vector.setVisited(visited, gX, gY, gZ);
				graph.add(new Coordinate(gX + vector.getX(),
						gY + vector.getY(), gZ + vector.getZ()));
				return;
			}
			vector = new Vector(-1, 1, -1);
			if (vector.checkRange(coordinates, gX, gY, gZ)
					&& !vector.checkVisited(visited, gX, gY, gZ)) {
				vector.setVisited(visited, gX, gY, gZ);
				graph.add(new Coordinate(gX + vector.getX(),
						gY + vector.getY(), gZ + vector.getZ()));
				return;
			}
			vector = new Vector(0, -1, 0);
			if (vector.checkRange(coordinates, gX, gY, gZ)
					&& !vector.checkVisited(visited, gX, gY, gZ)) {
				vector.setVisited(visited, gX, gY, gZ);
				graph.add(new Coordinate(gX + vector.getX(),
						gY + vector.getY(), gZ + vector.getZ()));
				return;
			}
			vector = new Vector(0, -1, 1);
			if (vector.checkRange(coordinates, gX, gY, gZ)
					&& !vector.checkVisited(visited, gX, gY, gZ)) {
				vector.setVisited(visited, gX, gY, gZ);
				graph.add(new Coordinate(gX + vector.getX(),
						gY + vector.getY(), gZ + vector.getZ()));
				return;
			}
			vector = new Vector(0, -1, -1);
			if (vector.checkRange(coordinates, gX, gY, gZ)
					&& !vector.checkVisited(visited, gX, gY, gZ)) {
				vector.setVisited(visited, gX, gY, gZ);
				graph.add(new Coordinate(gX + vector.getX(),
						gY + vector.getY(), gZ + vector.getZ()));
				return;
			}
			vector = new Vector(0, 0, 1);
			if (vector.checkRange(coordinates, gX, gY, gZ)
					&& !vector.checkVisited(visited, gX, gY, gZ)) {
				vector.setVisited(visited, gX, gY, gZ);
				graph.add(new Coordinate(gX + vector.getX(),
						gY + vector.getY(), gZ + vector.getZ()));
				return;
			}
			vector = new Vector(0, 0, -1);
			if (vector.checkRange(coordinates, gX, gY, gZ)
					&& !vector.checkVisited(visited, gX, gY, gZ)) {
				vector.setVisited(visited, gX, gY, gZ);
				graph.add(new Coordinate(gX + vector.getX(),
						gY + vector.getY(), gZ + vector.getZ()));
				return;
			}
			vector = new Vector(0, 1, 0);
			if (vector.checkRange(coordinates, gX, gY, gZ)
					&& !vector.checkVisited(visited, gX, gY, gZ)) {
				vector.setVisited(visited, gX, gY, gZ);
				graph.add(new Coordinate(gX + vector.getX(),
						gY + vector.getY(), gZ + vector.getZ()));
				return;
			}
			vector = new Vector(0, 1, 1);
			if (vector.checkRange(coordinates, gX, gY, gZ)
					&& !vector.checkVisited(visited, gX, gY, gZ)) {
				vector.setVisited(visited, gX, gY, gZ);
				graph.add(new Coordinate(gX + vector.getX(),
						gY + vector.getY(), gZ + vector.getZ()));
				return;
			}
			vector = new Vector(0, 1, -1);
			if (vector.checkRange(coordinates, gX, gY, gZ)
					&& !vector.checkVisited(visited, gX, gY, gZ)) {
				vector.setVisited(visited, gX, gY, gZ);
				graph.add(new Coordinate(gX + vector.getX(),
						gY + vector.getY(), gZ + vector.getZ()));
				return;
			}
			vector = new Vector(1, -1, 0);
			if (vector.checkRange(coordinates, gX, gY, gZ)
					&& !vector.checkVisited(visited, gX, gY, gZ)) {
				vector.setVisited(visited, gX, gY, gZ);
				graph.add(new Coordinate(gX + vector.getX(),
						gY + vector.getY(), gZ + vector.getZ()));
				return;
			}
			vector = new Vector(1, -1, 1);
			if (vector.checkRange(coordinates, gX, gY, gZ)
					&& !vector.checkVisited(visited, gX, gY, gZ)) {
				vector.setVisited(visited, gX, gY, gZ);
				graph.add(new Coordinate(gX + vector.getX(),
						gY + vector.getY(), gZ + vector.getZ()));
				return;
			}
			vector = new Vector(1, -1, -1);
			if (vector.checkRange(coordinates, gX, gY, gZ)
					&& !vector.checkVisited(visited, gX, gY, gZ)) {
				vector.setVisited(visited, gX, gY, gZ);
				graph.add(new Coordinate(gX + vector.getX(),
						gY + vector.getY(), gZ + vector.getZ()));
				return;
			}
			vector = new Vector(1, 1, -1);
			if (vector.checkRange(coordinates, gX, gY, gZ)
					&& !vector.checkVisited(visited, gX, gY, gZ)) {
				vector.setVisited(visited, gX, gY, gZ);
				graph.add(new Coordinate(gX + vector.getX(),
						gY + vector.getY(), gZ + vector.getZ()));
				return;
			}
			vector = new Vector(1, 0, 1);
			if (vector.checkRange(coordinates, gX, gY, gZ)
					&& !vector.checkVisited(visited, gX, gY, gZ)) {
				vector.setVisited(visited, gX, gY, gZ);
				graph.add(new Coordinate(gX + vector.getX(),
						gY + vector.getY(), gZ + vector.getZ()));
				return;
			}
			vector = new Vector(1, 0, -1);
			if (vector.checkRange(coordinates, gX, gY, gZ)
					&& !vector.checkVisited(visited, gX, gY, gZ)) {
				vector.setVisited(visited, gX, gY, gZ);
				graph.add(new Coordinate(gX + vector.getX(),
						gY + vector.getY(), gZ + vector.getZ()));
				return;
			}
			vector = new Vector(1, 1, 0);
			if (vector.checkRange(coordinates, gX, gY, gZ)
					&& !vector.checkVisited(visited, gX, gY, gZ)) {
				vector.setVisited(visited, gX, gY, gZ);
				graph.add(new Coordinate(gX + vector.getX(),
						gY + vector.getY(), gZ + vector.getZ()));
				return;
			}
			vector = new Vector(1, 1, 1);
			if (vector.checkRange(coordinates, gX, gY, gZ)
					&& !vector.checkVisited(visited, gX, gY, gZ)) {
				vector.setVisited(visited, gX, gY, gZ);
				graph.add(new Coordinate(gX + vector.getX(),
						gY + vector.getY(), gZ + vector.getZ()));
				return;
			}
			vector = new Vector(1, 0, 0);
			if (vector.checkRange(coordinates, gX, gY, gZ)
					&& !vector.checkVisited(visited, gX, gY, gZ)) {
				vector.setVisited(visited, gX, gY, gZ);
				graph.add(new Coordinate(gX + vector.getX(),
						gY + vector.getY(), gZ + vector.getZ()));
				return;
			}
		} else if (directions[2]) {
			vector = new Vector(0,1,0);if(vector.checkRange(coordinates, gX, gY, gZ) && !vector.checkVisited(visited, gX, gY, gZ)){
			    vector.setVisited(visited, gX, gY, gZ);
			    graph.add(new Coordinate(gX+vector.getX(),gY+vector.getY(),gZ+vector.getZ()));
			    return;
			   }
			vector = new Vector(1,1,0);if(vector.checkRange(coordinates, gX, gY, gZ) && !vector.checkVisited(visited, gX, gY, gZ)){
			    vector.setVisited(visited, gX, gY, gZ);
			    graph.add(new Coordinate(gX+vector.getX(),gY+vector.getY(),gZ+vector.getZ()));
			    return;
			   }
			vector = new Vector(-1,1,0);if(vector.checkRange(coordinates, gX, gY, gZ) && !vector.checkVisited(visited, gX, gY, gZ)){
			    vector.setVisited(visited, gX, gY, gZ);
			    graph.add(new Coordinate(gX+vector.getX(),gY+vector.getY(),gZ+vector.getZ()));
			    return;
			   }
			vector = new Vector(0,1,1);if(vector.checkRange(coordinates, gX, gY, gZ) && !vector.checkVisited(visited, gX, gY, gZ)){
			    vector.setVisited(visited, gX, gY, gZ);
			    graph.add(new Coordinate(gX+vector.getX(),gY+vector.getY(),gZ+vector.getZ()));
			    return;
			   }
			vector = new Vector(0,1,-1);if(vector.checkRange(coordinates, gX, gY, gZ) && !vector.checkVisited(visited, gX, gY, gZ)){
			    vector.setVisited(visited, gX, gY, gZ);
			    graph.add(new Coordinate(gX+vector.getX(),gY+vector.getY(),gZ+vector.getZ()));
			    return;
			   }
			vector = new Vector(1,1,1);if(vector.checkRange(coordinates, gX, gY, gZ) && !vector.checkVisited(visited, gX, gY, gZ)){
			    vector.setVisited(visited, gX, gY, gZ);
			    graph.add(new Coordinate(gX+vector.getX(),gY+vector.getY(),gZ+vector.getZ()));
			    return;
			   }
			vector = new Vector(1,1,-1);if(vector.checkRange(coordinates, gX, gY, gZ) && !vector.checkVisited(visited, gX, gY, gZ)){
			    vector.setVisited(visited, gX, gY, gZ);
			    graph.add(new Coordinate(gX+vector.getX(),gY+vector.getY(),gZ+vector.getZ()));
			    return;
			   }
			vector = new Vector(-1,1,1);if(vector.checkRange(coordinates, gX, gY, gZ) && !vector.checkVisited(visited, gX, gY, gZ)){
			    vector.setVisited(visited, gX, gY, gZ);
			    graph.add(new Coordinate(gX+vector.getX(),gY+vector.getY(),gZ+vector.getZ()));
			    return;
			   }
			vector = new Vector(-1,1,-1);if(vector.checkRange(coordinates, gX, gY, gZ) && !vector.checkVisited(visited, gX, gY, gZ)){
			    vector.setVisited(visited, gX, gY, gZ);
			    graph.add(new Coordinate(gX+vector.getX(),gY+vector.getY(),gZ+vector.getZ()));
			    return;
			   }
			vector = new Vector(1,0,0);if(vector.checkRange(coordinates, gX, gY, gZ) && !vector.checkVisited(visited, gX, gY, gZ)){
			    vector.setVisited(visited, gX, gY, gZ);
			    graph.add(new Coordinate(gX+vector.getX(),gY+vector.getY(),gZ+vector.getZ()));
			    return;
			   }
			vector = new Vector(-1,0,0);if(vector.checkRange(coordinates, gX, gY, gZ) && !vector.checkVisited(visited, gX, gY, gZ)){
			    vector.setVisited(visited, gX, gY, gZ);
			    graph.add(new Coordinate(gX+vector.getX(),gY+vector.getY(),gZ+vector.getZ()));
			    return;
			   }
			vector = new Vector(0,0,1);if(vector.checkRange(coordinates, gX, gY, gZ) && !vector.checkVisited(visited, gX, gY, gZ)){
			    vector.setVisited(visited, gX, gY, gZ);
			    graph.add(new Coordinate(gX+vector.getX(),gY+vector.getY(),gZ+vector.getZ()));
			    return;
			   }
			vector = new Vector(0,0,-1);if(vector.checkRange(coordinates, gX, gY, gZ) && !vector.checkVisited(visited, gX, gY, gZ)){
			    vector.setVisited(visited, gX, gY, gZ);
			    graph.add(new Coordinate(gX+vector.getX(),gY+vector.getY(),gZ+vector.getZ()));
			    return;
			   }
			vector = new Vector(1,0,1);if(vector.checkRange(coordinates, gX, gY, gZ) && !vector.checkVisited(visited, gX, gY, gZ)){
			    vector.setVisited(visited, gX, gY, gZ);
			    graph.add(new Coordinate(gX+vector.getX(),gY+vector.getY(),gZ+vector.getZ()));
			    return;
			   }
			vector = new Vector(1,0,-1);if(vector.checkRange(coordinates, gX, gY, gZ) && !vector.checkVisited(visited, gX, gY, gZ)){
			    vector.setVisited(visited, gX, gY, gZ);
			    graph.add(new Coordinate(gX+vector.getX(),gY+vector.getY(),gZ+vector.getZ()));
			    return;
			   }
			vector = new Vector(-1,0,1);if(vector.checkRange(coordinates, gX, gY, gZ) && !vector.checkVisited(visited, gX, gY, gZ)){
			    vector.setVisited(visited, gX, gY, gZ);
			    graph.add(new Coordinate(gX+vector.getX(),gY+vector.getY(),gZ+vector.getZ()));
			    return;
			   }
			vector = new Vector(-1,0,-1);if(vector.checkRange(coordinates, gX, gY, gZ) && !vector.checkVisited(visited, gX, gY, gZ)){
			    vector.setVisited(visited, gX, gY, gZ);
			    graph.add(new Coordinate(gX+vector.getX(),gY+vector.getY(),gZ+vector.getZ()));
			    return;
			   }
			vector = new Vector(-1,-1,-1);if(vector.checkRange(coordinates, gX, gY, gZ) && !vector.checkVisited(visited, gX, gY, gZ)){
			    vector.setVisited(visited, gX, gY, gZ);
			    graph.add(new Coordinate(gX+vector.getX(),gY+vector.getY(),gZ+vector.getZ()));
			    return;
			   }
			vector = new Vector(1,-1,0);if(vector.checkRange(coordinates, gX, gY, gZ) && !vector.checkVisited(visited, gX, gY, gZ)){
			    vector.setVisited(visited, gX, gY, gZ);
			    graph.add(new Coordinate(gX+vector.getX(),gY+vector.getY(),gZ+vector.getZ()));
			    return;
			   }
			vector = new Vector(-1,-1,0);if(vector.checkRange(coordinates, gX, gY, gZ) && !vector.checkVisited(visited, gX, gY, gZ)){
			    vector.setVisited(visited, gX, gY, gZ);
			    graph.add(new Coordinate(gX+vector.getX(),gY+vector.getY(),gZ+vector.getZ()));
			    return;
			   }
			vector = new Vector(0,-1,1);if(vector.checkRange(coordinates, gX, gY, gZ) && !vector.checkVisited(visited, gX, gY, gZ)){
			    vector.setVisited(visited, gX, gY, gZ);
			    graph.add(new Coordinate(gX+vector.getX(),gY+vector.getY(),gZ+vector.getZ()));
			    return;
			   }
			vector = new Vector(0,-1,-1);if(vector.checkRange(coordinates, gX, gY, gZ) && !vector.checkVisited(visited, gX, gY, gZ)){
			    vector.setVisited(visited, gX, gY, gZ);
			    graph.add(new Coordinate(gX+vector.getX(),gY+vector.getY(),gZ+vector.getZ()));
			    return;
			   }
			vector = new Vector(1,-1,1);if(vector.checkRange(coordinates, gX, gY, gZ) && !vector.checkVisited(visited, gX, gY, gZ)){
			    vector.setVisited(visited, gX, gY, gZ);
			    graph.add(new Coordinate(gX+vector.getX(),gY+vector.getY(),gZ+vector.getZ()));
			    return;
			   }
			vector = new Vector(1,-1,-1);if(vector.checkRange(coordinates, gX, gY, gZ) && !vector.checkVisited(visited, gX, gY, gZ)){
			    vector.setVisited(visited, gX, gY, gZ);
			    graph.add(new Coordinate(gX+vector.getX(),gY+vector.getY(),gZ+vector.getZ()));
			    return;
			   }
			vector = new Vector(-1,-1,1);if(vector.checkRange(coordinates, gX, gY, gZ) && !vector.checkVisited(visited, gX, gY, gZ)){
			    vector.setVisited(visited, gX, gY, gZ);
			    graph.add(new Coordinate(gX+vector.getX(),gY+vector.getY(),gZ+vector.getZ()));
			    return;
			   }
			vector = new Vector(0,-1,0);if(vector.checkRange(coordinates, gX, gY, gZ) && !vector.checkVisited(visited, gX, gY, gZ)){
			    vector.setVisited(visited, gX, gY, gZ);
			    graph.add(new Coordinate(gX+vector.getX(),gY+vector.getY(),gZ+vector.getZ()));
			    return;
			   }
		} else if (directions[3]) {
			vector = new Vector(0,-1,0);if(vector.checkRange(coordinates, gX, gY, gZ) && !vector.checkVisited(visited, gX, gY, gZ)){
			    vector.setVisited(visited, gX, gY, gZ);
			    graph.add(new Coordinate(gX+vector.getX(),gY+vector.getY(),gZ+vector.getZ()));
			    return;
			   }
			vector = new Vector(1,-1,0);if(vector.checkRange(coordinates, gX, gY, gZ) && !vector.checkVisited(visited, gX, gY, gZ)){
			    vector.setVisited(visited, gX, gY, gZ);
			    graph.add(new Coordinate(gX+vector.getX(),gY+vector.getY(),gZ+vector.getZ()));
			    return;
			   }
			vector = new Vector(-1,-1,0);if(vector.checkRange(coordinates, gX, gY, gZ) && !vector.checkVisited(visited, gX, gY, gZ)){
			    vector.setVisited(visited, gX, gY, gZ);
			    graph.add(new Coordinate(gX+vector.getX(),gY+vector.getY(),gZ+vector.getZ()));
			    return;
			   }
			vector = new Vector(0,-1,1);if(vector.checkRange(coordinates, gX, gY, gZ) && !vector.checkVisited(visited, gX, gY, gZ)){
			    vector.setVisited(visited, gX, gY, gZ);
			    graph.add(new Coordinate(gX+vector.getX(),gY+vector.getY(),gZ+vector.getZ()));
			    return;
			   }
			vector = new Vector(0,-1,-1);if(vector.checkRange(coordinates, gX, gY, gZ) && !vector.checkVisited(visited, gX, gY, gZ)){
			    vector.setVisited(visited, gX, gY, gZ);
			    graph.add(new Coordinate(gX+vector.getX(),gY+vector.getY(),gZ+vector.getZ()));
			    return;
			   }
			vector = new Vector(1,-1,1);if(vector.checkRange(coordinates, gX, gY, gZ) && !vector.checkVisited(visited, gX, gY, gZ)){
			    vector.setVisited(visited, gX, gY, gZ);
			    graph.add(new Coordinate(gX+vector.getX(),gY+vector.getY(),gZ+vector.getZ()));
			    return;
			   }
			vector = new Vector(1,-1,-1);if(vector.checkRange(coordinates, gX, gY, gZ) && !vector.checkVisited(visited, gX, gY, gZ)){
			    vector.setVisited(visited, gX, gY, gZ);
			    graph.add(new Coordinate(gX+vector.getX(),gY+vector.getY(),gZ+vector.getZ()));
			    return;
			   }
			vector = new Vector(-1,-1,1);if(vector.checkRange(coordinates, gX, gY, gZ) && !vector.checkVisited(visited, gX, gY, gZ)){
			    vector.setVisited(visited, gX, gY, gZ);
			    graph.add(new Coordinate(gX+vector.getX(),gY+vector.getY(),gZ+vector.getZ()));
			    return;
			   }
			vector = new Vector(-1,-1,-1);if(vector.checkRange(coordinates, gX, gY, gZ) && !vector.checkVisited(visited, gX, gY, gZ)){
			    vector.setVisited(visited, gX, gY, gZ);
			    graph.add(new Coordinate(gX+vector.getX(),gY+vector.getY(),gZ+vector.getZ()));
			    return;
			   }
			vector = new Vector(1,0,0);if(vector.checkRange(coordinates, gX, gY, gZ) && !vector.checkVisited(visited, gX, gY, gZ)){
			    vector.setVisited(visited, gX, gY, gZ);
			    graph.add(new Coordinate(gX+vector.getX(),gY+vector.getY(),gZ+vector.getZ()));
			    return;
			   }
			vector = new Vector(-1,0,0);if(vector.checkRange(coordinates, gX, gY, gZ) && !vector.checkVisited(visited, gX, gY, gZ)){
			    vector.setVisited(visited, gX, gY, gZ);
			    graph.add(new Coordinate(gX+vector.getX(),gY+vector.getY(),gZ+vector.getZ()));
			    return;
			   }
			vector = new Vector(0,0,1);if(vector.checkRange(coordinates, gX, gY, gZ) && !vector.checkVisited(visited, gX, gY, gZ)){
			    vector.setVisited(visited, gX, gY, gZ);
			    graph.add(new Coordinate(gX+vector.getX(),gY+vector.getY(),gZ+vector.getZ()));
			    return;
			   }
			vector = new Vector(0,0,-1);if(vector.checkRange(coordinates, gX, gY, gZ) && !vector.checkVisited(visited, gX, gY, gZ)){
			    vector.setVisited(visited, gX, gY, gZ);
			    graph.add(new Coordinate(gX+vector.getX(),gY+vector.getY(),gZ+vector.getZ()));
			    return;
			   }
			vector = new Vector(1,0,1);if(vector.checkRange(coordinates, gX, gY, gZ) && !vector.checkVisited(visited, gX, gY, gZ)){
			    vector.setVisited(visited, gX, gY, gZ);
			    graph.add(new Coordinate(gX+vector.getX(),gY+vector.getY(),gZ+vector.getZ()));
			    return;
			   }
			vector = new Vector(1,0,-1);if(vector.checkRange(coordinates, gX, gY, gZ) && !vector.checkVisited(visited, gX, gY, gZ)){
			    vector.setVisited(visited, gX, gY, gZ);
			    graph.add(new Coordinate(gX+vector.getX(),gY+vector.getY(),gZ+vector.getZ()));
			    return;
			   }
			vector = new Vector(-1,0,1);if(vector.checkRange(coordinates, gX, gY, gZ) && !vector.checkVisited(visited, gX, gY, gZ)){
			    vector.setVisited(visited, gX, gY, gZ);
			    graph.add(new Coordinate(gX+vector.getX(),gY+vector.getY(),gZ+vector.getZ()));
			    return;
			   }
			vector = new Vector(-1,0,-1);if(vector.checkRange(coordinates, gX, gY, gZ) && !vector.checkVisited(visited, gX, gY, gZ)){
			    vector.setVisited(visited, gX, gY, gZ);
			    graph.add(new Coordinate(gX+vector.getX(),gY+vector.getY(),gZ+vector.getZ()));
			    return;
			   }
			vector = new Vector(-1,1,-1);if(vector.checkRange(coordinates, gX, gY, gZ) && !vector.checkVisited(visited, gX, gY, gZ)){
			    vector.setVisited(visited, gX, gY, gZ);
			    graph.add(new Coordinate(gX+vector.getX(),gY+vector.getY(),gZ+vector.getZ()));
			    return;
			   }
			vector = new Vector(1,1,0);if(vector.checkRange(coordinates, gX, gY, gZ) && !vector.checkVisited(visited, gX, gY, gZ)){
			    vector.setVisited(visited, gX, gY, gZ);
			    graph.add(new Coordinate(gX+vector.getX(),gY+vector.getY(),gZ+vector.getZ()));
			    return;
			   }
			vector = new Vector(-1,1,0);if(vector.checkRange(coordinates, gX, gY, gZ) && !vector.checkVisited(visited, gX, gY, gZ)){
			    vector.setVisited(visited, gX, gY, gZ);
			    graph.add(new Coordinate(gX+vector.getX(),gY+vector.getY(),gZ+vector.getZ()));
			    return;
			   }
			vector = new Vector(0,1,1);if(vector.checkRange(coordinates, gX, gY, gZ) && !vector.checkVisited(visited, gX, gY, gZ)){
			    vector.setVisited(visited, gX, gY, gZ);
			    graph.add(new Coordinate(gX+vector.getX(),gY+vector.getY(),gZ+vector.getZ()));
			    return;
			   }
			vector = new Vector(0,1,-1);if(vector.checkRange(coordinates, gX, gY, gZ) && !vector.checkVisited(visited, gX, gY, gZ)){
			    vector.setVisited(visited, gX, gY, gZ);
			    graph.add(new Coordinate(gX+vector.getX(),gY+vector.getY(),gZ+vector.getZ()));
			    return;
			   }
			vector = new Vector(1,1,1);if(vector.checkRange(coordinates, gX, gY, gZ) && !vector.checkVisited(visited, gX, gY, gZ)){
			    vector.setVisited(visited, gX, gY, gZ);
			    graph.add(new Coordinate(gX+vector.getX(),gY+vector.getY(),gZ+vector.getZ()));
			    return;
			   }
			vector = new Vector(1,1,-1);if(vector.checkRange(coordinates, gX, gY, gZ) && !vector.checkVisited(visited, gX, gY, gZ)){
			    vector.setVisited(visited, gX, gY, gZ);
			    graph.add(new Coordinate(gX+vector.getX(),gY+vector.getY(),gZ+vector.getZ()));
			    return;
			   }
			vector = new Vector(-1,1,1);if(vector.checkRange(coordinates, gX, gY, gZ) && !vector.checkVisited(visited, gX, gY, gZ)){
			    vector.setVisited(visited, gX, gY, gZ);
			    graph.add(new Coordinate(gX+vector.getX(),gY+vector.getY(),gZ+vector.getZ()));
			    return;
			   }
			vector = new Vector(0,1,0);if(vector.checkRange(coordinates, gX, gY, gZ) && !vector.checkVisited(visited, gX, gY, gZ)){
			    vector.setVisited(visited, gX, gY, gZ);
			    graph.add(new Coordinate(gX+vector.getX(),gY+vector.getY(),gZ+vector.getZ()));
			    return;
			   }}
			else if (directions[4]) {
				vector = new Vector(0, 0, 1);
				if (vector.checkRange(coordinates, gX, gY, gZ)
						&& !vector.checkVisited(visited, gX, gY, gZ)) {
					vector.setVisited(visited, gX, gY, gZ);
					graph.add(new Coordinate(gX + vector.getX(),
							gY + vector.getY(), gZ + vector.getZ()));
					return;
				}
				vector = new Vector(1, 0, 1);
				if (vector.checkRange(coordinates, gX, gY, gZ)
						&& !vector.checkVisited(visited, gX, gY, gZ)) {
					vector.setVisited(visited, gX, gY, gZ);
					graph.add(new Coordinate(gX + vector.getX(),
							gY + vector.getY(), gZ + vector.getZ()));
					return;
				}
				vector = new Vector(1, -1, 1);
				if (vector.checkRange(coordinates, gX, gY, gZ)
						&& !vector.checkVisited(visited, gX, gY, gZ)) {
					vector.setVisited(visited, gX, gY, gZ);
					graph.add(new Coordinate(gX + vector.getX(),
							gY + vector.getY(), gZ + vector.getZ()));
					return;
				}
				vector = new Vector(1, 1, 1);
				if (vector.checkRange(coordinates, gX, gY, gZ)
						&& !vector.checkVisited(visited, gX, gY, gZ)) {
					vector.setVisited(visited, gX, gY, gZ);
					graph.add(new Coordinate(gX + vector.getX(),
							gY + vector.getY(), gZ + vector.getZ()));
					return;
				}
				vector = new Vector(-1, 0, 1);
				if (vector.checkRange(coordinates, gX, gY, gZ)
						&& !vector.checkVisited(visited, gX, gY, gZ)) {
					vector.setVisited(visited, gX, gY, gZ);
					graph.add(new Coordinate(gX + vector.getX(),
							gY + vector.getY(), gZ + vector.getZ()));
					return;
				}
				vector = new Vector(-1, 1, 1);
				if (vector.checkRange(coordinates, gX, gY, gZ)
						&& !vector.checkVisited(visited, gX, gY, gZ)) {
					vector.setVisited(visited, gX, gY, gZ);
					graph.add(new Coordinate(gX + vector.getX(),
							gY + vector.getY(), gZ + vector.getZ()));
					return;
				}
				vector = new Vector(-1, -1, 1);
				if (vector.checkRange(coordinates, gX, gY, gZ)
						&& !vector.checkVisited(visited, gX, gY, gZ)) {
					vector.setVisited(visited, gX, gY, gZ);
					graph.add(new Coordinate(gX + vector.getX(),
							gY + vector.getY(), gZ + vector.getZ()));
					return;
				}
				vector = new Vector(0, 1, 1);
				if (vector.checkRange(coordinates, gX, gY, gZ)
						&& !vector.checkVisited(visited, gX, gY, gZ)) {
					vector.setVisited(visited, gX, gY, gZ);
					graph.add(new Coordinate(gX + vector.getX(),
							gY + vector.getY(), gZ + vector.getZ()));
					return;
				}
				vector = new Vector(0, -1, 1);
				if (vector.checkRange(coordinates, gX, gY, gZ)
						&& !vector.checkVisited(visited, gX, gY, gZ)) {
					vector.setVisited(visited, gX, gY, gZ);
					graph.add(new Coordinate(gX + vector.getX(),
							gY + vector.getY(), gZ + vector.getZ()));
					return;
				}
				vector = new Vector(1, 0, 0);
				if (vector.checkRange(coordinates, gX, gY, gZ)
						&& !vector.checkVisited(visited, gX, gY, gZ)) {
					vector.setVisited(visited, gX, gY, gZ);
					graph.add(new Coordinate(gX + vector.getX(),
							gY + vector.getY(), gZ + vector.getZ()));
					return;
				}
				vector = new Vector(1, -1, 0);
				if (vector.checkRange(coordinates, gX, gY, gZ)
						&& !vector.checkVisited(visited, gX, gY, gZ)) {
					vector.setVisited(visited, gX, gY, gZ);
					graph.add(new Coordinate(gX + vector.getX(),
							gY + vector.getY(), gZ + vector.getZ()));
					return;
				}
				vector = new Vector(1, 1, 0);
				if (vector.checkRange(coordinates, gX, gY, gZ)
						&& !vector.checkVisited(visited, gX, gY, gZ)) {
					vector.setVisited(visited, gX, gY, gZ);
					graph.add(new Coordinate(gX + vector.getX(),
							gY + vector.getY(), gZ + vector.getZ()));
					return;
				}
				vector = new Vector(-1, 0, 0);
				if (vector.checkRange(coordinates, gX, gY, gZ)
						&& !vector.checkVisited(visited, gX, gY, gZ)) {
					vector.setVisited(visited, gX, gY, gZ);
					graph.add(new Coordinate(gX + vector.getX(),
							gY + vector.getY(), gZ + vector.getZ()));
					return;
				}
				vector = new Vector(-1, 1, 0);
				if (vector.checkRange(coordinates, gX, gY, gZ)
						&& !vector.checkVisited(visited, gX, gY, gZ)) {
					vector.setVisited(visited, gX, gY, gZ);
					graph.add(new Coordinate(gX + vector.getX(),
							gY + vector.getY(), gZ + vector.getZ()));
					return;
				}
				vector = new Vector(-1, -1, 0);
				if (vector.checkRange(coordinates, gX, gY, gZ)
						&& !vector.checkVisited(visited, gX, gY, gZ)) {
					vector.setVisited(visited, gX, gY, gZ);
					graph.add(new Coordinate(gX + vector.getX(),
							gY + vector.getY(), gZ + vector.getZ()));
					return;
				}
				vector = new Vector(0, 1, 0);
				if (vector.checkRange(coordinates, gX, gY, gZ)
						&& !vector.checkVisited(visited, gX, gY, gZ)) {
					vector.setVisited(visited, gX, gY, gZ);
					graph.add(new Coordinate(gX + vector.getX(),
							gY + vector.getY(), gZ + vector.getZ()));
					return;
				}
				vector = new Vector(0, -1, 0);
				if (vector.checkRange(coordinates, gX, gY, gZ)
						&& !vector.checkVisited(visited, gX, gY, gZ)) {
					vector.setVisited(visited, gX, gY, gZ);
					graph.add(new Coordinate(gX + vector.getX(),
							gY + vector.getY(), gZ + vector.getZ()));
					return;
				}
				vector = new Vector(0, 0, -1);
				if (vector.checkRange(coordinates, gX, gY, gZ)
						&& !vector.checkVisited(visited, gX, gY, gZ)) {
					vector.setVisited(visited, gX, gY, gZ);
					graph.add(new Coordinate(gX + vector.getX(),
							gY + vector.getY(), gZ + vector.getZ()));
					return;
				}
				vector = new Vector(1, 0, -1);
				if (vector.checkRange(coordinates, gX, gY, gZ)
						&& !vector.checkVisited(visited, gX, gY, gZ)) {
					vector.setVisited(visited, gX, gY, gZ);
					graph.add(new Coordinate(gX + vector.getX(),
							gY + vector.getY(), gZ + vector.getZ()));
					return;
				}
				vector = new Vector(1, -1, -1);
				if (vector.checkRange(coordinates, gX, gY, gZ)
						&& !vector.checkVisited(visited, gX, gY, gZ)) {
					vector.setVisited(visited, gX, gY, gZ);
					graph.add(new Coordinate(gX + vector.getX(),
							gY + vector.getY(), gZ + vector.getZ()));
					return;
				}
				vector = new Vector(1, 1, -1);
				if (vector.checkRange(coordinates, gX, gY, gZ)
						&& !vector.checkVisited(visited, gX, gY, gZ)) {
					vector.setVisited(visited, gX, gY, gZ);
					graph.add(new Coordinate(gX + vector.getX(),
							gY + vector.getY(), gZ + vector.getZ()));
					return;
				}
				vector = new Vector(-1, 0, -1);
				if (vector.checkRange(coordinates, gX, gY, gZ)
						&& !vector.checkVisited(visited, gX, gY, gZ)) {
					vector.setVisited(visited, gX, gY, gZ);
					graph.add(new Coordinate(gX + vector.getX(),
							gY + vector.getY(), gZ + vector.getZ()));
					return;
				}
				vector = new Vector(-1, 1, -1);
				if (vector.checkRange(coordinates, gX, gY, gZ)
						&& !vector.checkVisited(visited, gX, gY, gZ)) {
					vector.setVisited(visited, gX, gY, gZ);
					graph.add(new Coordinate(gX + vector.getX(),
							gY + vector.getY(), gZ + vector.getZ()));
					return;
				}
				vector = new Vector(-1, -1, -1);
				if (vector.checkRange(coordinates, gX, gY, gZ)
						&& !vector.checkVisited(visited, gX, gY, gZ)) {
					vector.setVisited(visited, gX, gY, gZ);
					graph.add(new Coordinate(gX + vector.getX(),
							gY + vector.getY(), gZ + vector.getZ()));
					return;
				}
				vector = new Vector(0, 1, -1);
				if (vector.checkRange(coordinates, gX, gY, gZ)
						&& !vector.checkVisited(visited, gX, gY, gZ)) {
					vector.setVisited(visited, gX, gY, gZ);
					graph.add(new Coordinate(gX + vector.getX(),
							gY + vector.getY(), gZ + vector.getZ()));
					return;
				}
				vector = new Vector(0, -1, -1);
				if (vector.checkRange(coordinates, gX, gY, gZ)
						&& !vector.checkVisited(visited, gX, gY, gZ)) {
					vector.setVisited(visited, gX, gY, gZ);
					graph.add(new Coordinate(gX + vector.getX(),
							gY + vector.getY(), gZ + vector.getZ()));
					return;
				}
			
			
			
			
		} else if (directions[5]) {
			vector = new Vector(0, 0, -1);
			if (vector.checkRange(coordinates, gX, gY, gZ)
					&& !vector.checkVisited(visited, gX, gY, gZ)) {
				vector.setVisited(visited, gX, gY, gZ);
				graph.add(new Coordinate(gX + vector.getX(),
						gY + vector.getY(), gZ + vector.getZ()));
				return;
			}
			vector = new Vector(-1, 0, -1);
			if (vector.checkRange(coordinates, gX, gY, gZ)
					&& !vector.checkVisited(visited, gX, gY, gZ)) {
				vector.setVisited(visited, gX, gY, gZ);
				graph.add(new Coordinate(gX + vector.getX(),
						gY + vector.getY(), gZ + vector.getZ()));
				return;
			}
			vector = new Vector(-1, 1, -1);
			if (vector.checkRange(coordinates, gX, gY, gZ)
					&& !vector.checkVisited(visited, gX, gY, gZ)) {
				vector.setVisited(visited, gX, gY, gZ);
				graph.add(new Coordinate(gX + vector.getX(),
						gY + vector.getY(), gZ + vector.getZ()));
				return;
			}
			vector = new Vector(-1, -1, -1);
			if (vector.checkRange(coordinates, gX, gY, gZ)
					&& !vector.checkVisited(visited, gX, gY, gZ)) {
				vector.setVisited(visited, gX, gY, gZ);
				graph.add(new Coordinate(gX + vector.getX(),
						gY + vector.getY(), gZ + vector.getZ()));
				return;
			}
			vector = new Vector(1, 0, -1);
			if (vector.checkRange(coordinates, gX, gY, gZ)
					&& !vector.checkVisited(visited, gX, gY, gZ)) {
				vector.setVisited(visited, gX, gY, gZ);
				graph.add(new Coordinate(gX + vector.getX(),
						gY + vector.getY(), gZ + vector.getZ()));
				return;
			}
			vector = new Vector(1, -1, -1);
			if (vector.checkRange(coordinates, gX, gY, gZ)
					&& !vector.checkVisited(visited, gX, gY, gZ)) {
				vector.setVisited(visited, gX, gY, gZ);
				graph.add(new Coordinate(gX + vector.getX(),
						gY + vector.getY(), gZ + vector.getZ()));
				return;
			}
			vector = new Vector(1, 1, -1);
			if (vector.checkRange(coordinates, gX, gY, gZ)
					&& !vector.checkVisited(visited, gX, gY, gZ)) {
				vector.setVisited(visited, gX, gY, gZ);
				graph.add(new Coordinate(gX + vector.getX(),
						gY + vector.getY(), gZ + vector.getZ()));
				return;
			}
			vector = new Vector(0, 1, -1);
			if (vector.checkRange(coordinates, gX, gY, gZ)
					&& !vector.checkVisited(visited, gX, gY, gZ)) {
				vector.setVisited(visited, gX, gY, gZ);
				graph.add(new Coordinate(gX + vector.getX(),
						gY + vector.getY(), gZ + vector.getZ()));
				return;
			}
			vector = new Vector(0, -1, -1);
			if (vector.checkRange(coordinates, gX, gY, gZ)
					&& !vector.checkVisited(visited, gX, gY, gZ)) {
				vector.setVisited(visited, gX, gY, gZ);
				graph.add(new Coordinate(gX + vector.getX(),
						gY + vector.getY(), gZ + vector.getZ()));
				return;
			}
			vector = new Vector(-1, 0, 0);
			if (vector.checkRange(coordinates, gX, gY, gZ)
					&& !vector.checkVisited(visited, gX, gY, gZ)) {
				vector.setVisited(visited, gX, gY, gZ);
				graph.add(new Coordinate(gX + vector.getX(),
						gY + vector.getY(), gZ + vector.getZ()));
				return;
			}
			vector = new Vector(-1, 1, 0);
			if (vector.checkRange(coordinates, gX, gY, gZ)
					&& !vector.checkVisited(visited, gX, gY, gZ)) {
				vector.setVisited(visited, gX, gY, gZ);
				graph.add(new Coordinate(gX + vector.getX(),
						gY + vector.getY(), gZ + vector.getZ()));
				return;
			}
			vector = new Vector(-1, -1, 0);
			if (vector.checkRange(coordinates, gX, gY, gZ)
					&& !vector.checkVisited(visited, gX, gY, gZ)) {
				vector.setVisited(visited, gX, gY, gZ);
				graph.add(new Coordinate(gX + vector.getX(),
						gY + vector.getY(), gZ + vector.getZ()));
				return;
			}
			vector = new Vector(1, 0, 0);
			if (vector.checkRange(coordinates, gX, gY, gZ)
					&& !vector.checkVisited(visited, gX, gY, gZ)) {
				vector.setVisited(visited, gX, gY, gZ);
				graph.add(new Coordinate(gX + vector.getX(),
						gY + vector.getY(), gZ + vector.getZ()));
				return;
			}
			vector = new Vector(1, -1, 0);
			if (vector.checkRange(coordinates, gX, gY, gZ)
					&& !vector.checkVisited(visited, gX, gY, gZ)) {
				vector.setVisited(visited, gX, gY, gZ);
				graph.add(new Coordinate(gX + vector.getX(),
						gY + vector.getY(), gZ + vector.getZ()));
				return;
			}
			vector = new Vector(1, 1, 0);
			if (vector.checkRange(coordinates, gX, gY, gZ)
					&& !vector.checkVisited(visited, gX, gY, gZ)) {
				vector.setVisited(visited, gX, gY, gZ);
				graph.add(new Coordinate(gX + vector.getX(),
						gY + vector.getY(), gZ + vector.getZ()));
				return;
			}
			vector = new Vector(0, 1, 0);
			if (vector.checkRange(coordinates, gX, gY, gZ)
					&& !vector.checkVisited(visited, gX, gY, gZ)) {
				vector.setVisited(visited, gX, gY, gZ);
				graph.add(new Coordinate(gX + vector.getX(),
						gY + vector.getY(), gZ + vector.getZ()));
				return;
			}
			vector = new Vector(0, -1, 0);
			if (vector.checkRange(coordinates, gX, gY, gZ)
					&& !vector.checkVisited(visited, gX, gY, gZ)) {
				vector.setVisited(visited, gX, gY, gZ);
				graph.add(new Coordinate(gX + vector.getX(),
						gY + vector.getY(), gZ + vector.getZ()));
				return;
			}
			vector = new Vector(0, 0, 1);
			if (vector.checkRange(coordinates, gX, gY, gZ)
					&& !vector.checkVisited(visited, gX, gY, gZ)) {
				vector.setVisited(visited, gX, gY, gZ);
				graph.add(new Coordinate(gX + vector.getX(),
						gY + vector.getY(), gZ + vector.getZ()));
				return;
			}
			vector = new Vector(-1, 0, 1);
			if (vector.checkRange(coordinates, gX, gY, gZ)
					&& !vector.checkVisited(visited, gX, gY, gZ)) {
				vector.setVisited(visited, gX, gY, gZ);
				graph.add(new Coordinate(gX + vector.getX(),
						gY + vector.getY(), gZ + vector.getZ()));
				return;
			}
			vector = new Vector(-1, 1, 1);
			if (vector.checkRange(coordinates, gX, gY, gZ)
					&& !vector.checkVisited(visited, gX, gY, gZ)) {
				vector.setVisited(visited, gX, gY, gZ);
				graph.add(new Coordinate(gX + vector.getX(),
						gY + vector.getY(), gZ + vector.getZ()));
				return;
			}
			vector = new Vector(-1, -1, 1);
			if (vector.checkRange(coordinates, gX, gY, gZ)
					&& !vector.checkVisited(visited, gX, gY, gZ)) {
				vector.setVisited(visited, gX, gY, gZ);
				graph.add(new Coordinate(gX + vector.getX(),
						gY + vector.getY(), gZ + vector.getZ()));
				return;
			}
			vector = new Vector(1, 0, 1);
			if (vector.checkRange(coordinates, gX, gY, gZ)
					&& !vector.checkVisited(visited, gX, gY, gZ)) {
				vector.setVisited(visited, gX, gY, gZ);
				graph.add(new Coordinate(gX + vector.getX(),
						gY + vector.getY(), gZ + vector.getZ()));
				return;
			}
			vector = new Vector(1, -1, 1);
			if (vector.checkRange(coordinates, gX, gY, gZ)
					&& !vector.checkVisited(visited, gX, gY, gZ)) {
				vector.setVisited(visited, gX, gY, gZ);
				graph.add(new Coordinate(gX + vector.getX(),
						gY + vector.getY(), gZ + vector.getZ()));
				return;
			}
			vector = new Vector(1, 1, 1);
			if (vector.checkRange(coordinates, gX, gY, gZ)
					&& !vector.checkVisited(visited, gX, gY, gZ)) {
				vector.setVisited(visited, gX, gY, gZ);
				graph.add(new Coordinate(gX + vector.getX(),
						gY + vector.getY(), gZ + vector.getZ()));
				return;
			}
			vector = new Vector(0, 1, 1);
			if (vector.checkRange(coordinates, gX, gY, gZ)
					&& !vector.checkVisited(visited, gX, gY, gZ)) {
				vector.setVisited(visited, gX, gY, gZ);
				graph.add(new Coordinate(gX + vector.getX(),
						gY + vector.getY(), gZ + vector.getZ()));
				return;
			}
			vector = new Vector(0, -1, 1);
			if (vector.checkRange(coordinates, gX, gY, gZ)
					&& !vector.checkVisited(visited, gX, gY, gZ)) {
				vector.setVisited(visited, gX, gY, gZ);
				graph.add(new Coordinate(gX + vector.getX(),
						gY + vector.getY(), gZ + vector.getZ()));
				return;
			}
		} 
			
		graph.pop();
			

	}
}
