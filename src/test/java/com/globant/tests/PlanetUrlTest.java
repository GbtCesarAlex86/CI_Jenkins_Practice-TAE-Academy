package com.globant.tests;

import com.globant.lib.models.Film;
import com.globant.lib.models.Person;
import com.globant.lib.models.Planet;
import com.globant.utils.tests.BaseTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class PlanetUrlTest extends BaseTest {
    @Test
    @Parameters({"personId"})
    public void planetUrlIsCorrectTest(String personId) {
        Person personResponse = getPerson(Integer.parseInt(personId));
        Film filmResponse = getFilm(getIdAsString(personResponse.getFilms().get(1)));
        Planet planetResponse = getPlanet(getIdAsString(filmResponse.getPlanets().get(0)));

        validatePlanetResponseUrl(planetResponse);
    }
}