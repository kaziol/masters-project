package mgrDFS;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.imageio.ImageIO;

public class Picture {
	private boolean[][][] coordinates;
	private int width, height, depth;

	public Picture(String folderPath, String[] files) {
		BufferedImage img;
		File currentFile=null;
		try {
			currentFile=new File(folderPath + "\\" + files[0]);
			img = ImageIO.read(currentFile);
			width = img.getWidth();
			height = img.getHeight();
			depth = files.length;
			coordinates = new boolean[width][height][depth];
			for (int i = 0; i < files.length; i++) {
					currentFile=new File(folderPath + "\\" + files[i]);
					img = ImageIO.read(currentFile);
					for (int x = 0; x < img.getWidth(); x++) {
						for (int y = 0; y < img.getHeight(); y++) {
							if (img.getRGB(x, y) == Color.WHITE.getRGB()) {
								coordinates[x][y][i] = true;
							} else {
								coordinates[x][y][i] = false;
							}

						}

					}
					img.flush();
			}
		} catch (IOException | NullPointerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Nieudana proba odczytu " + currentFile.getName());
			System.exit(-1);
		}
	}

	private Map<Coordinate, Integer> colorMap = new HashMap<Coordinate, Integer>();

	public void addPath(Graph graph) {
		int r, g, b;
		Random rand = new Random();
		r = rand.nextInt(253) + 1;
		g = rand.nextInt(253) + 1;
		b = rand.nextInt(253) + 1;
		Color rgb = new Color(r, g, b);
		int color = rgb.getRGB();
		for (Coordinate coord : graph.getGraph()) {
			colorMap.put(coord, color);
		}
	}

	public void paint(String[] fileList, String folderPath, String dir) {
		BufferedImage img = null;
		for (int i = 0; i < fileList.length; i++) {

			ImageIO.setUseCache(false);
			File imageFile = new File(folderPath + "\\" + fileList[i]);
			File imageFileOutput = new File(
					folderPath + "\\" + dir + fileList[i].substring(0, fileList[i].lastIndexOf('.'))
							+ fileList[i].substring(fileList[i].lastIndexOf('.')));
			String extension = new String(imageFile.getName().substring(1 + imageFile.getName().lastIndexOf('.')));
			try {
				img = ImageIO.read(imageFile);
				for (Coordinate coord : colorMap.keySet()) {
					if (coord.getZ() == i) {
						img.setRGB(coord.getX(), coord.getY(), colorMap.get(coord));
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

	public boolean[][][] getCoordinates() {
		return coordinates;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getDepth() {
		return depth;
	}

	public void setDepth(int depth) {
		this.depth = depth;
	}

}