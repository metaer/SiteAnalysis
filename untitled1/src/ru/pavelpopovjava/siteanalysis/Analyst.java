package ru.pavelpopovjava.siteanalysis;

/**
 * Анализатор. Главный класс пакета
 */
public class Analyst {

    private String url;

    private int method;

    private String result;

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
        //Запрос к сайту и получение html кода выносим в отдельный класс, т.к. это не задача анализатора
        String html = HtmlGetter.getPageHtml(url);

        switch (method) {
            case ANALYSE_EMAILS:

            case ROMAN_NUMERALS:

            case INTEGERS:

            case DATA_CAPACITY:
        }
    }

    public void printResult() {

    }
}
