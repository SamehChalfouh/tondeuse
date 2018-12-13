package com.mowitnow.tondeuse.process.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;


@ApiModel(description = "les coordonnées de la tondeuse")
public class PositionTondeuse {


    @NotNull
    @ApiModelProperty (notes = "x")
    private int abscisse;

    @ApiModelProperty(notes = "y")
    @NotNull
    private int ordonnee;

    @NotNull
    @ApiModelProperty(notes = "lettre indiquant l'orientation de la tondeuse", allowableValues = "N,E,W,S")
    @JsonProperty(value = "orientation")
    private OrientationEnum orientation;

    public PositionTondeuse() {
        super();

    }

    public PositionTondeuse( int x, int y, OrientationEnum orientation) {
       this.abscisse = x;
       this.ordonnee= y;
       this.orientation = orientation;

    }

    public PositionTondeuse(PositionTondeuse position){

        this.abscisse =position.getAbscisse();
        this.ordonnee=position.getOrdonnee();
        this.orientation = position.getOrientation();

    }


    public int getAbscisse() {
        return abscisse;
    }

    public void setAbscisse(int abscisse) {
        this.abscisse = abscisse;
    }

    public int getOrdonnee() {
        return ordonnee;
    }

    public void setOrdonnee(int ordonnee) {
        this.ordonnee = ordonnee;
    }

    public OrientationEnum getOrientation() {
        return orientation;
    }

    public void setOrientation(OrientationEnum orientation) {

        this.orientation = orientation;
    }


}






