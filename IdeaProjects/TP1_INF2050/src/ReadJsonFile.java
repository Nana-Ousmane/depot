import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.*;
public class ReadJsonFile {
    public static < E extends Comparable< E > >void estEligible() {
        boolean estEligible=true ;

        JSONParser parser = new JSONParser();
        JSONObject json = null;
        JSONObject j = null;
        try {
            json = (JSONObject) parser.parse(new FileReader("fichier.json"));
            JSONArray jsonArray = (JSONArray) json.get("collection");
            for (int i = 0; i < jsonArray.size(); i++) {
                j = (JSONObject) jsonArray.get(i);
                int genre=Integer.parseInt(String.valueOf(j.get("genre")));
                int age=Integer.parseInt(String.valueOf(j.get("age")));
                JSONObject fumeur = (JSONObject) j.get("fumeur");
                boolean tabac= (boolean) fumeur.get("tabac");
                boolean cannabis= (boolean) fumeur.get("cannabis");
                estEligible = age >= 18 && (genre != 1 || age <= 80) && (genre != 2 || age <= 85)
                        && (!tabac || !cannabis);
                System.out.println(j.get("nom") + " est "+ estEligible);
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }



    }
}

