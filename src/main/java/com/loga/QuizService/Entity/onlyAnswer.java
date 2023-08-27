package com.loga.QuizService.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class onlyAnswer {
    private String quizName;
    private List<String> answer;
    private List<String> Explanation;
}
