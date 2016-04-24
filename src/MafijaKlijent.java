import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;


public class MafijaKlijent {
	
	static Socket soketZaKomunikaciju = null;
	static BufferedReader ulazOdServera;
	static PrintStream izlazKaServeru;
	static BufferedReader ulazKonzola;
	static boolean status = true;
	static boolean kraj = false;
	
	public static void main(String[] args) {
		try {
			soketZaKomunikaciju = new Socket("localhost", 2906);
			ulazOdServera = new BufferedReader(new InputStreamReader(soketZaKomunikaciju.getInputStream()));
			izlazKaServeru = new PrintStream(soketZaKomunikaciju.getOutputStream());
			ulazKonzola = new BufferedReader(new InputStreamReader(System.in));
			
			System.out.println("Dobrodosli! Unesite ime:");
			izlazKaServeru.println(ulazKonzola.readLine());
			
			System.out.println("Sacekajte ostale igrace...");
			System.out.println("Igraci su:");
			for (int i = 0; i < 6; i++) {
				System.out.println(ulazOdServera.readLine());
			}
			
			String uloga = ulazOdServera.readLine();
			System.out.println("Vasa uloga je : "+ uloga);
			
			System.out.println();
			
			while(!kraj) {
			if(status) {
			switch (uloga) {
			case "Ubica":
				System.out.println("Koga zelite da ubijete?");
				izlazKaServeru.println(ulazKonzola.readLine());
				break;
			case "Lekar":
				System.out.println("Koga zelita da izlecite?");
				izlazKaServeru.println(ulazKonzola.readLine());
				break;
			case "Policajac":
				System.out.println("Na koga sumnjate?");
				izlazKaServeru.println(ulazKonzola.readLine());
				System.out.println(ulazOdServera.readLine());
				break;
				
			}
			}
			System.out.println();
			
			System.out.println("Rezultat:");
			for (int i = 0; i < 6; i++) {
				System.out.println(ulazOdServera.readLine());
			}
			
			
			
				System.out.println();
				if (!status) {
					System.out.println();
				} else{
				if (ulazOdServera.readLine().equals("izbacen")) {
					System.out.println("Ispali ste iz igre!");
					status = false;
				} else {
					System.out.println("Jos ste u igri!");
				}
				}
				
				if (ulazOdServera.readLine().equals("kraj")) {
					kraj = true;
					continue;
				}
			
			
			if (status) {		
				System.out.println();
				System.out.println("Koga zelite da izbacite: ");
				izlazKaServeru.println(ulazKonzola.readLine());
			}
			
			System.out.println();
			System.out.println("Rezultati glasanja: ");
			for (int i = 0; i < 6; i++) {
				System.out.println(ulazOdServera.readLine());
			}
			
			
				System.out.println();
				if (ulazOdServera.readLine().equals("izbacen")) {
					System.out.println("Ispali ste iz igre!");
					status = false;
				} else {
					System.out.println("Jos ste u igri!");
				}
			
			
			if (ulazOdServera.readLine().equals("kraj")) {
				kraj = true;
			}
			}
		  
			
			System.out.println("Kraj partije! Pobedili su " + ulazOdServera.readLine());
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
