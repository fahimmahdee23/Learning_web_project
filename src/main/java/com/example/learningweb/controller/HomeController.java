
package com.example.learningweb.controller;

import com.example.learningweb.model.Chapter;
import com.example.learningweb.service.ChapterService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class HomeController {

    private final ChapterService chapterService;

    public HomeController(ChapterService chapterService) {
        this.chapterService = chapterService;
    }

    // Home page
    @GetMapping("/")
    public String home(Model model) {

        model.addAttribute("chapters",
                chapterService.getAllChapters());

        return "index";
    }

    // Individual chapter page
    @GetMapping("/chapter/{number}")
    public String showChapter(@PathVariable int number, Model model) {

        Chapter chapter = chapterService.getChapterByNumber(number);

        if (chapter == null) {
            return "redirect:/";
        }

        model.addAttribute("chapters", chapterService.getAllChapters());
        model.addAttribute("chapterTitle", chapter.getChapterTitle());
        model.addAttribute("chapterNumber", chapter.getChapterNumber());
        model.addAttribute("chapterDescription", chapter.getDescription());
        model.addAttribute("notes", chapter.getNotes());

        return "chapter";
    }
}
