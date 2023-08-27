package com.loga.QuizService.feign;

import com.loga.QuizService.Entity.ObjectForCreateQuiz;
import com.loga.QuizService.Entity.onlyAnswer;
import com.loga.QuizService.Entity.onlyQuestion;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
@FeignClient("QUESTIONSERVICE")

public interface myFeignInterface {


    @PostMapping("/question/createQuestionsForQuiz")
 List<onlyQuestion>createQuestionsForQuiz(@RequestBody ObjectForCreateQuiz d);
    @PostMapping("/question/getMarksForQuiz")
   Long getMarksForQuiz( @RequestParam String id,@RequestBody List<String>answerList);

    @GetMapping("/question/getAnswerForQuiz")
     onlyAnswer getAnswerForQuiz(@RequestParam String id);

}
