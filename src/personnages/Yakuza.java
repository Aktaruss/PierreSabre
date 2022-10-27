package personnages;

public class Yakuza extends Humain {
	private String clan;
	private int reputation = 0;

	public Yakuza(String nom, String boissonFavorite, int argent, String clan) {
		super(nom, boissonFavorite, argent);
		this.clan = clan;
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
}
