package ru.pavelpopovjava.siteanalysis;

import java.util.ArrayList;
import java.util.Arrays;
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
        int[] allowedValuesArray = {
                Analyst.ANALYSE_EMAILS,
                Analyst.DATA_CAPACITY,
                Analyst.INTEGERS,
                Analyst.ROMAN_NUMERALS
            };

        List allowedValues = Arrays.asList(allowedValuesArray);
        if (!allowedValues.contains(method)) {
            throw new WrongMethodException(method);
        }
    }

    public static void validateDomainExistingViaDNS() throws WrongDomainException {
        //TODO сделать
    }
}
