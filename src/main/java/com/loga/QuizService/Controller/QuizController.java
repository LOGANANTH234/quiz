package com.loga.QuizService.Controller;


import com.loga.QuizService.Entity.Quiz;
import com.loga.QuizService.Entity.ObjectForCreateQuiz;
import com.loga.QuizService.Entity.onlyAnswer;
import com.loga.QuizService.Entity.onlyQuestion;
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
    public List<onlyQuestion> createQuiz(@RequestBody ObjectForCreateQuiz objectForCreateQuiz) {
        return quizService.createQuiz(objectForCreateQuiz);
    }

    @DeleteMapping("/deleteQuizByQuizName")
    public String deleteQuiz(@RequestParam("quizName") String quizName) {
        if (quizService.deleteQuiz(quizName)) {
            return "success";
        }
        return "failure";
    }
@GetMapping("/getQuizById")
public Quiz getQuizById(@RequestParam ("id") String id){
        return quizService.getQuizById(id);
}
        @GetMapping("getAllQuiz")
    public List<Quiz> getAllQuiz() {
        return quizService.getAllQuiz();
    }

    @PostMapping("/getMarksForQuiz")
    public Long getMarksForQuiz( @RequestParam String id,@RequestBody List<String>answerList){
        return   quizService.getMarksForQuiz(id,answerList);
    }


    @GetMapping("/getAnswers")
    public onlyAnswer getAnswers(@RequestParam String id)
    {
return quizService.getAnswers(id);
    }

}
