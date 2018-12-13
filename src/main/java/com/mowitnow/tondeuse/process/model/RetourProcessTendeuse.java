package com.mowitnow.tondeuse.process.model;

import java.util.ArrayList;
import java.util.List;

public class RetourProcessTendeuse {

    private List<PositionTondeuse> listePositioTendeuse;





    public RetourProcessTendeuse(){
        this.listePositioTendeuse= new ArrayList<PositionTondeuse>();
    }


    public List<PositionTondeuse> getListePositioTendeuse() {
        return listePositioTendeuse;
    }

    public void setListePositioTendeuse(List<PositionTondeuse> listePositioTendeuse) {
        this.listePositioTendeuse = listePositioTendeuse;
    }
}
