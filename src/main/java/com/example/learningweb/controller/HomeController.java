package com.example.learningweb.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.learningweb.model.Chapter;

@Controller
public class HomeController {

    private final List<Chapter> chapters = List.of(
        new Chapter(1, "Introduction to Motion",
            "Introduction, basic concepts and definitions of motion.", List.of()),
        new Chapter(2, "Force and Newton's Laws",
            "Fundamental principles, important terms and examples.", List.of()),
        new Chapter(3, "Equations of Motion",
            "Advanced concepts, applications and problem solving.", List.of()),
        new Chapter(4, "Applications and Review",
            "Applications, important questions and summary.", List.of())
    );

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("chapters", chapters);
        return "index";
    }

    @GetMapping("/chapter/{number}")
    public String chapter(@PathVariable int number, Model model) {
        if (number < 1 || number > chapters.size()) {
            return "redirect:/";
        }
        model.addAttribute("chapters", chapters);
        model.addAttribute("chapter", chapters.get(number - 1));
        return "chapter" + number;
    }
}