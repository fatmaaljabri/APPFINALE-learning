package com.APPJAVAFSTELEARNINdto;


import com.APPJAVAFSTELEARNIN.entity.Niveau;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CourseCardDTO {

    private Long id;
    private String titre;
    private String imageUrl;
    private Niveau niveau;
    private String categorie;

    private Long nbInscrits;
}