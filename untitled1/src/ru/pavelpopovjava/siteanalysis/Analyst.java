package ru.pavelpopovjava.siteanalysis;

public class Analyst {
    private static Analyst ourInstance = new Analyst();

    public static Analyst getInstance() {
        return ourInstance;
    }

    private Analyst() {
    }
}
