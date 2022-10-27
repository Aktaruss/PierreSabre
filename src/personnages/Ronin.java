package personnages;

public class Ronin extends Humain {
	private int honneur = 1;

	public Ronin(String nom, String boissonFavorite, int argent) {
		super(nom, boissonFavorite, argent);
	}

	public void donner(Commercant beneficiaire) {
		int don;
		don = super.getArgent() / 10;
		super.perdreArgent(don);
		super.parler(beneficiaire.getNom() + " prends ces " + don + " sous.");
		beneficiaire.recevoir(don);
	}

}
