package com.example.Java_Practice_5.Controllers;

import com.example.Java_Practice_5.Helplers.FileHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class Task1Controller {

    @GetMapping("/task1")
    public String index () {
        return "task1";
    }

    @PostMapping("/get-file-content")
    public String getFileContent (String file_path, Model model) {

        String content = FileHelper.getFileContent(file_path);

        model.addAttribute("content", content);

        return "task1";
    }
}
