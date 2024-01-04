package com.globant.lib.services;

import io.restassured.response.Response;

import static com.globant.utils.Constants.BASE_URL;
import static io.restassured.RestAssured.given;

public class FilmService {
    private static final String FILMS_ENDPOINT = "films/";

    public Response getFilm(int id) {
        return given()
                .baseUri(BASE_URL)
                .get(FILMS_ENDPOINT + id);
    }
}
