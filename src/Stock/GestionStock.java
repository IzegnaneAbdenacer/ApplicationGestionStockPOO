package Stock;

import java.util.Scanner;

public class GestionStock {
    static Produit[] produits = new Produit[100];

    public static void printMenu() {
        System.out.println("____Gestion de Stock____");
        System.out.println("1.Ajouter un produit");
        System.out.println("2.Modifier un produit");
        System.out.println("3.Supprimer un produit");
        System.out.println("4.Afficher la liste des produits");
        System.out.println("5.Rechercher un produit");
        System.out.println("6.Calculer la valeur totale du stock");
        System.out.println("0.Quitter");

    }

    public static void ajouterProduit(Produit p) {
        //L'ajout du produit se fait dans la premiere case vide
        for (Produit pr : produits) {
            if (pr != null && p.getCode() == pr.getCode()) { //Verfifier l'unicite du produit par son code
                System.out.println(" Impossible d'ajouter ce produit, existe deja");
            }

        }
        for (int i = 0; i < produits.length; i++) {         //Parcourir le tableau
            if (produits[i] == null) {                          // Trouver la case vide
                produits[i] = p;
                System.out.println("Produit ajoutee avec succes");
                return;
            }
        }
        System.out.println("Tableau est plein");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choix;
        do {
            printMenu();
            System.out.println("Entrez votre choix :");
            choix = scanner.nextInt();
            scanner.nextLine();
            switch (choix) {
                case 0:
                    quitterApplication();
                    break;
                case 1:
                    Produit p = saisisProduit();
                    int i = 0;
                    if (produits[i] != null && p.getCode() == produits[i].getCode()) {
                        System.out.println(" Impossible d'ajouter ce produit, existe deja");
                    } else {
                        ajouterProduit(p);
                    }
                    break;
                case 2:
                    Scanner sc2 = new Scanner(System.in);
                    System.out.println("Entrer le code du produit a modifier ");
                    int code = sc2.nextInt();
                    System.out.println("Entrer le nouveau nom ");
                    String nouveauNom = sc2.next();
                    System.out.println("Entrer le nouveau prix ");
                    double nouveauPrix = sc2.nextDouble();
                    System.out.println("Entrer la nouveau quantitee ");
                    int nouveauQte = sc2.nextInt();
                    modifierProduit(code, nouveauNom, nouveauPrix, nouveauQte);
                    break;
                case 3:
                    int code2;
                    Scanner sc = new Scanner(System.in);
                    System.out.println("entrer le code du produit à supprimer");
                    code2 = sc.nextInt();
                    supprimerProduit(code2);
                    System.out.println("Produit " + code2 + " est  supprimé avec succces");
                    break;
                case 4:
                    System.out.println("Listes des produits");
                    afficherProduit();

                    break;
                case 5:
                    System.out.println("Entrer le nom du produit à chercher");
                    Scanner scanner1 = new Scanner(System.in);
                    String nom = scanner1.next();
                    Produit pr = rechercheProduit(nom);
                    System.out.println(pr);

                    break;
                case 6:
                    double total = calculerValeurStock();
                    System.out.println("le total du valeur de stock est " + total);
                    break;
            }
        } while (choix != 0);
        scanner.close();
    }

    static void quitterApplication() {
        System.out.println("au revoir");
    }

    static void modifierProduit(int code, String nouveauNom, double nouveauPrix, int nouveauQte) {
        for (Produit produit : produits) {
            if (produit != null && produit.getCode() == code) {
                produit.setPrix(nouveauPrix);
                produit.setQuantite(nouveauQte);
                produit.setNom(nouveauNom);

            }
        }
    }

    static void supprimerProduit(int code) {
        for (int i = 0; i < produits.length; i++) {
            if (produits[i] != null && produits[i].getCode() == code) {
                produits[i] = null;
                return;
            }
        }
    }

    static double calculerValeurStock() {
        double total = 0;
        for (Produit produit : produits) {
            if (produit != null) {
                total += (produit.getPrix()) * (produit.getQuantite());
            }

        }
        return total;
    }

    private static Produit rechercheProduit(String nom) {
        for (Produit produit : produits) {
            if (produit != null && produit.getNom().equals(nom)) {
                System.out.println(" Resultat de la recherche");
                return produit;
            }
        }
        System.out.println("Aucun produit correspond à ce code");
        return null;
    }


    private static Produit saisisProduit() {
        Scanner sc = new Scanner(System.in);
        double prix = 0;
        System.out.println("Saisir le code du produit");
        int code = sc.nextInt();
        System.out.println("Saisir le nom du produit");
        String nom = sc.next();
        sc.nextLine();
        do {
            try {
                System.out.println("Saisir le prix du produit");

                prix = sc.nextDouble();
            } catch (ArithmeticException e) {
                System.out.println("ereur de prix");
            }
        } while (prix < 0);

        sc.nextLine();
        System.out.println("Saisir la quantite du produit");
        int qte = sc.nextInt();

        sc.nextLine();

        return new Produit(code, nom, qte, prix);
    }


    static void afficherProduit() {
        for (Produit produit : produits) {
            if (produit != null) {
                System.out.println(produit);
            }

        }

    }
}

