package com.loga.QuizService.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data

@AllArgsConstructor
public class onlyQuestion {

    private String question;
    private String option1;
    private String option2;
    private String option3;
    private String option4;
    private String topic;
}
