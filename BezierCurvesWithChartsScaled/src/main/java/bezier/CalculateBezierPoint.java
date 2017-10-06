package bezier;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Majkel on 07.01.2017.
 */
public class CalculateBezierPoint {
    public final int POINTS_PER_SEGMENT = 4;
    private static int udc, duc, lrc, rlc, tbc, btc;
    private static double ud, du, lr, rl, tb, bt;
    private double calculatedLength;
    private double calculatedInitialSize;
    private double bezierLength;
    List<Coordinate> bezierPoints = new ArrayList<Coordinate>();
    List<Coordinate> calculatedPoints;
    public List<Coordinate> getBezierPoints() {
        return bezierPoints;
    }

    public CalculateBezierPoint(List<Coordinate> calculatedPoints) {
        this.calculatedPoints = calculatedPoints;
        calculatedLength=calculateDistance(calculatedPoints);
        calculatedInitialSize=calculatedPoints.size();
       // addPoints();
       // bezierLength = calculateDistance(bezierPoints);
        bezierLength=calculateDistance(calculatedPoints);
    }



    public double getBezierLength() {
        return bezierLength;
    }



    public Coordinate calculatePoint(double t, Coordinate P0, Coordinate P1, Coordinate P2, Coordinate P3) {
        double polynominal[] = new double[4];
        polynominal[0] = Math.pow(1 - t, 3);
        polynominal[1] = Math.pow(1 - t, 2) * 3 * t;
        polynominal[2] = 3 * (1 - t) * t * t;
        polynominal[3] = Math.pow(t, 3);
        double x, y, z;
        x = P0.getX() * polynominal[0] + P1.getX() * polynominal[1] + P2.getX() * polynominal[2] + P3.getX() * polynominal[3];
        y = P0.getY() * polynominal[0] + P1.getY() * polynominal[1] + P2.getY() * polynominal[2] + P3.getY() * polynominal[3];
        z = P0.getZ() * polynominal[0] + P1.getZ() * polynominal[1] + P2.getZ() * polynominal[2] + P3.getZ() * polynominal[3];
        return new Coordinate(x, y, z);
    }

    private Coordinate[] getTwoTangents(double scale, Coordinate p1, Coordinate p2, Coordinate p3) {
        try {
            Coordinate tangent = new Coordinate(
                    p3.getX() - p1.getX(),
                    p3.getY() - p1.getY(),
                    p3.getZ() - p1.getZ()

            );
            Coordinate q0 = new Coordinate(
                    p2.getX() - scale * tangent.getX(),
                    p2.getY() - scale * tangent.getY(),
                    p2.getZ() - scale * tangent.getZ());

            Coordinate q1 = new Coordinate(
                    p2.getX() + scale * tangent.getX(),
                    p2.getY() + scale * tangent.getY(),
                    p2.getZ() + scale * tangent.getZ());
            Coordinate coordinates[] = new Coordinate[2];
            coordinates[0] = q0;
            coordinates[1] = q1;
            return coordinates;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
    private void addPoints() {
        int i = 0;
        Coordinate p[] = new Coordinate[4];
        try {
            for (i = 0; i < calculatedPoints.size() - 3; i = i + 3) {


//

                p[0] = calculatedPoints.get(i);
                p[1] = calculatedPoints.get(i + 1);
                p[2] = calculatedPoints.get(i + 2);
                p[3] = calculatedPoints.get(i + 3);
                Coordinate tangentPoints[] = getTwoTangents(0.5, p[1], p[2], p[3]);
                calculatedPoints.add(i + 3, tangentPoints[1]);
                calculatedPoints.add(i + 2, tangentPoints[0]);
                for (int j = 0; j < 4; j++) {
                    p[j] = calculatedPoints.get(i + j);
                }
                for (int j = 0; j < POINTS_PER_SEGMENT + 1; j++) {
                    double t = (double) j / POINTS_PER_SEGMENT;
                    bezierPoints.add(calculatePoint(t, p[0], p[1], p[2], p[3]));
                }
            }
            Coordinate lastPoint = p[3];
            if (!lastPoint.equals(calculatedPoints.get(calculatedPoints.size() - 1))) {
                for (i = 3; i >= 0; i--) {
                    p[i] = calculatedPoints.get(calculatedPoints.size() + i - 4);
                    if (p[i].equals(lastPoint)) break;
                }
                for (i--; i >= 0; i--) {
                    p[i] = bezierPoints.get(bezierPoints.size() - 1);
                    bezierPoints.remove(bezierPoints.size() - 1);
                }
                for (int j = 0; j < POINTS_PER_SEGMENT + 1; j++) {
                    double t = (double) j / POINTS_PER_SEGMENT;
                    bezierPoints.add(calculatePoint(t, p[0], p[1], p[2], p[3]));
                }
            }
        } catch (Exception ex) {
            System.out.println(i);
            ex.printStackTrace();

        }

    }

    private double calculateDistance(List<Coordinate> coordinateList) {
        double sum = 0;
        for (int i = 1; i < coordinateList.size(); i++) {
            Coordinate coord1, coord2;
            coord1 = coordinateList.get(i);
            coord2 = coordinateList.get(i - 1);
            double deltaX, deltaY, deltaZ;
            deltaX = Math.abs(coord1.getX() - coord2.getX())*27.78;
            deltaY = Math.abs(coord1.getY() - coord2.getY())*27.78;
            deltaZ = Math.abs(coord1.getZ() - coord2.getZ())*121.3;
            double dist = Math.sqrt(deltaX * deltaX + deltaY * deltaY + deltaZ * deltaZ);
            sum += dist;
        }
        return sum;
    }

    public void print(String absolutePath) {
        String bezierFileName = absolutePath.substring(0, absolutePath.length() - 4) + "Scaled.txt";
        PrintStream result = null;
        try {
            result = new PrintStream(new FileOutputStream(bezierFileName));
            System.out.println("Total dist: " + calculatedInitialSize + "\tDlugosc splajnu " + bezierLength);
            if (absolutePath.contains("GraphUD")) {
                ud += bezierLength;
                udc++;
            } else if (absolutePath.contains("GraphDU")) {
                du += bezierLength;
                duc++;
            } else if (absolutePath.contains("GraphLR")) {
                lr += bezierLength;
                lrc++;
            } else if (absolutePath.contains("GraphRL")) {
                rl += bezierLength;
                rlc++;
            } else if (absolutePath.contains("GraphTB")) {
                tb += bezierLength;
                tbc++;
            } else if (absolutePath.contains("GraphBT")) {
                bt += bezierLength;
                btc++;
            }
            result.println("Dlugosc obliczona: " + calculatedLength + "Poczatkowa ilosc punktów " + calculatedInitialSize + "\tDlugosc splajnu: " + bezierLength);
            for (Coordinate coordinate : bezierPoints) {
                result.println(coordinate.getX() + " " + coordinate.getY() + " " + coordinate.getZ());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            result.flush();
            result.close();
        }
    }

    public static void printSummary(String folderPath) {
        String resultFileName = folderPath + "//Bezier.txt";
        PrintStream summary = null;
        try {
            summary = new PrintStream(new FileOutputStream(resultFileName));
            summary.println("UD: " + ud / udc);
            summary.println("DU: " + du / duc);
            summary.println("LR: " + lr / lrc);
            summary.println("RL: " + rl / rlc);
            summary.println("TB: " + tb / tbc);
            summary.println("BT: " + bt / btc);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


    }
}

