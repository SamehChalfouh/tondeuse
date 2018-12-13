package com.mowitnow.tondeuse.process.web;


import com.mowitnow.tondeuse.process.model.MowItNow;
import com.mowitnow.tondeuse.process.model.PositionTondeuse;
import com.mowitnow.tondeuse.process.model.RetourProcessTendeuse;
import com.mowitnow.tondeuse.process.service.MowItNowService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/mowItNow/api")
@Api(value="Mow It Now", description="tondeuse à gazon automatique")
public class MowItNowController {

        @Autowired
        private MowItNowService mowItNowService;

        @ApiOperation(value = "tonte automatique de la pelouse", response = ResponseEntity.class)
        @ApiResponses(value = {
                @ApiResponse(code = 200, message = "Tonte terminée avec succés"),
                @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
                @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
                @ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
                @ApiResponse(code = 400, message = "Invalid Request Parameters")
        })
        @RequestMapping(value="/mow", method = RequestMethod.PUT)
        public ResponseEntity<RetourProcessTendeuse> tendrePelouse(@RequestBody @Valid MowItNow mowItNowData){

            List<PositionTondeuse> positionsFinales = mowItNowService.tondrePelouse(mowItNowData);
            RetourProcessTendeuse responce= new RetourProcessTendeuse();
            responce.getListePositioTendeuse().addAll(
                    positionsFinales);
            return new ResponseEntity<>(responce, HttpStatus.OK);

        }

}
