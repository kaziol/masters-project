package mgrDFS;

import java.io.File;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		System.out.println("Podaj sciezke do folderu z plikami graficznymi:");		
		String folderPath = scan.next();
		scan.close();
		File folder = new File(folderPath);
		String[] listOfFiles = folder.list();
		Thread threadTable[]=new Thread[6];
		for(int i=0;i<6;i++){
			threadTable[i]=new Thread(new CalcPaths(folderPath, listOfFiles));
			threadTable[i].start();
		}
		for(int i=0;i<6;i++){
			try {
				threadTable[i].join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("Koniec programu");
		
	}

}
