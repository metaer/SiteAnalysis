package ru.pavelpopovjava.siteanalysis;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Анализатор. Главный класс пакета
 */
public class Analyst {
    private String url;

    /**
     * Вариант анализа (метод анализа)
     */
    private int method;

    /**
     * Резульатат анализа
     */
    private String result;

    public static final int ANALYSE_EMAILS = 1;
    public static final int ANALYSE_ROMAN_NUMERALS = 2;
    public static final int ANALYSE_NUMERICS =       3;
    public static final int ANALYSE_DATA_CAPACITY =  4;

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
                result = analyseByRegExp(html, "[-a-z0-9!#$%&'*+/=?^_`{|}~]+(\\.[-a-z0-9!#$%&'*+/=?^_`{|}~]+)*@([a-z0-9]([-a-z0-9]{0,61}[a-z0-9])?\\.)*(aero|arpa|asia|biz|cat|com|coop|edu|gov|info|int|jobs|mil|mobi|museum|name|net|org|pro|tel|travel|[a-z][a-z])");
//                result = analyseByRegExp(html, "(\\S+)@([a-z0-9-]+)(\\.)([a-z]{2,4})(\\.?)([a-z]{0,4})+");
                break;
            case ANALYSE_ROMAN_NUMERALS:
                result = analyseByRegExp(html, "[MDCLXVI]");
                break;
            case ANALYSE_NUMERICS:
                result = analyseByRegExp(html, "[0-9]");
                break;
            case ANALYSE_DATA_CAPACITY:
                result = analyseDataCapacity(html);
        }
    }

    private String analyseDataCapacity(String html) {
        //TODO сделать
        return null;
    }

    private String analyseByRegExp(String html, String regExp) {
        Pattern pattern = Pattern.compile(regExp);
        Matcher matcher = pattern.matcher(html);
        Map<Integer, String> res = new HashMap<>();
        while (matcher.find()){
            res.put(matcher.start(), matcher.group());
        }
        return res.toString();
    }

    public void printResult() {
        System.out.println(result);
    }
}
