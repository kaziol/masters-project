package mgr;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CalcPores {
	public static void pores() {
		List<Coordinate> allCoordinateList = new ArrayList<Coordinate>();
		Scanner scan = new Scanner(System.in);
		System.out.println("Podaj sciezke do folderu z plikami graficznymi:");
		String folderPath = scan.next();
		scan.close();
		File folder = new File(folderPath);
		String[] listOfFiles = folder.list();
		Picture pic = null;
		for (String path : listOfFiles) {
			pic = new Picture(folder.getAbsolutePath() + "\\" + path);
			allCoordinateList.addAll(pic.getListCoord());
			System.out
					.println("Dodano koordynaty: " + allCoordinateList.size());
		}
		List<Pore> poreList = new ArrayList<Pore>();
		while (!allCoordinateList.isEmpty()) {
			Coordinate coord = allCoordinateList.get(0);
			Pore pore = new Pore(coord);
			poreList.add(pore);
			boolean loopBroken;
			do {
				loopBroken = false;
				Coordinate inLoop = null;
				for (Coordinate coord2 : allCoordinateList) {
					if (pore.inRange(coord2)) {
						pore.add(coord2);
						inLoop = coord2;
						loopBroken = true;
						break;
					}
				}
				allCoordinateList.remove(inLoop);
				// System.out.println("Zostalo " + allCoordinateList.size());
			} while (loopBroken);
			allCoordinateList.remove(coord);
			Picture.addPore(pore);
			// .out.println("ZOSTALO :" + allCoordinateList.size());
		}
		String dir = new String("result.");
		Picture.paint(listOfFiles, folderPath, dir);
		System.out.println("Stworzono porow: " + poreList.size());
		System.out.println("Rozmiar\tdeltaX\tdeltaY\tdeltaZ");
		for (Pore pore : poreList) {
			System.out.println(pore.size() + "\t" + pore.getX() + "\t"
					+ pore.getY() + "\t" + pore.getZ());
		}
	}
}
