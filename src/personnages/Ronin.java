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
		parler(beneficiaire.getNom() + " prends ces " + don + " sous.");
		beneficiaire.recevoir(don);
	}

	public void provoquer(Yakuza adversaire) {
		int force;
		int resultat;
		force = honneur * 2;
		super.parler("Je t ai retrouve vermine, tu vas payer pour ce que tu as fais a ce pauvre marchand!");
		if (force >= adversaire.getReputation()) {
			super.parler("Je t ai eu petit Yakuza!");
			resultat = adversaire.perdre();
			super.gagnerArgent(resultat);
			honneur++;
		} else {
			honneur--;
			resultat = super.getArgent();
			super.perdreArgent(resultat);
			super.parler("J ai perdu contre ce Yakuza, mon honneur et ma bourse ont en pris un coup.");
			adversaire.gagner(resultat);
		}
	}

}
