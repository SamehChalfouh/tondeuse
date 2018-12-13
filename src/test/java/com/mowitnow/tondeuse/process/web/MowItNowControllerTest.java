package com.mowitnow.tondeuse.process.web;


import com.mowitnow.tondeuse.process.Application;
import com.mowitnow.tondeuse.process.model.*;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@EnableAutoConfiguration
public class MowItNowControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testTendrePelouse_OK() throws Exception {


        MowItNow mowItNowData = new MowItNow();

        mowItNowData.setTaillePelouse(new TaillePelouse(5, 5));

        //tondeuse 1
        Tondeuse tondeuse1 = new Tondeuse();
        tondeuse1.setInstructions("GAGAGAGAA");
        tondeuse1.setPosition(new PositionTondeuse(1, 2, OrientationEnum.N));

        Tondeuse tondeuse2 = new Tondeuse();
        tondeuse2.setInstructions("AADAADADDA");
        tondeuse2.setPosition(new PositionTondeuse(3, 3, OrientationEnum.E));


        mowItNowData.setTondeuses(new ArrayList<Tondeuse>());
        mowItNowData.getTondeuses().add(tondeuse1);
        mowItNowData.getTondeuses().add(tondeuse2);

        HttpHeaders headers = new HttpHeaders();
        HttpEntity<MowItNow> entity = new HttpEntity<>(mowItNowData,headers);
        ResponseEntity <RetourProcessTendeuse> response = restTemplate.exchange(
                createURLWithPort("/mowItNow/api/mow"),
                HttpMethod.PUT, entity, RetourProcessTendeuse.class);


        Assert.assertEquals(HttpStatus.OK,response.getStatusCode());
        List<PositionTondeuse> listePositioTendeuse = response.getBody().getListePositioTendeuse();
        Assert.assertEquals(1,listePositioTendeuse.get(0).getAbscisse());
        Assert.assertEquals(3,listePositioTendeuse.get(0).getOrdonnee());
        Assert.assertEquals(OrientationEnum.N,listePositioTendeuse.get(0).getOrientation());

    }

    @Test
    public void testTendrePelouse_KO() throws Exception {


        MowItNow mowItNowData = new MowItNow();

        mowItNowData.setTaillePelouse(null);

        mowItNowData.setTondeuses(new ArrayList<Tondeuse>());


        HttpHeaders headers = new HttpHeaders();
        HttpEntity<MowItNow> entity = new HttpEntity<>(mowItNowData,headers);
        ResponseEntity <RetourProcessTendeuse> response = restTemplate.exchange(
                createURLWithPort("/mowItNow/api/mow"),
                HttpMethod.PUT, entity, RetourProcessTendeuse.class);


        Assert.assertEquals(HttpStatus.BAD_REQUEST,response.getStatusCode());


    }


    private String createURLWithPort(String uri) {
        return "http://localhost:" + port + uri;
    }

}
