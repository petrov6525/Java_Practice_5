package com.example.Java_Practice_5.Controllers;

import com.example.Java_Practice_5.Helplers.FileHelper;
import com.example.Java_Practice_5.Helplers.StringHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.File;

@Controller
public class Task4Controller {

    @GetMapping("/task4")
    public String index () {
        return "task4";
    }

    @PostMapping("/file-content-info")
    public String getContentInfo
            (String file_path, Model model) {

        String content = FileHelper.getFileContent(file_path);
        int letters = FileHelper.getLettersCount(content);
        int digits = FileHelper.getDigitsCount(content);
        int deviders = FileHelper.getDevidersCount(content);

        model.addAttribute("content", content);
        model.addAttribute("letters", letters);
        model.addAttribute("digits", digits);
        model.addAttribute("deviders", deviders);

        return "task4";
    }
}
