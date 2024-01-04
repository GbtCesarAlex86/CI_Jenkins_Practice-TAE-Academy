package com.globant.utils.tests;

import com.globant.lib.models.Film;
import com.globant.lib.models.Person;
import com.globant.lib.models.Planet;
import com.globant.lib.services.MainService;
import com.globant.utils.Constants;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BaseTest {

    protected MainService mainService;

    @BeforeTest
    public void connectionSetUp() {
        RestAssured.baseURI = getBaseUrl();
        mainService = new MainService();
    }

    protected Person getPerson(int personId) {
        Response response = mainService.createPeopleService().getPerson(personId);
        validateStatusCode(response.getStatusCode(), Constants.SUCCESS_GET_STATUS_CODE);
        return response.as(Person.class);
    }

    protected Film getFilm(int filmId) {
        Response response = mainService.createFilmService().getFilm(filmId);
        validateStatusCode(response.getStatusCode(), Constants.SUCCESS_GET_STATUS_CODE);
        return response.as(Film.class);
    }

    protected Planet getPlanet(int planetId) {
        Response response = mainService.createPlanetService().getPlanet(planetId);
        validateStatusCode(response.getStatusCode(), Constants.SUCCESS_GET_STATUS_CODE);
        return response.as(Planet.class);
    }

    protected void validateResponseStatusCode(int filmId, int statusCode){
        Response response = mainService.createFilmService().getFilm(filmId);
        validateStatusCode(response.getStatusCode(), statusCode);
    }

    protected void validatePlanetResponseUrl(Planet planetResponse){
        String url = planetResponse.getUrl();
        Planet planetToCompare = getPlanet(getIdAsString(url));

        Assert.assertEquals(planetResponse, planetToCompare);
    }

    protected int getIdAsString(String url) {
        String idAsString = url.substring(url.lastIndexOf("/") - 1, url.lastIndexOf("/"));
        return Integer.parseInt(idAsString);
    }

    protected void validateGravity(Planet planetResponse) {
        validateStrings(planetResponse.getGravity(), Constants.EXPECTED_GRAVITY);
    }

    protected void validateTerrains(Planet planetResponse) {
        List<String> actualTerrains = new ArrayList<>();
        for (String terrain : planetResponse.getTerrain()) {
            actualTerrains.add(terrain.trim());
        }
        List<String> expectedTerrains = new ArrayList<>(Constants.EXPECTED_TERRAINS);

        Collections.sort(actualTerrains);
        Collections.sort(expectedTerrains);

        Assert.assertEquals(actualTerrains, expectedTerrains);
    }

    protected void validateReleaseDateFormat(Film filmResponse){
        boolean isCorrect;
        String dateFilm = filmResponse.getRelease_date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);

        try{
            dateFormat.parse(dateFilm);
            isCorrect = true;
        }catch(ParseException e){
            isCorrect = false;
        }
        Assert.assertTrue(isCorrect);
    }

    protected void validateCharacters(Film film) {
        Assert.assertTrue(film.getCharacters().size() > 1);
    }

    protected void validatePlanets(Film film) {
        Assert.assertTrue(film.getPlanets().size() > 1);
    }

    protected void validateStarships(Film film) {
        Assert.assertTrue(film.getStarships().size() > 1);
    }

    protected void validateVehicles(Film film) {
        Assert.assertTrue(film.getVehicles().size() > 1);
    }

    protected void validateSpecies(Film film) {
        Assert.assertTrue(film.getSpecies().size() > 1);
    }

    protected void validateSkinColor(Person person, String expectedSkinColor){
        validateStrings(person.getSkinColor(), expectedSkinColor);
    }

    protected void validateAmountOfFilmsItAppears(Person person, int expectedFilmCount) {
        validateQuantity(person.getFilms().size(), expectedFilmCount);
    }

    private void validateStatusCode(int actualStatusCode, int expectedStatusCode){
        Assert.assertEquals(actualStatusCode, expectedStatusCode);
    }

    private void validateStrings(String actualString, String expectedString){
        Assert.assertEquals(actualString, expectedString);
    }

    private void validateQuantity(int actualNumber, int expectedNumber){
        Assert.assertEquals(actualNumber, expectedNumber);
    }

    private String getBaseUrl(){
        return Constants.BASE_URL;
    }

}