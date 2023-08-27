package com.loga.QuizService.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "Quiz")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Quiz {
    @Id
    private String quizName;
    private Integer noOfQuestions;
    private String topic;
    private List<onlyQuestion> questionsList;



}
