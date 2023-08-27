package com.loga.QuizService.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ObjectForCreateQuiz {
    String quizName;

    Integer noOfQuestions;
    String topic;
}