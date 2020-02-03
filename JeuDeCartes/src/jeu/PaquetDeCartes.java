package jeu;

import java.util.ArrayList;
import jeu.Carte.Couleur;
import jeu.Carte;
import org.apache.commons.lang3.StringUtils;

public class PaquetDeCartes {

	ArrayList<Carte> paquet = new ArrayList<Carte>();

	@Override
	public String toString() {
		return "PaquetDeCartes [paquet=" + paquet + "]";
	}

	public void afficherPaquet() {

		if (this.paquet.size() == 52) {
			for (int i = 0; i < NomCarte.values().length; i++) {
				System.out.printf("%-20s %-20s %-20s %-20s\n", StringUtils.center(this.paquet.get(i).toString(),15, ""), StringUtils.center(this.paquet.get(i+13).toString(),15, ""),
						StringUtils.center(this.paquet.get(i+26).toString(),15, ""), StringUtils.center(this.paquet.get(i+39).toString(),15, ""));
			}
		}

		else {
			for (int i = 0; i < this.paquet.size(); i++) {
				System.out.println(this.paquet.get(i));
			}
		}
	}

	public void InitPaquet() {
		{
			// Remplir le paquet couleur par couleur du 2 à l'as
			for (int i = 0; i < Couleur.values().length; i++) {
				for (int j = 0; j < NomCarte.values().length; j++) {

					this.paquet.add(j + 13 * i, new Carte(NomCarte.values()[j], Couleur.values()[i]));
				}

			}
		}

	}

	public void Distribuer(Joueur joueur) {
		{
			//retire la première carte du paquet et la met au sommet de la main du joueur

			joueur.getMain().paquet.add(0, this.paquet.get(0));

			this.paquet.remove(0);
		}
	}

	public void Melanger() {
		
		//pour mélanger on prend une carte au hasard dasn la pile et on la palce au sommet d'une autre pile
		ArrayList<Carte> paquetMelange = new ArrayList<Carte>();

		for (int i = 0; i < 52; i++) {

			int n = (int) (Math.random() * (this.paquet.size()));
			paquetMelange.add(0, this.paquet.get(n));
			this.paquet.remove(n);

		}

		this.paquet = paquetMelange;

	} 
}
