package histoire;

import personnages.*;

public class HistoireTP4 {
	public static void main(String[] args) {
		Humain prof = new Humain("Prof", "Kombucha", 54);
		prof.direBonjour();
		prof.acheter("une boisson", 12);
		prof.boire();
		prof.acheter("un jeu", 2);
		prof.acheter("un kimono", 50);

		Commercant marco = new Commercant("Marco", 20);
		marco.direBonjour();
		marco.seFaireExtorquer();
		marco.recevoir(15);
		marco.boire();

		Yakuza yakuLeNoir = new Yakuza("Yaku le noir", "whisky", 30, "Warsong");
		yakuLeNoir.direBonjour();
		yakuLeNoir.extorquer(marco);
		
		Ronin roro = new Ronin("Roro", "Shochu", 60);
		roro.direBonjour();
		roro.donner(marco);
		
		roro.provoquer(yakuLeNoir);
	}	
}
