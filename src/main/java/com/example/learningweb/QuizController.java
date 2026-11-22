
package com.example.learningweb;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class QuizController {

    @GetMapping("/quiz/chapter1")
    public String showQuiz() {
        return "quiz";
    }

    @PostMapping("/quiz/chapter1/submit")
    public String submitQuiz(
            @RequestParam String q1,
            @RequestParam String q2,
            @RequestParam String q3,
            @RequestParam String q4,
            @RequestParam String q5,
            Model model) {

        int score = 0;

        if (q1.equals("A")) score++;
        if (q2.equals("B")) score++;
        if (q3.equals("C")) score++;
        if (q4.equals("B")) score++;
        if (q5.equals("D")) score++;

        model.addAttribute("score", score);
        model.addAttribute("total", 5);

        return "quiz-result";
    }
}
