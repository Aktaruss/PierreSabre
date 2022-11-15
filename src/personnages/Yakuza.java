package personnages;

public class Yakuza extends Humain {
	private String clan;
	private int reputation = 0;

	public Yakuza(String nom, String boissonFavorite, int argent, String clan) {
		super(nom, boissonFavorite, argent);
		this.clan = clan;
	}

	public int getReputation() {
		return reputation;
	}

	public void extorquer(Commercant victime) {
		int vol;
		super.parler("Tiens, tiens ne serait ce pas un faible marchand qui passe par la ?");
		super.parler(victime.getNom() + ", si tu tiens a la vie donne moi ta bourse !");
		vol = victime.seFaireExtorquer();
		super.gagnerArgent(vol);
		super.parler("J ai pique les " + vol + " sous de " + victime.getNom() + ", ce qui me fait " + super.getArgent()
				+ " sous dans ma poche. Hi ! Hi!");
		reputation++;
	}

	public int perdre() {
		int perte;
		perte = super.getArgent();
		super.perdreArgent(perte);
		reputation--;
		super.parler("J ai perdu mon duel et mes " + perte + " sous, snif... J ai deshonore le clan de " + clan);
		return perte;
	}

	public void gagner(int gain) {
		super.gagnerArgent(gain);
		reputation++;
		parler("Ce ronin pensait vraiment battre " + super.getNom() + " du clan de " + clan
				+ "? Je l ai depouille de ses " + gain + " sous.");
	}

	@Override
	public void direBonjour() {
		super.direBonjour();
		parler("Mon clan est celui de "+clan+".");
	}
}
