package jeu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		//instanciation du paquet de cartes et des joueurs

		PaquetDeCartes p = new PaquetDeCartes();

		PaquetDeCartes mainJ1 = new PaquetDeCartes();
		PaquetDeCartes mainJ2 = new PaquetDeCartes();
		PaquetDeCartes mainJ3 = new PaquetDeCartes();
		PaquetDeCartes mainJ4 = new PaquetDeCartes();

		Joueur j1 = new Joueur(mainJ1, "Albert");
		Joueur j2 = new Joueur(mainJ2, "Béatrice");
		Joueur j3 = new Joueur(mainJ3, "Charles");
		Joueur j4 = new Joueur(mainJ4, "Danielle");
		
		//initialisation du paquet de manière ordonnée
		p.InitPaquet();

		System.out.println("	Paquet non mélangé\n");
		p.afficherPaquet();

		System.out.println("\n	Paquet mélangé\n");
		p.Melanger();
		p.afficherPaquet();

		for (int i = 0; i <= 12; i++) {
			
			p.Distribuer(j1);
			p.Distribuer(j2);
			p.Distribuer(j3);
			p.Distribuer(j4);
		}

		
		//affichage des paquets
		
		System.out.println("\n\n");
		System.out.printf("%-20s %-20s %-20s %-20s\n", "main de " + j1.getNom(), "main de " + j2.getNom(), "main de " + j3.getNom(),
				"main de " + j4.getNom());
		System.out.println("\n");
		for (int i = 0; i < NomCarte.values().length; i++) {

			System.out.printf("%-20s %-20s %-20s %-20s\n", j1.getMain().paquet.get(i), j2.getMain().paquet.get(i),
					j3.getMain().paquet.get(i), j4.getMain().paquet.get(i));
		}

		
		
		
		
		// début du jeu
		
		
		
		System.out.println("\n\n  **** Début de la partie *****" );
		boolean jeuFini = false;
		List<Joueur> partie = new ArrayList<>();
		partie.add(j1);
		partie.add(j2);
		partie.add(j3);
		partie.add(j4);

		int seuil = 8; //seuil de cartes à partir duquel un joueur est éliminé, cela permet de raccourcir la partie

		

		while (jeuFini == false) {  
			Joueur j = partie.get(0); 
			System.out.println("\n\n" + j.getNom() + " joue: " + j.getMain().paquet.get(0));
			for (int i = 1; i < partie.size(); i++) { //On compare la carte du joueur 2 à celle du joueur 1
				System.out.println(partie.get(i).getNom() + " joue: " + partie.get(i).getMain().paquet.get(0));
				int n = j.getMain().paquet.get(0).comparer(partie.get(i).getMain().paquet.get(0));

				if (n < 0)
					j = partie.get(i); //le joueur qui remporte un "duel" devient le joueur "gagnant" avec qui on compare les futures cartes
			}
			
			
			//on retire la 1ère carte de chaque main pour les placer sous la pile du vainqueur
			
			System.out.println("\n\n" + j.getNom() + " a remporté le pli et gagne: ");
			for (int i = 0; i < partie.size(); i++) { 

				j.getMain().paquet.add(j.getMain().paquet.size(), partie.get(i).getMain().paquet.get(0));
				System.out.println(partie.get(i).getMain().paquet.get(0));
				partie.get(i).getMain().paquet.remove(0);
			}
			
			
			//On compte le nombre de cartes restant, s'il atteint le "seuil" (>=0) le joueur est éliminé, augmenter le seuil permet d'éliminer 
			//des joueurs rapidement mais la partie peut quand même être longue
			
			System.out.println("\n Après ce pli ");
			for (int i = 0; i < partie.size(); i++) {
				System.out.println(partie.get(i).getNom() + " a " + partie.get(i).getMain().paquet.size() + " cartes.");
				if (partie.get(i).getMain().paquet.size() == seuil) {
					System.out.println(partie.get(i).getNom() + " a perdu.");
					partie.get(i).setPerdu(true);
				}
			}
			for (int i = 0; i < partie.size(); i++) {
				
				if (partie.get(i).perdu==true) {
					partie.remove(i);
				}
			}
			
			//le jeu se termine s'il ne reste plus qu'un joueur.
			
			if (partie.size() == 1) {
				System.out.println("\n\n" + partie.get(0).getNom() + " a gagné.");
				jeuFini = true;
			}
			// /* retirer les // pour laisser le jeu se dérouler seul, cela peut être long.
			@SuppressWarnings("resource")
			Scanner sc = new Scanner(System.in);
			System.out.println("\n\n Appuyez sur entrée dans la console pour passer au pli suivant ou entrez \"a\" pour arrêter");
			
			String str=sc.nextLine();
			
			if (str.equals("a"))
				jeuFini=true;
			 
			// */
			
			//si le jeu n'est pas terminé la boucle repart
		}
	}

}
