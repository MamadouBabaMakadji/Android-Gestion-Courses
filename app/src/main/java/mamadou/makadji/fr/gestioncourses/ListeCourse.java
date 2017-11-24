package mamadou.makadji.fr.gestioncourses;

/**
 * Created by MBM on 22/02/2017.
 */
public class ListeCourse {
    private String nom;

    public ListeCourse(String nom) {
        this.nom = nom;
    }

    @Override
    public String toString() {
        return  nom;
    }
}
