package ru.pavelpopovjava.siteanalysis;

/**
 * Анализатор. Главный класс пакета
 */
public class Analyst {

    private String url;

    private int method;

    public static final int ANALYSE_EMAILS = 1;
    public static final int ROMAN_NUMERALS = 2;
    public static final int INTEGERS = 3;
    public static final int DATA_CAPACITY = 4;

    public Analyst(String url, int method) throws AnalystException{
        //Проверяем, что метод анализа находится в пределах от 1 до 4
        Validator.validateMethodOfAnalysis(method);
        //Записываем переданные параметры в свойства объекта
        this.url = url;
        this.method = method;
    }

    public void run() throws AnalystException{

    }

    public void printResult() {

    }
}
