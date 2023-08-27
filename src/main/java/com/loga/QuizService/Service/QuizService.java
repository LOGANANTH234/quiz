package com.loga.QuizService.Service;
import com.loga.QuizService.Entity.ObjectForCreateQuiz;
import com.loga.QuizService.Entity.Quiz;
import com.loga.QuizService.Entity.onlyAnswer;
import com.loga.QuizService.Entity.onlyQuestion;
import com.loga.QuizService.Repository.QuizRepository;
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

    public List<onlyQuestion> createQuiz( ObjectForCreateQuiz objectForCreateQuiz ) {
     List<onlyQuestion> onlyQuestionList=feignClient.createQuestionsForQuiz(objectForCreateQuiz);
    quizRepository.save(new Quiz(objectForCreateQuiz.getQuizName(),objectForCreateQuiz.getNoOfQuestions(),objectForCreateQuiz.getTopic(),onlyQuestionList));
return onlyQuestionList;
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

    public Quiz getQuizById(String id) {
        Optional<Quiz> quiz = quizRepository.findById(id);
        if (quiz.isPresent()){
            return quiz.get();
        }
        return null ;
    }

    public Long  getMarksForQuiz(String id,List<String> answerList) {
        return feignClient.getMarksForQuiz(id,answerList);
    }



    public onlyAnswer getAnswers(String id) {
return feignClient.getAnswerForQuiz(id);
    }
}
