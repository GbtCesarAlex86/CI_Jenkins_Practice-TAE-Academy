package com.globant.lib.services;

import com.globant.utils.Constants;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class PlanetService {
    private static final String PLANETS_ENDPOINT = "planets/";

    public Response getPlanet(int id) {
        return given()
                .baseUri(Constants.BASE_URL)
                .get(PLANETS_ENDPOINT + id);
    }
}
