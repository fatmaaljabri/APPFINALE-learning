package com.APPJAVAFSTELEARNINdto;


import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class QuestionResultDTO {

    private String question;

    private int bonneReponse;
    private int reponseChoisie;

    private boolean correcte;
}