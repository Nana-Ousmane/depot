/********************************************************************************
 * Cette se base sur certains critère pour determiner l'eligibilité d'une personne
 * à une assurance personnelle
 *
 * @version 3 Juin 2020
 * @autor Nana Ousmane
 * Code permanent: OUSN25529707
 *
 ********************************************************************************/

public class Validation {
    /********************************************************************************
     * Determine l'admissibilité d'un personne à une assurance personnelle
     * Si la personne a moins de 18ans; est une femme de plus de 85ans;
     * est un homme de plus de 80ans ou fume à la fois le tabac et le cannabis,
     * elle return false, si non elle retourne true.
     *
     * @param  assure Le client potentiel à assuré
     *
     * @return  boolean isEligible le statut de la personne
     *
     ********************************************************************************/
    public static boolean isEligible(Client assure) {
        boolean isEligible = false;
        int genre = assure.genre;
        int age = assure.age;
        boolean tabac = assure.tabac;
        boolean cannabis = assure.cannabis;


        isEligible = age >= 18 && ((genre == 1 && age <= 80) || (genre == 2 && age <= 85))
                    && (!tabac || !cannabis);


        return isEligible;
    }
}
