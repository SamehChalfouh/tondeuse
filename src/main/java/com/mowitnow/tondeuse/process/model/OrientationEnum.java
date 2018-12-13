package com.mowitnow.tondeuse.process.model;

import com.fasterxml.jackson.annotation.JsonCreator;


public enum OrientationEnum {


    N("N"), E("E"), W("W"), S("S"), UNKNOWN("");

    private String code ;

    OrientationEnum (String code){

        this.code=code;
    }


    @JsonCreator
    public static OrientationEnum fromValue(String code) {

        try {
            return valueOf(code);
        } catch (IllegalArgumentException e) {
            return OrientationEnum.UNKNOWN;
        }
    }

    public String getCode() {
        return code;
    }
}
