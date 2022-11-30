import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner entree = new Scanner(System.in);
		System.out.println("Bienvenue au Mastermind !");
		
		System.out.println("Avec combien de valeurs voulez vous jouer ? ");
		int nbValeurs = entree.nextInt();
		
		System.out.println("Quelle serait la valeur maximale ? ");
		int taille = entree.nextInt();
		
		ModeleMastermind mastermind = new ModeleMastermind(nbValeurs,taille);
		
		int combinaisons[] = new int[taille];
		for(int i=0; i<nbValeurs; i++) {
			System.out.println("Entrez une valeur : ");
			combinaisons[i]=entree.nextInt();
		}
		
		entree.close();
		
		mastermind.genererCombinaison();
		
		System.out.println("Le nombre de chiffres bien placés est de " +
		mastermind.nbChiffresBienPlaces(combinaisons)+
		" et le nombre de chiffres mal placés est de  "+
		mastermind.nbChiffresMalPlaces(combinaisons)
		);
		
	}

}
