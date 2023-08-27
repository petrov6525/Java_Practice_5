package com.example.Java_Practice_5.Controllers;

import com.example.Java_Practice_5.Helplers.FileHelper;
import com.example.Java_Practice_5.Helplers.StringHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class Task6Controller {

    @GetMapping("/task6")
    public String index () {
        return "task6";
    }

    @PostMapping("/three-files-in-one")
    public String threeFilesInOne
            (String file_path_1,
            String file_path_2,
            String file_path_3,
            String file_path_4,
             Model model) {

        String content1 = FileHelper.getFileContent(file_path_1);
        String resultCotent = FileHelper.rewriteFile(file_path_4, content1);
        resultCotent = FileHelper.appendFileToFile(file_path_2, file_path_4);
        resultCotent = FileHelper.appendFileToFile(file_path_3, file_path_4);

        model.addAttribute("content", resultCotent);

        return "task6";
    }
}
