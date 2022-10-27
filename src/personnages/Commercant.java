package personnages;

public class Commercant extends Humain {

	public Commercant(String nom, int argent) {
		super(nom, "the", argent);
	}

	public int seFaireExtorquer() {
		super.perdreArgent(super.getArgent());
		super.parler("J ai tout perdu! Le monde est trop injuste...");
		return super.getArgent();
	}

	public void recevoir(int argent) {
		super.parler(argent + " sous !  Je te remercie genereux donateur!");
	}
}
