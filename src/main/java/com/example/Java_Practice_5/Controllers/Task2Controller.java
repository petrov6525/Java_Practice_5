package com.example.Java_Practice_5.Controllers;

import com.example.Java_Practice_5.Helplers.FileHelper;
import com.example.Java_Practice_5.Helplers.ListHelper;
import com.example.Java_Practice_5.Helplers.PaginationHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class Task2Controller {

    @GetMapping("/task2")
    public String index () {
        return "task2";
    }

    @PostMapping("/get-file-content-with-pagination")
    public String getFileContentWithPagination
            (String file_path, int max_symbols, Model model) {

        return getFileContentWithPage(file_path, max_symbols, 1, model);
    }


    @PostMapping("/get-file-content-with-page")
    public String getFileContentWithPage
            (String file_path, int max_symbols, int current_page, Model model)
    {
        String content = FileHelper.getFileContent(file_path);
        int pages = PaginationHelper.getPagesCountFromContent(content, max_symbols);

        model.addAttribute(
                "content",
                PaginationHelper.getContentWithPage(content, current_page, max_symbols));
        model.addAttribute("pages", ListHelper.getListFromInt(pages));
        model.addAttribute("filePath", file_path);
        model.addAttribute("maxSymbols", max_symbols);
        model.addAttribute("currentPage", current_page);

        return "task2";
    }
}
