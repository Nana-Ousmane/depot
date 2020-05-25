import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.*;
public class Principale {
    public static void main(String[] args){

        boolean estEligible=true ;
        JSONParser parser = new JSONParser();
        JSONObject j = null;
        try {
            j= (JSONObject) parser.parse(new FileReader(args[0]));
                int genre=Integer.parseInt(String.valueOf(j.get("genre")));
                int age=Integer.parseInt(String.valueOf(j.get("age")));
                JSONObject fumeur = (JSONObject) j.get("fumeur");
                boolean tabac= (boolean) fumeur.get("tabac");
                boolean cannabis= (boolean) fumeur.get("cannabis");
                estEligible = age >= 18 && ((genre == 1 && age <= 80) || (genre == 2 && age <= 85))
                        && (!tabac || !cannabis);
                System.out.println(j.get("nom") + " est "+ estEligible);
        } catch( FileNotFoundException e) {
            System.err.println("Erreur: Fichier inexistant");
        } catch (IOException e){
            System.err.println("Erreur Entree / Sortie");
        }catch( ParseException e) {
            System.err.println("Erreur d'analyse");
        }catch(java.lang.NumberFormatException e){
            System.err.println("Format du fichier invalide");
        }catch(Exception e){
            System.err.println("Format du fichier invalide");
        }
        JSONObject jsObject = new JSONObject();
            jsObject.put("eligible " , estEligible);
            try {
                FileWriter file=new FileWriter(args[1]);
                file.write(jsObject.toString());
                file.flush();
            } catch (IOException e) {
                System.err.println("Erreur input/Output");
            }
        }
    }



