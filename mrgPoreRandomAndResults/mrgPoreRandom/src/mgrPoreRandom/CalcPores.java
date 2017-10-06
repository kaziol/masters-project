package mgrPoreRandom;


import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;



public class CalcPores {
    private String folderPath;
    private String[] listOfFiles;
    boolean[][][] coordinates;
    boolean[][][] visited;
    Picture pic;
    int x;
    int y;
    int z;
    List<Coordinate> deltaList = new ArrayList<Coordinate>();

    public List<Coordinate> getDeltaList() {
        return this.deltaList;
    }

    public CalcPores(String _folderPath, String[] _listOfFiles, int totalLimit) {
        this.folderPath = _folderPath;
        this.listOfFiles = _listOfFiles;
        File folder = new File(this.folderPath);
        Object dir = null;
        this.pic = new Picture(folder.getAbsolutePath(), this.listOfFiles);
        this.coordinates = this.pic.getCoordinates();
        this.visited = new boolean[this.pic.getWidth()][this.pic.getHeight()][this.pic.getDepth()];
        Random rnd = new Random();
        int i = 0;
        totalLimit *= this.pic.getCoordCount()/100;
        while (i < totalLimit ) {
            do {
                this.x = rnd.nextInt(this.pic.getWidth());
                this.y = rnd.nextInt(this.pic.getHeight());
                this.z = rnd.nextInt(this.pic.getDepth());
            } while (!this.coordinates[this.x][this.y][this.z] && !this.visited[this.x][this.y][this.z] && ++i < totalLimit);
            if (!this.coordinates[this.x][this.y][this.z] || this.visited[this.x][this.y][this.z]) continue;
            Thread[] threadArray = new Thread[6];
            ToTheLimit[] toTheLimits = new ToTheLimit[]{new ToTheLimit(1, 0, 0), new ToTheLimit(-1, 0, 0), new ToTheLimit(0, 1, 0), new ToTheLimit(0, -1, 0), new ToTheLimit(0, 0, 1), new ToTheLimit(0, 0, -1)};
            for (int threadNumber = 0; threadNumber < 6; ++threadNumber) {
                threadArray[threadNumber] = new Thread(toTheLimits[threadNumber]);
                threadArray[threadNumber].run();
            }
            for (Thread thread : threadArray) {
                try {
                    thread.join();
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            int deltaX = toTheLimits[0].count + toTheLimits[1].count - 1;
            int deltaY = toTheLimits[2].count + toTheLimits[3].count - 1;
            int deltaZ = toTheLimits[4].count + toTheLimits[5].count - 1;
            this.deltaList.add(new Coordinate(deltaX, deltaY, deltaZ));
        }
    }

    private class ToTheLimit
            implements Runnable {
        int orgX;
        int orgY;
        int orgZ;
        int dx;
        int dy;
        int dz;
        int count;

        public int getCount() {
            return this.count;
        }

        public ToTheLimit(int dx, int dy, int dz) {
            this.dx = dx;
            this.dy = dy;
            this.dz = dz;
            this.count = 0;
            this.orgX = CalcPores.this.x;
            this.orgY = CalcPores.this.y;
            this.orgZ = CalcPores.this.z;
        }

        @Override
        public void run() {
            try {
                while (CalcPores.this.coordinates[this.orgX][this.orgY][this.orgZ]) {
                    this.orgX += this.dx;
                    this.orgY += this.dy;
                    this.orgZ += this.dz;
                    ++this.count;
                    CalcPores.this.visited[this.orgX][this.orgY][this.orgZ] = true;
                }
            }
            catch (ArrayIndexOutOfBoundsException var1_1) {
                // empty catch block
            }
        }
    }

}