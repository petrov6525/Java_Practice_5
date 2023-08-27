package com.example.Java_Practice_5.Helplers;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class FileHelper {


    public static String getFileContent(String filePath) {

        StringBuilder content = new StringBuilder();
        try(FileReader reader = new FileReader(filePath))
        {

            int c;
            while((c=reader.read())!=-1){

                content.append((char)c);
            }
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
            return ex.getMessage();
        }


        return content.toString();
    }

    public static int getLettersCount (String content) {
        int count = 0;

        for (int i = 0; i <content.length(); i++){
            char c = content.charAt(i);

            if (Character.isLetter(c)){
                count++;
            }
        }

        return count;
    }

    public static int getDigitsCount (String content) {
        int count = 0;

        for (int i = 0; i <content.length(); i++){
            char c = content.charAt(i);

            if (Character.isDigit(c)){
                count++;
            }
        }

        return count;
    }

    public static int getDevidersCount (String content) {
        int count = 0;
        String deviders = "!,. ?";

        for (int i = 0; i <content.length(); i++){
            char c = content.charAt(i);
            int index = deviders.indexOf(c);
            if (index != -1) {
                count++;
            }
        }

        return count;
    }


    public static String rewriteFile(String filePath, String content) {
        try(FileWriter writer = new FileWriter(filePath, false))
        {
            writer.write(content);
            writer.flush();
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
            return ex.getMessage();
        }

        return getFileContent(filePath);
    }

    public static String appendFileToFile(String source, String destination) {
        String content = getFileContent(source);

        try(FileWriter writer = new FileWriter(destination, true))
        {
            writer.append('\n');
            writer.append(content);
            writer.flush();
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
            return ex.getMessage();
        }

        return getFileContent(destination);
    }

    public static Map<String, Integer> eraseDisabledWords(String filePath, String[] badWords) {
        Map<String, Integer> info = new HashMap<>();

        String content = getFileContent(filePath);

        for (String badWord: badWords) {
            int count = StringHelper.getWordCountInContent(content, badWord);
            content = content.replace(badWord, "");
            info.put(badWord, count);
        }
        rewriteFile(filePath, content);
        return info;
    }
}
