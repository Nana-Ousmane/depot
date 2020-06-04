/********************************************************************************
 * @version 29 mai 2020
 * @autor Nana Ousmane
 * Code permanent: OUSN25529707
 *
 ********************************************************************************/

import net.sf.json.JSONException;
import net.sf.json.JSONObject;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Principal {

    public static void main(String[] args) {


        if (args.length == 2) {

            String pathInputFile = args[0];
            String pathOutputFile = args[1];

            Client client = new Client();
            JSONObject inputFile = null;
            try {
                inputFile = JsonFile.parseJsonFile(pathInputFile);
                JsonFile.writeJsonFile(inputFile, pathOutputFile, client);
            } catch (FileNotFoundException e) {
                System.err.println("Erreur: Fichier inexistant");
                System.exit(0);

            } catch (IOException e) {
                System.err.println("Erreur d'entrée / sortie");
                System.exit(0);
            } catch (ParseException e) {
                System.err.println("Erreur d'analyse");
                System.exit(0);
            } catch (JSONException e) {
                System.err.println("Format du fichier invalide");
                System.exit(0);
            }

        } else {
            System.err.println("Veuillez verifier vos path passés en arguments");
        }
    }
}




