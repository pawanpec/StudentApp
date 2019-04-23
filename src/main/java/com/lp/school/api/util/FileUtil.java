package com.lp.school.api.util;

import net.minidev.json.JSONObject;
import net.minidev.json.parser.JSONParser;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Files;

public class FileUtil {

    public static  JSONObject readJsonFile(String filePath){
        File file = null;
        try {
            file = ResourceUtils.getFile(filePath);
            //Read File Content
            String content = new String(Files.readAllBytes(file.toPath()));
            //Get a Json String
            JSONParser parser = new JSONParser();
            JSONObject json = (JSONObject) parser.parse(content);

            return json;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }
}
