package Stock;

public class Produit {
    private int code;
    private String nom;
    private int quantite;
    private double prix;

    public Produit() {
    }

    public Produit(int code, String nom, int quantite, double prix) {
        this.code = code;
        this.nom = nom;
        this.quantite = quantite;
        this.prix = prix;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    @Override
    public String toString() {
        return    code + "  " + nom + "  " + quantite + "  " + prix ;
    }

    public double totalProduitEnStock() {
        return  quantite * prix;
    }
}
