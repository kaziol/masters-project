package mgr;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.imageio.ImageIO;

public class Picture {

	// dodawanie bialych pixeli do listy
	public Picture(List<Coordinate> listCoord, BufferedImage image) {
		super();
		this.listCoord = listCoord;
		img = image;
	}

	public Picture(String filePath) {
		listCoord = new ArrayList<Coordinate>();
		try {
			img = ImageIO.read(new File(filePath));
			for (int x = 0; x < img.getWidth(); x++) {
				for (int y = 0; y < img.getHeight(); y++) {
					if (img.getRGB(x, y) == Color.WHITE.getRGB()) {
						listCoord.add(new Coordinate(x, y, picNumber));
					}
				}
			}
			img.flush();
		} catch (Exception e) {
			System.out.print(e);
		}
		picNumber++;
		width = img.getWidth();
		height = img.getHeight();
	}

	private List<Coordinate> listCoord;
	private static int picNumber = 0;
	private static int width = 0;
	private static int height = 0;
	private BufferedImage img = null;

	@SuppressWarnings("static-access")
	public int getDepth() {
		return this.picNumber;
	}

	@SuppressWarnings("static-access")
	public int getWidth() {
		return this.width;
	}

	@SuppressWarnings("static-access")
	public int getHeight() {
		return this.height;
	}

	public List<Coordinate> getListCoord() {
		return listCoord;
	}

	public void setListCoord(List<Coordinate> listCoord) {
		this.listCoord = listCoord;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((listCoord == null) ? 0 : listCoord.hashCode());
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
		Picture other = (Picture) obj;
		if (listCoord == null) {
			if (other.listCoord != null)
				return false;
		} else if (!listCoord.equals(other.listCoord))
			return false;
		return true;
	}

	private static Map<Coordinate, Integer> colorMap = new HashMap<Coordinate, Integer>();
	private static int maxZ = 0;

	public static void addPath(Graph graph) {
		int r, g, b;
		Random rand = new Random();
		r = rand.nextInt(253) + 1;
		g = rand.nextInt(253) + 1;
		b = rand.nextInt(253) + 1;
		Color rgb = new Color(r, g, b);
		int color = rgb.getRGB();
		for (Coordinate coord : graph.getVisitedNodesList()) {
			colorMap.put(coord, color);
			maxZ = maxZ < coord.getZ() ? coord.getZ() : maxZ;
		}
	}

	public static void addPore(Pore pore) {
		int r, g, b;
		Random rand = new Random();
		r = rand.nextInt(253) + 1;
		g = rand.nextInt(253) + 1;
		b = rand.nextInt(253) + 1;
		Color rgb = new Color(r, g, b);
		int color = rgb.getRGB();
		for (Coordinate coord : pore.get()) {
			colorMap.put(coord, color);
			maxZ = maxZ < coord.getZ() ? coord.getZ() : maxZ;
		}
	}

	public static void paint(String[] fileList, String folderPath, String dir) {
		BufferedImage img = null;
		for (int i = 0; i < fileList.length; i++) {

			ImageIO.setUseCache(false);
			File imageFile = new File(folderPath + "\\" + fileList[i]);
			File imageFileOutput = new File(folderPath + "\\"
					+ fileList[i].substring(0, fileList[i].lastIndexOf('.'))
					+ dir
					+ fileList[i].substring(fileList[i].lastIndexOf('.') + 1));
			String extension = new String(imageFile.getName().substring(
					1 + imageFile.getName().lastIndexOf('.')));
			try {
				img = ImageIO.read(imageFile);
				for (Coordinate coord : colorMap.keySet()) {
					if (coord.getZ() == i) {
						synchronized (img) {
							img.setRGB(coord.getX(), coord.getY(),
									colorMap.get(coord));
						}
					}
				}
				img.flush();
				ImageIO.write(img, extension, imageFileOutput);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}
}

/*
 * public static void paintPaths(Graph graph, String[] fileList, String
 * folderPath) { BufferedImage img; int r, g, b; Random rand = new Random(); r =
 * rand.nextInt(253) + 1; g = rand.nextInt(253) + 1; b = rand.nextInt(253) + 1;
 * Color rgb = new Color(r, g, b); int color = rgb.getRGB(); String filename =
 * null; for (Coordinate coord : graph.getVisitedNodesList()) { try {
 * 
 * ImageIO.setUseCache(false); File imageFile = new File(folderPath + "\\" +
 * fileList[coord.getZ()]); imageFile.getParentFile().mkdirs(); filename =
 * imageFile.getName(); img = ImageIO.read(imageFile); img.setRGB(coord.getX(),
 * coord.getY(), color); String extension = new
 * String(imageFile.getName().substring(1 +
 * imageFile.getName().lastIndexOf('.'))); if (imageFile.canWrite() &&
 * imageFile.exists()) { ImageIO.write(img, extension, imageFile); img.flush();
 * } else System.out.println("NIE MOZNA ZAPISAC!");
 * System.out.println("Pokolorowano pixel"); } catch (IOException e) {
 * e.getStackTrace(); System.exit(-1); }
 * 
 * } }
 */

