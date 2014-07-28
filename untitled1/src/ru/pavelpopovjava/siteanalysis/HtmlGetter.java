package ru.pavelpopovjava.siteanalysis;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

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
            html = getContentOfHTTPPage(url, "UTF-8");
        } catch (Exception e) {
            throw new RequestException(e.getMessage());
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
