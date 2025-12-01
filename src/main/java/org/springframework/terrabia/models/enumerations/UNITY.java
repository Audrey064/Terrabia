package org.springframework.terrabia.models.enumerations;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum UNITY {

    KILOGRAMME("kg"),
    LITER("l");

    public final String symbol;
}
