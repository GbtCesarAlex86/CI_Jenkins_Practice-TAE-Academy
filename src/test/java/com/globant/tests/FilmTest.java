package com.globant.tests;

import com.globant.lib.models.Film;
import com.globant.lib.models.Person;
import com.globant.utils.tests.BaseTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class FilmTest extends BaseTest {

    @Test
    @Parameters({"personId"})
    public void filmFromPersonTest(int personId) {
        Person personResponse = getPerson(personId);
        Film filmResponse = getFilm(getIdAsString(personResponse.getFilms().get(1)));

        validateReleaseDateFormat(filmResponse);
        validateCharacters(filmResponse);
        validatePlanets(filmResponse);
        validateStarships(filmResponse);
        validateVehicles(filmResponse);
        validateSpecies(filmResponse);
    }
}
