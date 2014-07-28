package ru.pavelpopovjava.siteanalysis;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс для валидаций. Используется только в пределах данного пакета
 */
class Validator {
    /**
     * Валидирует второй входной параметр (чтобы был в пределах от 1 до 4)
     * @throws WrongMethodException
     */
    public static void validateMethodOfAnalysis(int method) throws WrongMethodException {
        List allowedValues = new ArrayList<Integer>();
        fillArrayListWithConstants(allowedValues);
        if (!allowedValues.contains(new Integer(method))) {
            throw new WrongMethodException(method);
        }
    }

    private static void fillArrayListWithConstants(List allowedValues) {
        allowedValues.add(Analyst.ANALYSE_EMAILS);
        allowedValues.add(Analyst.DATA_CAPACITY);
        allowedValues.add(Analyst.NUMERICS);
        allowedValues.add(Analyst.ROMAN_NUMERALS);
    }

    public static void validateDomainExistingViaDNS() throws WrongDomainException {
        //TODO сделать
    }
}
