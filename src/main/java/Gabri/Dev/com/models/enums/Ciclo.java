package Gabri.Dev.com.models.enums;

import java.time.Month;

public enum Ciclo {
    ENERO(Month.JANUARY),
    FEBRERO(Month.FEBRUARY),
    MARZO(Month.MARCH),
    ABRIL(Month.APRIL),
    MAYO(Month.MAY),
    JUNIO(Month.JUNE),
    JULIO(Month.JULY),
    AGOSTO(Month.AUGUST),
    SEPTIEMBRE(Month.SEPTEMBER),
    OCTUBRE(Month.OCTOBER),
    NOVIEMBRE(Month.NOVEMBER),
    DICIEMBRE(Month.DECEMBER);

    private final Month mes;

    Ciclo(Month mes) {
        this.mes = mes;
    }

    public Month getMonth() {
        return mes;
    }
}
