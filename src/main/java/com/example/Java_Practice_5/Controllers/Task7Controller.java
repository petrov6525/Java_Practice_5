package com.example.Java_Practice_5.Controllers;

import com.example.Java_Practice_5.Helplers.FileHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Map;

@Controller
public class Task7Controller {

    @GetMapping("/task7")
    public String index () {
        return "task7";
    }

    @PostMapping("/erase-disabled-words")
    public String threeFilesInOne(String file_path, String[] bad_words, Model model)
    {
        Map<String, Integer> badWordsInfo = FileHelper.eraseDisabledWords (file_path, bad_words);
        String content = FileHelper.getFileContent(file_path);

        model.addAttribute("content", content);
        model.addAttribute("badWords", bad_words);
        model.addAttribute("badWordsInfo", badWordsInfo);

        return "task7";
    }
}
