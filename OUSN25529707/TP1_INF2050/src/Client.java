/********************************************************************************
 * Cette classe crée un objet Client;
 *
 * @version 29 mai 2020
 * @autor Nana Ousmane
 * Code permanent: OUSN25529707
 *
 ********************************************************************************/

import net.sf.json.JSONObject;

public class Client {
    String nom;
    int genre;
    int age;
    JSONObject fumeur;
    boolean tabac;
    boolean cannabis;
    boolean alcool;

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setGenre(int genre) {
        this.genre = genre;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setFumeur(JSONObject fumeur) {
        this.fumeur = fumeur;
    }

    public void setTabac(boolean tabac) {
        this.tabac = tabac;
    }

    public void setCannabis(boolean cannabis) {
        this.cannabis = cannabis;
    }

    public void setAlcool(boolean alcool) {
        this.alcool = alcool;
    }
}
