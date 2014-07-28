package ru.pavelpopovjava.siteanalysis;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.net.UnknownHostException;

/**
 * Класс для получения исходного кода страницы. Оставляем доступ только в пределах пакета
 */
class HtmlGetter {
    static String getPageHtml(String url) throws WrongDomainException, RequestException {
        //Проверяем существование домена
        Validator.validateDomainExistingViaDNS();

        String html = "";

        //Получаем html код страницы
        try {
            html = getContentOfHTTPPage("http://" + url, "UTF-8");
        } catch (UnknownHostException e) {
            throw new RequestException("Ошибка: " + url + " не существует");
        }
        catch (Exception e) {
            throw new RequestException("Ошибка получения данных: " + e.toString());
        }

        return html;
    }

    private static String getContentOfHTTPPage(String pageAddress, String codePage) throws Exception {
        StringBuilder sb = new StringBuilder();
        URL pageURL = new URL(pageAddress);
        URLConnection uc = pageURL.openConnection();
        BufferedReader br = new BufferedReader(
                new InputStreamReader(uc.getInputStream(), codePage)
        );

        try {
            String inputLine;
            while ((inputLine = br.readLine()) != null) {
                sb.append(inputLine);
            }
        } finally {
            br.close();
        }
        return sb.toString();
    }
}
