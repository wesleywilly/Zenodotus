/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilities;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 *
 * @author WesleyW
 */
public class FileUtilities {


    public static JSONObject load(String fileUrl) throws org.json.simple.parser.ParseException {
        //Cria objeto que receberá o conteúdo do arquivo
        JSONObject jObject = new JSONObject();

        //Cria o parse de tratamento
        JSONParser parser = new JSONParser();

        try {
            jObject = (JSONObject) parser.parse(new FileReader(fileUrl));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return jObject;
    }

    public static boolean save(JSONObject jObject, String fileUrl) {
        boolean saved = false;
        FileWriter writeFile = null;

        try {
            writeFile = new FileWriter(fileUrl);

            //Escreve no arquivo conteudo do Objeto JSON 
            writeFile.write(jObject.toJSONString());
            writeFile.close();
            saved = true;
        } catch (IOException e) {
            System.out.println("[FILE UTILITIES] Error while saving file:");
            e.printStackTrace();
        }
        return saved;
    }

    public static boolean mkdir(String folderName) {
        boolean maked = false;

        File dir = new File(folderName);
        if (dir.mkdirs()) {
            maked = true;
        }
        return maked;
    }

    public static JSONArray listFiles(String dirUrl) {
        
        File dir = new File(dirUrl);

        JSONArray jaFiles = new JSONArray();
        
        for(int i=0;i<dir.listFiles().length;i++){
            JSONObject jFile = new JSONObject();
            File f = dir.listFiles()[i];
            jFile.put("name", f.getName());
            jFile.put("url", f.getAbsolutePath());
            jaFiles.add(jFile);
        }
        
        
        
        return jaFiles;
    }

}
