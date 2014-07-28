package ru.pavelpopovjava.siteanalysis;

public class Analyst {

    private String url;

    private int method;

    public Analyst(String url, int method) {
        this.url = url;
        this.method = method;
    }

    public void run() throws AnalystException{
    }

    public void printResult() {

    }
}
