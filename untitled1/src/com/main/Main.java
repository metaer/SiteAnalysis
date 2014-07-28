package com.main;

import ru.pavelpopovjava.siteanalysis.Analyst;
import ru.pavelpopovjava.siteanalysis.AnalystException;

public class Main {
    public static void main(String[] args) {
        //TODO Сделать валидацию на второй входной параметр (должен быть целочисленным), сделать валидацию на кол-во параметров (2 параметра)
        //Создаем объект для работы с анализатором
        Analyst analyst = new Analyst(args[0], Integer.valueOf(args[1]));
        //Выполняем анализ
        try {
            analyst.run();
        } catch (AnalystException e) {
            System.out.println(e.getMessage());
            System.exit(0);
        }
        //Выводим на экран результат
        analyst.printResult();
        //TODO Сделать сохранение в xml файл
    }
}
