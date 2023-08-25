package com.loga.QuizService.Service;



import com.loga.QuizService.Entity.Quiz;
import com.loga.QuizService.Entity.dao;
import com.loga.QuizService.Entity.onlyAnswer;
import com.loga.QuizService.Entity.onlyQuestion;
import com.loga.QuizService.Repository.QuizRepository;
////import com.loga.QuizService.feign.FeignInterface;
//import com.loga.QuizService.feign.FeignInterface;
//import com.loga.QuizService.feign.myFeignInterface;
import com.loga.QuizService.feign.myFeignInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuizService {
    @Autowired
    QuizRepository quizRepository;
@Autowired
 myFeignInterface feignClient;

    public Quiz createQuiz( dao d ) {
      List<onlyQuestion> onlyQuestionList=feignClient.createQuestionsForQuiz(d );
      List<onlyAnswer>onlyAnswerList=feignClient.getAnswerList();

       Quiz quiz= new Quiz(d.getQuizName(),d.getNoOfQuestions(),d.getTopic(),onlyQuestionList,onlyAnswerList);
        quizRepository.save(quiz);
        return quiz;
  }


    public boolean deleteQuiz(String quizName) {
        Optional<Quiz> optionalQuiz = quizRepository.findById(quizName);

        if (optionalQuiz.isEmpty()) {
            return false;
        }
        quizRepository.deleteById(quizName);
        return true;
    }

    public List<Quiz> getAllQuiz() {
        return quizRepository.findAll();
    }
}
