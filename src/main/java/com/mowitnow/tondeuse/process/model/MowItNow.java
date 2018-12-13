package com.mowitnow.tondeuse.process.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.util.List;


@ApiModel(description = "class qui reprsente les donnees entrantes .")
public class MowItNow {

    @NotNull
    private  TaillePelouse taillePelouse;

    @NotNull
    @ApiModelProperty(notes = "la liste des tondeuses à déployer")
    private List<Tondeuse> tondeuses;

    public TaillePelouse getTaillePelouse() {
        return taillePelouse;
    }

    public void setTaillePelouse(TaillePelouse taillePelouse) {
        this.taillePelouse = taillePelouse;
    }

    public List<Tondeuse> getTondeuses() {
        return tondeuses;
    }

    public void setTondeuses(List<Tondeuse> tondeuses) {
        this.tondeuses = tondeuses;
    }
}
