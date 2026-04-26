package com.APPJAVAFSTELEARNINdto;


import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class QuizResultDTO {

    private Long quizId;

    private double score;
    private int total;

    private double pourcentageReussite;

    private List<QuestionResultDTO> detailParQuestion;
}