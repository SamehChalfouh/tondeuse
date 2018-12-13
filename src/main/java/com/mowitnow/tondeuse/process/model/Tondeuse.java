package com.mowitnow.tondeuse.process.model;


import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

public class Tondeuse {

    @NotNull
    private PositionTondeuse position;

    @NotNull
    @ApiModelProperty(notes = "les instructions d'exploration de la pelouse", allowableValues = "G,D,A" , example = "GAGAGAGAA")
    private String instructions;

    public Tondeuse (){
        super();

    }

    public Tondeuse (Tondeuse tondeuse) {

    this.position = new PositionTondeuse(tondeuse.getPosition());
    this.instructions = tondeuse.getInstructions();
}

    public PositionTondeuse getPosition() {
        return position;
    }

    public void setPosition(PositionTondeuse position) {
        this.position = position;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }
}
