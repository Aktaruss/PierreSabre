package personnages;

public class Commercant extends Humain {

	public Commercant(String nom, int argent) {
		super(nom, "the", argent);
	}

	public int seFaireExtorquer() {
		int argentVole;
		argentVole = super.getArgent();
		super.perdreArgent(argentVole);
		super.parler("J ai tout perdu! Le monde est trop injuste...");
		return argentVole;
	}

	public void recevoir(int argent) {
		super.parler(argent + " sous !  Je te remercie genereux donateur!");
		super.gagnerArgent(argent);
	}
}
