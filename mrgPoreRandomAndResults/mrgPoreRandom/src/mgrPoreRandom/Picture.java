package mgrPoreRandom;

/**
 * Created by Michal-Desktop on 15.12.2016.
 */
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import javax.imageio.ImageIO;

public class Picture {
    private boolean[][][] coordinates;
    private int width;
    private int height;
    private int depth;
    int coordCount = 0;
    private Map<Coordinate, Integer> colorMap = new HashMap<Coordinate, Integer>();

    public int getCoordCount() {
        return this.coordCount;
    }

    public Picture(String folderPath, String[] files) {
        File currentFile = null;
        try {
            currentFile = new File(folderPath + "\\" + files[0]);
            BufferedImage img = ImageIO.read(currentFile);
            this.width = img.getWidth();
            this.height = img.getHeight();
            this.depth = files.length;
            this.coordinates = new boolean[this.width][this.height][this.depth];
            for (int i = 0; i < files.length; ++i) {
                currentFile = new File(folderPath + "\\" + files[i]);
                img = ImageIO.read(currentFile);
                for (int x = 0; x < img.getWidth(); ++x) {
                    for (int y = 0; y < img.getHeight(); ++y) {
                        if (img.getRGB(x, y) == Color.WHITE.getRGB()) {
                            this.coordinates[x][y][i] = true;
                            ++this.coordCount;
                            continue;
                        }
                        this.coordinates[x][y][i] = false;
                    }
                }
                img.flush();
            }
        }
        catch (IOException | NullPointerException e) {
            e.printStackTrace();
            System.out.println("Nieudana proba odczytu " + currentFile.getName());
            System.exit(-1);
        }
    }

    public void paint(String[] fileList, String folderPath, String dir) {
        for (int i = 0; i < fileList.length; ++i) {
            ImageIO.setUseCache(false);
            File imageFile = new File(folderPath + "\\" + fileList[i]);
            File imageFileOutput = new File(folderPath + "\\" + dir + fileList[i].substring(0, fileList[i].lastIndexOf(46)) + fileList[i].substring(fileList[i].lastIndexOf(46)));
            String extension = new String(imageFile.getName().substring(1 + imageFile.getName().lastIndexOf(46)));
            try {
                BufferedImage img = ImageIO.read(imageFile);
                BufferedImage imgOut = new BufferedImage(img.getWidth(), img.getHeight(), 1);
                for (int x = 0; x < img.getWidth(); ++x) {
                    for (int y = 0; y < img.getHeight(); ++y) {
                        imgOut.setRGB(x, y, img.getRGB(x, y));
                    }
                }
                for (Coordinate coord : this.colorMap.keySet()) {
                    if (coord.getZ() != i) continue;
                    imgOut.setRGB(coord.getX(), coord.getY(), this.colorMap.get(coord));
                }
                img.flush();
                ImageIO.write((RenderedImage)imgOut, extension, imageFileOutput);
                continue;
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public boolean[][][] getCoordinates() {
        return this.coordinates;
    }

    public int getWidth() {
        return this.width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return this.height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getDepth() {
        return this.depth;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }
}