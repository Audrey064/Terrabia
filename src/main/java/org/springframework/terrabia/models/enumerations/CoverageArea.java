package org.springframework.terrabia.models.enumerations;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Set;

import static org.springframework.terrabia.models.enumerations.Street.*;

@RequiredArgsConstructor
@Getter
public enum CoverageArea {

    YAOUNDE_1(
            Set.of(CENTRE_COMMERCIAL, ELIG_ESSONO, ETOA_MEKI_1, ETOA_MEKI_2, NLONGKAK, ELIG_EDZOA, BASTOS, MANGUIER, TONGOLO, MBALLA_1, MBALLA_2, MBALLA_3, NKOLONDOM, ETOUDI, MESSASSI, OKOLO, OLEMBE, NYOM, EMANA, NKOLETON)
    ),
    YAOUNDE_2(
            Set.of(CITE_VERTE, MADAGASCAR, MOKOLO, GRAND_MESSA, EKOUDOU, TSINGA, NKOMKANA, OLIGA, MESSA_CARRIERE, FEBE, NTOUNGOU)
    ),
    YAOUNDE_3(
            Set.of(OBILI, NGOAEKELE_1, NLONG_MVOLYE, AHALA_1, AHALA_2, EFOULAN, OBOBOGO, NSAM, MELEN_2, ETOA, NKOLMESSENG_1, AFANOYA_1, AFANOYA_2, AFANOYA_3, AFANOYA_4, NKOLFON, MEKOUMBOU_1, MEKOUMBOU_2, NTOUESSONG, NSIMEYONG_1, NSIMEYONG_2, NSIMEYONG_3, OLEZOA, DAKAR, NGOAEKELE_2)
    ),
    YAOUNDE_4(
            Set.of(MVOGADA, MVOGMBI, MIMBOMAN, KONDENGUI, NKOLNDONGO, EMOMBO, NKOLEBOGO, QUARTIER_FOUDA, ETAMBAFIA, NKOLBIKOK)
    ),
    YAOUNDE_5(
            Set.of(BIYEMASSI, ESSOS, NKOLBISSON, NKOLEBOGO_2, MVOGBETSI, MVOGATSA, NKOLMESSENG_2, ETOUGEBE)
    ),
    YAOUNDE_6(
            Set.of(MVOGADA_2, MVOGBETSI_2, NKOLBISSON_2, NKOLETON_2)
    ),
    YAOUNDE_7(
            Set.of(NKOLBISSON_3, NKOLEBOGO_4, MVOGBETSI_3, MVOGATSA_2, NKOLETON_3)
    );


    private final Set<Street> streets;

    public static float getPrice(float weight, float orderPrice) {
        if (weight < 1.0f)
            return 1000;
        if (weight < 10 )
            return 0.01f * orderPrice;
        if (weight < 100 )
            return 0.05f * orderPrice;
        if (weight < 250 )
            return 0.1f * orderPrice;
        return orderPrice * 0.2f;
    }
}
