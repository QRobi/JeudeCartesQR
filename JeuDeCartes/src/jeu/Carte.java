package jeu;

public class Carte {
	
	
	
	
	public enum Couleur
	{
	     trèfle,pique,coeur,carreau
	 }
	
	
	private NomCarte nom;
	private Couleur couleur;
	
	
	

	
	public Carte( NomCarte nom, Couleur couleur) {
		super();
		
		this.nom = nom;
		this.couleur = couleur;
	}
	public NomCarte getNom() {
		return nom;
	}
	public void setNom(NomCarte nom) {
		this.nom = nom;
	}
	
	
	
	@Override
	public String toString() {
		return " " + nom.getLibelle() +" de "+ couleur;
	}
	

	public int comparer(Carte c) {
		int i=2;
		
		if(this.nom.getValeur()>c.nom.getValeur())
		i=1;
		else if(this.nom.getValeur()==c.nom.getValeur())
		i=0;
		else if(this.nom.getValeur()<c.nom.getValeur())
		i=-1;
		
		
		return i;
	}
	

	
	
	

}
