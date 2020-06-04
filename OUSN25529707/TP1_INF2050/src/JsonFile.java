/********************************************************************************
 * Cette classe manipule un fichier Json
 *
 * @version 29 mai 2020
 * @autor Nana Ousmane
 * Code permanent: OUSN25529707
 *
 ********************************************************************************/

import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;
import org.json.simple.parser.ParseException;

import java.io.IOException;

public class JsonFile {

    /********************************************************************************
     * Traduit le fichier entrée en parametre en String puis en JsonObject
     * Propage les exceptions eventuelles
     *
     *
     * @param pathInputFile le chemin vers le fichier d'entrée
     *
     * @return inputFile l'objet Json contenu dans le fichier
     *
     ********************************************************************************/
    public static JSONObject parseJsonFile(String pathInputFile) throws IOException {

        String jsonText = DiskFile.loadFileIntoString(pathInputFile);
        JSONObject inputFile = (JSONObject) JSONSerializer.toJSON(jsonText);

        return inputFile;

    }


    /********************************************************************************
     * Traduit un objet JSONObject en Client
     * Elle assigne chaque proprieté du JSONObject à l'attribut du Client correspondant
     *
     * @param inputFile l'objet JSONObject contenu dans le fichier d'entrée
     *
     * @return client l'assuré potentiel
     *
     ********************************************************************************/
    public static Client jsonToClient(JSONObject inputFile, Client client) {
        try {
            client.setNom(inputFile.get("nom").toString());
            client.setGenre(Integer.parseInt(String.valueOf(inputFile.get("genre"))));
            client.setAge(Integer.parseInt(String.valueOf(inputFile.get("age"))));
            JSONObject statut = (JSONObject) inputFile.get("fumeur");
            client.setCannabis((Boolean) statut.get("cannabis"));
            client.setTabac((Boolean) statut.get("tabac"));
            client.setAlcool((Boolean) inputFile.get("alcool"));

        } catch (NullPointerException e) {
            System.err.println("Format du fichier invalide");
            System.exit(0);
        }
        return client;
    }


    /********************************************************************************
     * Instancie un Client en appelant la methode jsonToClient
     * Appelle ensuite la methode isEligible pour etablir l'admissibilité de la personne
     * et l'ecris dans un fichier de sortie
     *
     * @param pathOutputFile le chemin vers le fichier de sortie
     * @param inputFile l'objet JSONObject contenu dans le fichier d'entrée
     * @param client  une nouvelle instance de client
     *
     *
     * @return outputFile le fichier de sortie
     *
     ********************************************************************************/
    public static JSONObject writeJsonFile(JSONObject inputFile, String pathOutputFile,
                                           Client client) throws ParseException {
        Client assure = jsonToClient(inputFile, client);
        JSONObject outputFile = new JSONObject();
        outputFile.put("eligible ", Validation.isEligible(assure));
        try {
            DiskFile.saveStringIntoFile(pathOutputFile, outputFile.toString());
        } catch (IOException e) {
            System.err.println("Erreur entrée / sortie");
            System.exit(0);
        }
        return outputFile;

    }
}
