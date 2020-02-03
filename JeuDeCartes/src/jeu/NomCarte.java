package jeu;


//cette classe permet d'attribuer un nom aux cartes, de définir ce qui sera affiché lorsqu'on affiche une carte 
//et de définir la valeur relative des cartes utilisées dans la comparaison
public enum NomCarte {
	
	
	
	   deux(2,"2"),trois(3,"3"),quatre(4,"4"),cinq(5,"5"),six(6,"6"),sept(7,"7"),huit(8,"8"),neuf(9,"9"),dix(10,"10"),Valet(11,"Valet"),Reine(12,"Reine"),Roi(13,"Roi"),As(14,"As");
	
	NomCarte ()
      {
         
      }
	   
	private double valeur;
	private String libelle;
	 NomCarte ( int valeur, String libelle )
	      {
	           this .valeur =valeur ;
	           this .libelle =libelle ;
	      }
	   
	public double getValeur() {
		return valeur;
	}
	public void setValeur(double valeur) {
		this.valeur = valeur;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	 

	  
	   

}
