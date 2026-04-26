package com.APPJAVAFSTELEARNINdto;


import com.APPJAVAFSTELEARNIN.entity.StatutInscription;
import lombok.*;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InscriptionDTO {

    private String apprenantNom;

    private LocalDate dateInscription;

    private StatutInscription statut;

    private double progression;
}