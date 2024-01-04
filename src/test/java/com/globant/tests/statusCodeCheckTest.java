package com.globant.tests;

import com.globant.utils.tests.BaseTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class statusCodeCheckTest extends BaseTest {
    @Test
    @Parameters({"filmId", "statusCode"})
    public void filmStatusCodeTest(int filmId, int statusCode) {
        validateResponseStatusCode(filmId, statusCode);
    }
}