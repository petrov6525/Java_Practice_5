package com.example.Java_Practice_5.Controllers;

import com.example.Java_Practice_5.Helplers.FileHelper;
import com.example.Java_Practice_5.Helplers.StringHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Map;

@Controller
public class Task5Controller {

    @GetMapping("/task5")
    public String index () {
        return "task5";
    }

    @PostMapping("/change-word-in-file")
    public String changeWordInFile
            (String file_path, String search_word, String change_word, Model model) {

        String content = FileHelper.getFileContent(file_path);
        int count = StringHelper.getWordCountInContent(content, search_word);
        content = StringHelper.changeWords(content, search_word, change_word);
        content = FileHelper.rewriteFile(file_path, content);

        model.addAttribute("content", content);
        model.addAttribute("searchWord", search_word);
        model.addAttribute("changeWord", change_word);
        model.addAttribute("count", count);

        return "task5";
    }
}
