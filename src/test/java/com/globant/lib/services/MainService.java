package com.globant.lib.services;

public class MainService {

    public PeopleService createPeopleService(){
        return new PeopleService();
    }

    public FilmService createFilmService(){
        return new FilmService();
    }

    public PlanetService createPlanetService(){
        return new PlanetService();
    }
}