import gui.GlavniProzor;
import gui.PocetniProzor;
import gui.ProzorZaKraj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;


public class MafijaKlijent {
	
	static Socket soketZaKomunikaciju = null;
	static Socket soketZaKom=null;
	static BufferedReader ulazOdServera;
	static PrintStream izlazKaServeru;
	//oznacava da li je igrac i dalje u igri
	static boolean status = true;
	//oznaka za kraj partije
	static boolean kraj = false;
	//prozor za unosenje imena
	static PocetniProzor pp;
	//glavni prozor u kome se igra
	static GlavniProzor gp;
	//prozor za izbor nove partije ili kraj
	static ProzorZaKraj pk;
	
	public static void main(String[] args) {
		try {
			soketZaKomunikaciju = new Socket("localhost", 2906);
			soketZaKom=new Socket("localhost",2907);
			ulazOdServera = new BufferedReader(new InputStreamReader(soketZaKomunikaciju.getInputStream()));
			izlazKaServeru = new PrintStream(soketZaKomunikaciju.getOutputStream());
		
		//beskonacna petlja da bi mogla da se bira nova partija neogranicen br puta
		while (true) {
			pp = new PocetniProzor();
			pp.setVisible(true);
			
			//ova petlja sluzi da zaustavi izvrsavanje dok igrac ne pritisne dugme za unos imena
			while (!pp.flag) {
				System.out.println();
			}
			//kada igrac pritisne dugme onda se uzima ime
			izlazKaServeru.println(pp.vratiIme());
			gp = new GlavniProzor();
			
			gp.ime = pp.vratiIme();
			
			//dobijanje svih igraca od servera
			String[] igraci = new String[6];
			for (int i = 0; i < 6; i++) {
				igraci[i] = ulazOdServera.readLine();
			}
			pp.dispose();
			
			gp.setVisible(true);
		
	
			//ispisuje igrace u listu i dodaje njihova imena na radio button-e
			gp.ispisiIgrace(igraci);
			
			//dobijanje uloge od servera
			String uloga = ulazOdServera.readLine();
			new Thread(new ChatNitZaSve(gp, pp.vratiIme(), soketZaKom,uloga)).start();
			new Thread(new ChatNitZaSveSlanjePoruka(gp, pp.vratiIme(), soketZaKom)).start();
			gp.ispisiUlogu(uloga);
			
			String ubice = ulazOdServera.readLine();
			gp.ispisiUbice(ubice);
			
			//ova petlja se vrti dok god traje partija
			while(!kraj) {
			//ako igrac nije ubijen/izbacen
			if(status) {
			//pravi promene u glavnom prozoru u zavisnosti od uloge i salje serveru izbore
			switch (uloga) {
			case "Ubica":
				gp.ulogaUbice();
				while (!gp.ulogaFlag) {
					System.out.println();
				}
				izlazKaServeru.println(gp.vratiIzborZaUlogu());
				break;
			case "Lekar":
				gp.ulogaLekara();
				while (!gp.ulogaFlag) {
					System.out.println();
				}
				izlazKaServeru.println(gp.vratiIzborZaUlogu());
				break;
			case "Policajac":
				gp.ulogaPolicajca();
				while (!gp.ulogaFlag) {
					System.out.println();
				}
				izlazKaServeru.println(gp.vratiIzborZaUlogu());
				gp.odgovoriPolicajcu(ulazOdServera.readLine());
				break;
			default:
				gp.ulogaGradjanina();
				break;
			}
			}
			
			//obavestava da li je neko ubijen i menja sadrzaj prozora za glasanje i izbacuje iz izbora ubijenog
			gp.obavesti(ulazOdServera.readLine());
			
				//dobija poruku od servera da li je igrac izbacen/ubijen
				if (!status) {
					ulazOdServera.readLine();
				} else{
				if (ulazOdServera.readLine().equals("izbacen")) {
					gp.obavestiOIspadanju();
					status = false;
				} 
				}
				
				//dobija poruku od servera da li je partija gotova
				if (ulazOdServera.readLine().equals("kraj")) {
					kraj = true;
					continue;
				}
			
			//salje serveru odgovor za izbacivanje
			if (status) {
				while (!gp.izbacivanjeFlag) {
					System.out.println();
				}
				izlazKaServeru.println(gp.vratiIzborZaIzbacivanje());
			}
			
			//dobija odgovor ko je izbacen
			gp.obavestiOIzglasavanju(ulazOdServera.readLine());
			
				//dobija poruku da li je igrac izbacen
				if (ulazOdServera.readLine().equals("izbacen")) {
					gp.obavestiOIspadanju();
					status = false;
				}
			
			//dobija poruku da li je sad kraj partije
			if (ulazOdServera.readLine().equals("kraj")) {
				kraj = true;
			}
			//ako nije, sve ispocetka
			}
			
			//ako jeste kraj partije, izbaci prozor za ponovno biranje partije
			pk = new ProzorZaKraj();
			pk.setVisible(true);
			//ispisi ko je pobedio
			pk.ispisi(ulazOdServera.readLine());
			gp.dispose();
			while (!pk.flag) {
				System.out.println();
			}
			pk.flag = false;
			pk.dispose();
		}
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
