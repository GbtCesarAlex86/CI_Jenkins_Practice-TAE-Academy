package com.globant.tests;

import com.globant.utils.tests.BaseTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class statusCodeCheckTest extends BaseTest {
    @Test
    @Parameters({"filmId", "statusCode"})
    public void filmStatusCodeTest(String filmId, String statusCode) {
        validateResponseStatusCode(Integer.parseInt(filmId), Integer.parseInt(statusCode));
    }
}