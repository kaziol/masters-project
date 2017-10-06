package mgr;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CalcPaths {

	public static void paths() throws IOException {
		int numberOfGraphs = 0;
		List<Coordinate> allCoordinateList = new ArrayList<Coordinate>();
		Scanner scan = new Scanner(System.in);
		System.out.println("Podaj sciezke do folderu z plikami graficznymi:");
		String folderPath = scan.next();
		// String folderPath=new
		// String("C:/Users/Michal-Desktop/Desktop/jar/obrazy2");
		File folder = new File(folderPath);
		String[] listOfFiles = folder.list();
		Picture pic = null;
		String dir = null;
		for (String path : listOfFiles) {
			pic = new Picture(folder.getAbsolutePath() + "\\" + path);
			allCoordinateList.addAll(pic.getListCoord());
			System.out
					.println("Dodano koordynaty: " + allCoordinateList.size());
		}
		// ustalenie warunku dla jakiego przechodzimy z punktu do punktu
		boolean[] directions = new boolean[6];
		boolean leftright = false;
		boolean rightleft = false;
		boolean topbottom = false;
		boolean bottomtop = false;
		boolean updown = false;
		boolean downup = false;

		int startingPoints = pic.getDepth();
		int startWidth = -1;
		int endWidth = -1;
		int startHeight = -1;
		int endHeight = -1;
		int startDepth = -1;
		int endDepth = -1;
		System.out
				.println("Wybierz opcje: \n1. Lewa - prawa\n2. Prawa - lewa\n3. Gora- dol\n4. Dol - Gora\n5. Wierzch - dno\n6. Dno - wierzch");

		int choice = scan.nextInt();
		scan.close();
		switch (choice) {
		case 1:
			leftright = true;
			endWidth = pic.getWidth() - 1;
			startWidth = 0;
			dir = "LR.";
			startingPoints *= pic.getHeight();
			break;
		case 2:
			rightleft = true;
			startWidth = pic.getWidth() - 1;
			endWidth = 0;
			dir = "RL.";
			startingPoints *= pic.getHeight();
			break;
		case 3:
			updown = true;
			endHeight = pic.getHeight() - 1;
			startHeight = 0;
			dir = "UD.";
			startingPoints *= pic.getWidth();
			break;
		case 4:
			downup = true;
			startHeight = pic.getHeight() - 1;
			endHeight = 0;
			dir = "DU.";
			startingPoints *= pic.getHeight();
			break;
		case 5:
			topbottom = true;
			endDepth = pic.getDepth() - 1;
			startDepth = 0;
			dir = "TB.";
			startingPoints = pic.getHeight() * pic.getWidth();
			break;
		case 6:
			bottomtop = true;
			startDepth = pic.getDepth() - 1;
			endDepth = 0;
			dir = "BT.";
			startingPoints = pic.getHeight() * pic.getWidth();
			break;
		}
		directions[0] = leftright;
		directions[1] = rightleft;
		directions[2] = topbottom;
		directions[3] = bottomtop;
		directions[4] = updown;
		directions[5] = downup;
		List<Coordinate> startCoords = new ArrayList<Coordinate>();
		List<Coordinate> finishCoords = new ArrayList<Coordinate>();
		for (Coordinate coord : allCoordinateList) {
			if (leftright || rightleft) {
				if (coord.getX() == startWidth) {
					startCoords.add(coord);
				}
				if (coord.getX() == endWidth) {
					finishCoords.add(coord);
				}
			}
			if (updown || downup) {
				if (coord.getY() == startHeight) {
					startCoords.add(coord);
				}
				if (coord.getY() == endHeight) {
					finishCoords.add(coord);
				}
			}
			if (bottomtop || topbottom) {
				if (coord.getZ() == startDepth) {
					startCoords.add(coord);
				}
				if (coord.getZ() == endDepth) {
					finishCoords.add(coord);
				}
			}

		}
		int iters = finishCoords.size() * startCoords.size();
		System.out.println("Wszystkich iteracji : " + iters);
		PrintStream ps_console = System.out;
		for (Coordinate currentNode : startCoords) {

			Graph graf = null;
			DistanceMap mapDistance = new DistanceMap(currentNode,
					allCoordinateList);
			// DistnaceMap.printMap(mapDistance);
			System.out
					.println("Utworzono mape. Przygotowuje sie do utworzenia grafu:");
			for (Coordinate finishNode : finishCoords) {
				System.setOut(ps_console);
				try {

					Graph grafResult = new Graph(currentNode, finishNode,
							mapDistance, directions);
					if (!grafResult.getVisitedNodesList().isEmpty()
							&& (graf == null || graf.getVisitedNodesList()
									.size() > grafResult.getVisitedNodesList()
									.size())) {
						graf = grafResult;
					} else if (!grafResult.getVisitedNodesList().isEmpty()
							&& graf.getVisitedNodesList().size() == grafResult
									.getVisitedNodesList().size()
							&& grafResult.directionChanges(directions) < graf
									.directionChanges(directions)) {
						graf = grafResult;
					}

				} catch (NullPointerException ex) {
					System.setOut(ps_console);
				}

			}
			if (graf != null) {
				System.out.println("Utworzono graf z elementow "
						+ graf.getVisitedNodesList().size());

				PrintStream out1 = new PrintStream(new FileOutputStream(
						folderPath + "/output" + numberOfGraphs + dir + "txt"));
				// System.out.println("Zapisuje do pliku");
				System.setOut(out1);
				for (Coordinate gcoord : graf.getVisitedNodesList()) {
					out1.println(gcoord.getX() + " " + gcoord.getY() + " "
							+ gcoord.getZ());
				}
				out1.close();
				System.setOut(ps_console);
				numberOfGraphs++;
				// graf.paintPaths(listOfFiles, folderPath);
				// Picture.paintPaths(graf, listOfFiles, folderPath);
				Picture.addPath(graf);
				allCoordinateList.removeAll(graf.getVisitedNodesList());
			}
		}
		Picture.paint(listOfFiles, folderPath, "result.");
		PrintStream outSummary = new PrintStream(new FileOutputStream(
				folderPath + "/Summary" + numberOfGraphs + dir + "txt"));
		outSummary
				.println("Utworzono " + numberOfGraphs + "/" + startingPoints);
		outSummary.close();
		System.setOut(ps_console);
		System.out.println("Koniec programu. Utworzono " + numberOfGraphs
				+ " sciezek.");
	}

}
