

import gui.GlavniProzor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class ChatNitZaSveSlanjePoruka implements Runnable {
	static Socket soketZaKom=null;
	static PrintStream izlazniTokKaServeru=null;
	static BufferedReader ulazniTokOdServera=null;
	static GlavniProzor gp=null;
	static String ime;

	public ChatNitZaSveSlanjePoruka(GlavniProzor gp, String ime, Socket Soket) {
		this.gp = gp;
		this.ime=ime;
		this.soketZaKom=Soket;
	}
	
	public void run() {
		try {
			
			izlazniTokKaServeru=new PrintStream(soketZaKom.getOutputStream());
			izlazniTokKaServeru.println(ime);
			ulazniTokOdServera=new BufferedReader(new InputStreamReader(soketZaKom.getInputStream()));
			
			while(true){
				while(!gp.slanjePorukeFlag &&!gp.slanjePorukeUbicaFlag){
					System.out.println();
				}
				if(!gp.chatTextField.getText().equals("")){
				izlazniTokKaServeru.println(gp.chatTextField.getText());
				gp.slanjePorukeFlag=false;
				gp.chatTextField.setText("");
				}
				if(!gp.ubiceTextField.getText().isEmpty()){
					izlazniTokKaServeru.println(gp.ubiceTextField.getText());
					gp.slanjePorukeUbicaFlag=false;
					gp.ubiceTextField.setText("");
					
				}
				
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
