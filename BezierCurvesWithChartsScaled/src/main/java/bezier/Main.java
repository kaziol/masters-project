package bezier;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        System.out.println("Podaj sciezke do folderu z plikami");
        String folderPath = scan.next();
        File folder = new File(folderPath);
        for(File file: folder.listFiles()) {
            List<Coordinate> calculatedPoints = new ArrayList<Coordinate>();

            List<Coordinate> scaledPoints = new ArrayList<Coordinate>();
            BufferedReader br = null;
            double x, y, z;
            try {
                br = new BufferedReader(new FileReader(file));
                String line;
                boolean firstLine=true;
                while ((line = br.readLine()) != null) {
                    if(firstLine){
                        firstLine=false;
                        continue;
                    }
                    int firstSpace = line.indexOf(' ');
                    int lastSpace = line.lastIndexOf(' ');
                    x = Double.parseDouble(line.substring(0, firstSpace));
                    y = Double.parseDouble(line.substring(firstSpace + 1, lastSpace));
                    z = Double.parseDouble(line.substring(lastSpace + 1));
                    Random rnd = new Random();
                    if(rnd.nextInt(5)<4) scaledPoints.add(new Coordinate(Math.round(x*27.78*10d)/10d, Math.round(y*27.78*10d)/10d, Math.round(z*121.3*10d)/10d));
                    calculatedPoints.add(new Coordinate(x, y, z));
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
       //     CalculateBezierPoint calculateBezierPoint = new CalculateBezierPoint(calculatedPoints);
        //    calculateBezierPoint.print(file.getAbsolutePath());
            CreateHTML createHTML=new CreateHTML(file.getAbsolutePath(),
            scaledPoints);
        }
    CalculateBezierPoint.printSummary(folderPath);

    }

}
