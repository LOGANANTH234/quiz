package com.loga.QuizService.feign;

import com.loga.QuizService.Entity.dao;
import com.loga.QuizService.Entity.onlyAnswer;
import com.loga.QuizService.Entity.onlyQuestion;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
@FeignClient("QUESTIONSERVICE")

public interface myFeignInterface {


    @PostMapping("/question/createQuestionsForQuiz")
    public List<onlyQuestion>createQuestionsForQuiz(@RequestBody  dao d);
    @GetMapping("/question/getAnswersByIds")
    public List<onlyAnswer>getAnswerList();
}
