package com.mowitnow.tondeuse.process.service;


import com.mowitnow.tondeuse.process.model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.swing.*;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MowItNowService {


   private static Logger LOGGER = LoggerFactory.getLogger(MowItNowService.class);
    public List<PositionTondeuse> tondrePelouse (MowItNow mowItNowData){

        return mowItNowData.getTondeuses()
                .stream()
                .map((tondeuse ->{
                    return this.bougerTondeuse(tondeuse, mowItNowData.getTaillePelouse());
                })).collect(Collectors.toList());


    }

    private PositionTondeuse bougerTondeuse (Tondeuse tondeuse, TaillePelouse taillePelouse)  {

        PositionTondeuse result = new PositionTondeuse(tondeuse.getPosition());
        for (char i:tondeuse.getInstructions().toCharArray()){
          result = executeInstruction(result,String.valueOf(i),taillePelouse);
          LOGGER.debug("position actuelle de la tondeuse : " + result.getAbscisse() + "," + result.getOrdonnee() + "," + result.getOrientation());
       }
        //LOGGER.debug("position actuelle de la tondeuse : " + result.getAbscisse() + "," + result.getOrdonnee() + "," + result.getOrientation());
        return result;
    }

    private PositionTondeuse executeInstruction(PositionTondeuse positionTondeuse, String instruction, TaillePelouse taillePelouse) {

        if(InstructionsEnum.G.getCode().equals(instruction)){

            return  pivoterAGauche(positionTondeuse);
        }

        if(InstructionsEnum.D.getCode().equals(instruction)){

            return  pivoterADroite(positionTondeuse);
        }

            return avancer(positionTondeuse, taillePelouse);

      }


    private PositionTondeuse pivoterAGauche(PositionTondeuse position){

        PositionTondeuse result = new PositionTondeuse(position);

        if(OrientationEnum.N.equals(position.getOrientation())) {
            result.setOrientation(OrientationEnum.W);
        }
        else if(OrientationEnum.E.equals(position.getOrientation())) {
            result.setOrientation(OrientationEnum.N);
        }
        else if(OrientationEnum.W.equals(position.getOrientation())) {
            result.setOrientation(OrientationEnum.S);
        }
        else if(OrientationEnum.S.equals(position.getOrientation())) {
            result.setOrientation(OrientationEnum.E);
        }

        return result;

    }

    private PositionTondeuse pivoterADroite(PositionTondeuse position) {

        PositionTondeuse result = new PositionTondeuse(position);

        if(OrientationEnum.N.equals(position.getOrientation())) {
            result.setOrientation(OrientationEnum.E);
        }
        else if(OrientationEnum.E.equals(position.getOrientation())) {
            result.setOrientation(OrientationEnum.S);
        }
        else if(OrientationEnum.W.equals(position.getOrientation())) {
            result.setOrientation(OrientationEnum.N);
        }
        else {
            result.setOrientation(OrientationEnum.W);
        }

        return result;

    }

    private PositionTondeuse avancer(PositionTondeuse position, TaillePelouse taillePelouse) {

        PositionTondeuse result = new PositionTondeuse(position);

        if(OrientationEnum.N.equals(position.getOrientation())) {
            result.setOrdonnee(position.getOrdonnee()+1<=taillePelouse.getLargeur()? position.getOrdonnee()+1:position.getOrdonnee());
        }
        else if(OrientationEnum.E.equals(position.getOrientation())) {
            result.setAbscisse(position.getAbscisse()+1<=taillePelouse.getLongueur()?position.getAbscisse()+1:position.getAbscisse());
        }
        else if(OrientationEnum.W.equals(position.getOrientation())) {
            result.setAbscisse(position.getAbscisse()-1>=0? position.getAbscisse()-1: position.getAbscisse());
        }
        else {
            result.setOrdonnee(position.getOrdonnee()-1>=0? position.getOrdonnee()-1: position.getOrdonnee());
        }

        return result;
    }

}
