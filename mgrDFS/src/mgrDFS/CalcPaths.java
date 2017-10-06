package mgrDFS;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class CalcPaths implements Runnable{
	private static int threadNo=0;
	private final int threadIndex;
	private String folderPath;
	private String[] listOfFiles;
	public CalcPaths(String _folderPath, String[] _listOfFiles){
		folderPath=_folderPath;
		listOfFiles=_listOfFiles;
		threadIndex=++threadNo;
		System.out.println("Wystartowano watek nr " + threadIndex);
	}
	public void paths() throws IOException {
		//Scanner scan = new Scanner(System.in);
		//System.out.println("Podaj sciezke do folderu z plikami graficznymi:");
		//String folderPath = scan.next();
		// String folderPath=new
		// String("C:/Users/Michal-Desktop/Desktop/jar/obrazy2");
		File folder = new File(folderPath);
		//String[] listOfFiles = folder.list();
		Picture pic = null;
		String dir = null;
		pic = new Picture(folder.getAbsolutePath(), listOfFiles);
		boolean[][][] coordinates = pic.getCoordinates();
		boolean[][][] visited = new boolean[pic.getWidth()][pic.getHeight()][pic
				.getDepth()];
		// ustalenie warunku dla jakiego przechodzimy z punktu do punktu
		boolean[] directions = new boolean[6];
		boolean leftright = false;
		boolean rightleft = false;
		boolean topbottom = false;
		boolean bottomtop = false;
		boolean updown = false;
		boolean downup = false;
		int inletSize=0;
		int startingPoints = 0;
		int startWidth = -1;
		int endWidth = -1;
		int startHeight = -1;
		int endHeight = -1;
		int startDepth = -1;
		int endDepth = -1;
		//System.out
		//		.println("Wybierz opcje: \n1. Lewa - prawa\n2. Prawa - lewa\n3. Gora- dol\n4. Dol - Gora\n5. Wierzch - dno\n6. Dno - wierzch");
		System.out.println("Wczytano koordynaty dla watku numer :" + threadIndex);
		int choice = threadIndex;
		//scan.close();
		switch (choice) {
		case 1:
			leftright = true;
			inletSize=pic.getHeight()*pic.getDepth();
			endWidth = pic.getWidth() - 1;
			startWidth = 0;
			dir = "LR";
			break;
		case 2:
			rightleft = true;
			inletSize=pic.getHeight()*pic.getDepth();
			startWidth = pic.getWidth() - 1;
			endWidth = 0;
			dir = "RL";
			break;
		case 3:
			updown = true;
			inletSize=pic.getWidth()*pic.getDepth();
			endHeight = pic.getHeight() - 1;
			startHeight = 0;
			dir = "UD";
			break;
		case 4:
			downup = true;
			inletSize=pic.getWidth()*pic.getDepth();
			startHeight = pic.getHeight() - 1;
			endHeight = 0;
			dir = "DU";
			break;
		case 5:
			topbottom = true;
			inletSize=pic.getWidth()*pic.getHeight();
			endDepth = pic.getDepth() - 1;
			startDepth = 0;
			dir = "TB";
			break;
		case 6:
			bottomtop = true;
			inletSize=pic.getWidth()*pic.getHeight();
			startDepth = pic.getDepth() - 1;
			endDepth = 0;
			dir = "BT";
			break;
		}
		directions[0] = leftright;
		directions[1] = rightleft;
		directions[2] = updown;
		directions[3] = downup;
		directions[4] = topbottom;
		directions[5] = bottomtop;
		PrintStream outFile;
		int i = 0;
		int graphSize=0;
		for (int z = 0; z < pic.getDepth(); z++) {
			for (int y = 0; y < pic.getHeight(); y++) {
				for (int x = 0; x < pic.getWidth(); x++) {
					if (coordinates[x][y][z]
							&& !visited[x][y][z]
							&& (x == startWidth || y == startHeight || z == startDepth)) {
						startingPoints++;
						Graph graph = new Graph(new Coordinate(x, y, z),
								coordinates, visited);
						do {
							graph.move(directions);
						} while (!graph.isEmpty()
								&& !(graph.getX() == endWidth
										|| graph.getY() == endHeight || graph
										.getZ() == endDepth));
						if (!graph.isEmpty()) {
							//System.out.println("Utworzono graf");
							try {
								i++;
								graphSize+=graph.getGraph().size();
								outFile = new PrintStream(new FileOutputStream(
										folderPath + "/Graph"  + dir+ i
												+ ".txt"));
								outFile.println("Graf numer " + i);
								for (Coordinate coord : graph.getGraph()) {
									pic.addPath(graph);
									outFile.println(coord.getX() + " "
											+ coord.getY() + " " + coord.getZ());
								}
								outFile.flush();
								//outFile.close();
							} catch (Exception ex) {
								ex.printStackTrace();
							}

						}
					}
				}
			}

		}
		pic.paint(listOfFiles, folderPath, dir);
		PrintStream summary=new PrintStream(new FileOutputStream(
										folderPath + "/Summary" + dir
												+ ".txt"));
		summary.println("Utworzono: " +i + " sciezek. " + "Sumaryczny rozmiar wszystkich grafow " + graphSize +". Punktow wlotowych: " + startingPoints +". Wielkosc scianki wlotowej " + inletSize);
		summary.flush();
		summary.close();
		PrintStream con=new PrintStream(System.out);
		con.println("Koniec watku numer " + threadIndex);
		//summary.close();
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			paths();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Przerwano watek nr " + threadIndex);
		}
	}
	
	
}
