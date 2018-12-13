package com.mowitnow.tondeuse.process.model;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "la taille de la pelouse (coordonnées du coin supérieur droit")
public class TaillePelouse {

    @ApiModelProperty
    private int longueur;

    @ApiModelProperty
    private int largeur;


    public TaillePelouse(){

        super();
    }
    public TaillePelouse (int longueur, int largeur) {
        this.largeur = largeur;
        this.longueur = longueur;

    }


    public int getLongueur() {
        return longueur;
    }

    public void setLongueur(int longueur) {
        this.longueur = longueur;
    }

    public int getLargeur() {
        return largeur;
    }

    public void setLargeur(int largeur) {
        this.largeur = largeur;
    }
}
