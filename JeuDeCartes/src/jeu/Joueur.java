package jeu;



public class Joueur {
	
	private PaquetDeCartes main;
	private String nom;
	boolean perdu=false;
	
	
	
	@Override
	public String toString() {
		return "Joueur [nom=" + nom + ",main=" + main + ",  perdu=" + perdu + "]";
	}
	public boolean isPerdu() {
		return perdu;
	}
	public void setPerdu(boolean perdu) {
		this.perdu = perdu;
	}
	public PaquetDeCartes getMain() {
		return main;
	}
	public void setMain(PaquetDeCartes main) {
		this.main = main;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public Joueur(PaquetDeCartes main, String nom) {
		super();
		this.main = main;
		this.nom = nom;
	}

	
	
}
