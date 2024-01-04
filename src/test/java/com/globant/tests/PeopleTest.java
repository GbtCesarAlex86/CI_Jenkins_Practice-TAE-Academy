package com.globant.tests;

import com.globant.lib.models.Person;
import com.globant.utils.Constants;
import com.globant.utils.tests.BaseTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class PeopleTest extends BaseTest {

    @Test
    @Parameters({"personId"})
    public void peopleEndPointTest(int personId) {
        Person personResponse = getPerson(personId);
        validateSkinColor(personResponse, Constants.SKIN_COLOR);
        validateAmountOfFilmsItAppears(personResponse, Constants.FILM_COUNT);
    }
}