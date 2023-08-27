package com.example.Java_Practice_5.Helplers;

import java.util.HashMap;
import java.util.Map;

public class StringHelper {

    public static int getWordCountInContent(String content, String word)
    {
        int count = 0;
        int index = content.indexOf(word);

        while (index != -1) {
            count++;
            index = content.indexOf(word, index + word.length());
        }
        return count;
    }

    public static String changeWords(String content, String searchWord, String changeWord) {

        return content.replace(searchWord, changeWord);
    }
}
