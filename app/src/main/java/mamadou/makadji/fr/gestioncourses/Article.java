package mamadou.makadji.fr.gestioncourses;

/**
 * Created by MBM on 23/02/2017.
 */

public class Article {
    private String nom;
    private int icon;

    public Article(String nom) {
        this.nom = nom;
    }

    public Article(int icon) {
        this.icon = icon;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }
}
