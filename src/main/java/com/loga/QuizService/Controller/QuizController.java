package com.loga.QuizService.Controller;


import com.loga.QuizService.Entity.Quiz;
import com.loga.QuizService.Entity.dao;
import com.loga.QuizService.Service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/quiz")
@RestController
public class QuizController {
    @Autowired
    QuizService quizService;

    @PostMapping("/createQuiz")
    public Quiz createQuiz(@RequestBody dao d) {
        return quizService.createQuiz(d);
    }

    @DeleteMapping("/deleteQuizByQuizName")
    public String deleteQuiz(@RequestParam("quizName") String quizName) {
        if (quizService.deleteQuiz(quizName)) {
            return "success";
        }
        return "failure";
    }

        @GetMapping("getAllQuiz")
    public List<Quiz> getAllQuiz() {
        return quizService.getAllQuiz();
    }

}
