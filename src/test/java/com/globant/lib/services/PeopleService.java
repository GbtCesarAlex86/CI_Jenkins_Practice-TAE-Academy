package com.globant.lib.services;

import io.restassured.response.Response;

import static com.globant.utils.Constants.BASE_URL;
import static io.restassured.RestAssured.given;

public class PeopleService {

    private static final String PEOPLE_ENDPOINT = "people/";

    public Response getPerson(int id) {
        return given()
                .baseUri(BASE_URL)
                .get(PEOPLE_ENDPOINT + id);
    }
}