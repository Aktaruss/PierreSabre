package personnages;

import java.util.Random;

public class Traitre extends Samourai {
	private int niveauDeTraitrise = 0;

	public Traitre(String seigneur, String nom, String boissonFavorite, int argent) {
		super(seigneur, nom, boissonFavorite, argent);
	}

	@Override
	public void direBonjour() {
		super.direBonjour();
		parler("Mais je suis un traitre et mon niveau de traitrise est :" + niveauDeTraitrise + ". Chut !");
	}

	public void ranconner(Commercant commercant) {
		int argentRanconner;
		if (niveauDeTraitrise < 3) {
			argentRanconner = commercant.getArgent();
			argentRanconner = argentRanconner * 2 / 10;
			commercant.perdreArgent(argentRanconner);
			gagnerArgent(argentRanconner);
			niveauDeTraitrise++;
			parler("Si tu veux ma protection contre les Yakuzas, il va falloir payer ! Donne moi " + argentRanconner
					+ " sous ou gare a toi!");
			commercant.parler("Tout de suite grand " + getNom() + ".");
		} else {
			parler("Mince je ne peux plus ranconner personne sinon un samourai risque de me demasquer !");
		}
	}

	public void faireLeGentil() {
		int aleatoire;
		if (nbConnaissance < 1) {
			parler("Je ne peux pas faire ami ami avec personne car je ne connais personne ! Snif.");

		} else {
			Random random = new Random();
			aleatoire = random.nextInt(nbConnaissance);
			Humain humain = memoire[aleatoire];
			int don = getArgent() / 20;
			String monAmi = humain.getNom();
			parler("Il faut absolument remonter ma cote de confiance. Je vais faire ami ami avec " + monAmi + ".");
			parler("Bonjour l ami ! Je voudrais vous aider en vous donnant " + don + "sous");
			humain.gagnerArgent(don);
			perdreArgent(don);
			String nom = getNom();
			humain.parler("Merci " + nom + ". Vous etes quelqu un de bien.");
		}
		if (niveauDeTraitrise > 1) {
			niveauDeTraitrise--;
		}

	}

}
