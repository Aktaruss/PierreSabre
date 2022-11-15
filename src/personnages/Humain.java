package personnages;

public class Humain {
	public static final int MEMOIREMAX = 30;

	private String nom;
	private String boissonFavorite;
	private int argent;
	protected int nbConnaissance = 0;
	protected Humain[] memoire = new Humain[MEMOIREMAX];

	public Humain(String nom, String boissonFavorite, int argent) {
		this.nom = nom;
		this.boissonFavorite = boissonFavorite;
		this.argent = argent;
	}

	public String getNom() {
		return nom;
	}

	public int getArgent() {
		return argent;
	}

	protected void parler(String texte) {
		System.out.println("(" + nom + ") - " + texte);
	}

	public void direBonjour() {
		parler("Bonjour ! Je m appelle " + nom + " et j aime boire du " + boissonFavorite + ".");
	}

	public void boire() {
		parler("Mmmm, un bon verre de " + boissonFavorite + "! GLOUPS !");
	}

	public void acheter(String bien, int prix) {
		if (prix < argent) {
			parler("J ai " + argent + " sous en poche. Je vais pouvoir m offrir " + bien + " a " + prix + " sous.");
			perdreArgent(prix);
		} else {
			parler("Je n ai plus que " + argent + " sous en poche. Je ne peux meme pas m offrir " + bien + " a " + prix
					+ " sous.");
		}
	}

	protected void gagnerArgent(int gain) {
		argent += gain;
	}

	protected void perdreArgent(int perte) {
		argent -= perte;
	}

	public void faireConnaissanceAvec(Humain humain) {
		direBonjour();
		humain.repondre(this);
		memoriser(humain);

	}

	private void memoriser(Humain humain) {
		if (nbConnaissance < MEMOIREMAX) {
			memoire[nbConnaissance] = humain;
			nbConnaissance++;
		} else {
			for (int i = 0; i < nbConnaissance - 1; i++) {
				memoire[i] = memoire[i + 1];
			}
			memoire[nbConnaissance - 1] = humain;
		}
	}

	private void repondre(Humain humain) {
		direBonjour();
		memoriser(humain);
	}

	public void listerConnaissance() {
		String texte = "Je connais beaucoup de personne dont : ";
		for (int i = 0; i < nbConnaissance; i++) {
			texte += memoire[i].getNom();
			if (i + 1 < nbConnaissance) {
				texte += ",";
			}
		}
		parler(texte);
	}

}
