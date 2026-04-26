package com.APPJAVAFSTELEARNINdto;


import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProgressionDTO {

    private Long coursId;
    private String coursTitre;

    private double pourcentage;

    private int nbLeconsCompletees;
    private int totalLecons;
}