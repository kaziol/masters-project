package mgr;
import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		System.out.println("Wybierz rodzaj obliczen: \n1. Sciezki \n2. Pory");
		int choice = in.nextInt();
		// in.close();
		switch (choice) {
		case 1:
			try {
				CalcPaths.paths();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case 2:
			CalcPores.pores();
			break;
		default:
			System.out.println("Niepoprawna wartosc");
		}
	}

}
