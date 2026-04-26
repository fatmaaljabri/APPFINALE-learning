package com.APPJAVAFSTELEARNINcontroller;


import com.APPJAVAFSTELEARNINservice.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
public class QuizController {

    @Autowired
    private QuizService quizService;

    @GetMapping("/quiz/{moduleId}")
    public String afficherQuiz(@PathVariable Long moduleId, Model model) {
        model.addAttribute("quiz", quizService.getQuizParModule(moduleId));
        return "quiz";
    }

    @PostMapping("/quiz/soumettre")
    public String soumettre(@RequestParam Map<Long, Integer> reponses, Model model) {

        var result = quizService.soumettre(reponses, 1L); // TEMP user

        model.addAttribute("result", result);
        return "quiz-result";
    }
}