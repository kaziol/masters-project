package mgrPoreRandom;

/**
 * Created by Michal-Desktop on 15.12.2016.
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.List;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Podaj sciezke do folderu z plikami graficznymi:");
        String folderPath = scan.next();
        System.out.println("Podaj procent koordynatow do wyznaczenia limitu nietrafionych powt\u00f3rze\u0144:");
        int limit = scan.nextInt();
        File folder = new File(folderPath);
        String[] listOfFiles = folder.list();
        CalcPores calcPores = new CalcPores(folderPath, listOfFiles, limit);
        try {
            PrintWriter printWriter = new PrintWriter(folderPath + "//filename.txt");
            for (Coordinate coordinate : calcPores.deltaList) {
                printWriter.println("" + coordinate.getX() + " " + coordinate.getY() + " " + coordinate.getZ());
            }
            printWriter.flush();
            printWriter.close();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("Koniec programu");
    }
}
