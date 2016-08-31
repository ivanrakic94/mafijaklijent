import gui.GlavniProzor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;


public class ChatNitZaSve implements Runnable {
static Socket soketZaKom=null;
static PrintStream izlazniTokKaServeru=null;
static BufferedReader ulazniTokOdServera=null;
static GlavniProzor gp=null;
static String ime;
String uloga;





public ChatNitZaSve(GlavniProzor gp, String ime, Socket Soket, String uloga) {
	this.gp = gp;
	this.ime=ime;
	this.soketZaKom=Soket;
	this.uloga=uloga;
	
}


public void run(){
	String linija;
	int b=0;
	int c=0;
	
	try {
		ulazniTokOdServera=new BufferedReader(new InputStreamReader(soketZaKom.getInputStream()));
		while((linija=ulazniTokOdServera.readLine())!=null){
			if(!linija.contains("#*#")){
			if(b==0){
				gp.chatTextArea.setText(linija);
			}
			else gp.chatTextArea.setText(gp.chatTextArea.getText()+"\n"+linija);
			b=+1;
		}
			else {
				if(uloga.equals("Ubica")){
				linija=linija.replace("#*#","");
				if(c==0){
					gp.ubiceTextArea.setText(linija);
				}
				else gp.ubiceTextArea.setText(gp.ubiceTextArea.getText()+"\n"+linija);
				c=+1;
				}
			}
		}
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
}
}
