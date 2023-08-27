package com.example.Java_Practice_5.Helplers;

public class PaginationHelper {

    public static String getContentWithPage (String content, int page, int maxSymbols) {
        int endIndex = maxSymbols * page;
        int startIndex = endIndex - maxSymbols;

        if ( content.length() < (endIndex + 1) ) {
            endIndex = content.length() - 1;
        }

        return content.substring(startIndex, endIndex);
    }

    public static int getPagesCountFromContent (String content, int maxSymbols) {

        int length = content.length();
        System.out.println(content);
        System.out.println(length);
        return (int)Math.ceil((double) length /maxSymbols);
    }
}
