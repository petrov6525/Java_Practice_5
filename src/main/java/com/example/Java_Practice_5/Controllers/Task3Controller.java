package com.example.Java_Practice_5.Controllers;

import com.example.Java_Practice_5.Helplers.FileHelper;
import com.example.Java_Practice_5.Helplers.ListHelper;
import com.example.Java_Practice_5.Helplers.PaginationHelper;
import com.example.Java_Practice_5.Helplers.StringHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class Task3Controller {

    @GetMapping("/task3")
    public String index () {
        return "task3";
    }

    @PostMapping("/word-count")
    public String getWordCount
            (String file_path, String search_word, Model model) {

        String content = FileHelper.getFileContent(file_path);
        int count = StringHelper.getWordCountInContent(content, search_word);

        model.addAttribute("content", content);
        model.addAttribute("searchWord", search_word);
        model.addAttribute("count", count);

        return "task3";
    }
}
