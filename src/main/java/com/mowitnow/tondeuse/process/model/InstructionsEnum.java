package com.mowitnow.tondeuse.process.model;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum InstructionsEnum {


    D("D"), G("G"), A("A"), UNKNOWN("");

    private String code ;

    InstructionsEnum (String code){

        this.code=code;
    }

    @JsonCreator
    public static InstructionsEnum fromValue(String code) {

        try {
            return valueOf(code);
        } catch (IllegalArgumentException e) {
            return InstructionsEnum.UNKNOWN;
        }
    }

    public String getCode() {
        return this.code;
    }
}
