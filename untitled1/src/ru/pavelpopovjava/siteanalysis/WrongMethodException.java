package ru.pavelpopovjava.siteanalysis;

/**
 * Исключение выбрасывается в случае, если передали неверный второй параметр (вариант анализа), например 5
 */
public class WrongMethodException extends AnalystException {
    //Вводим переданный параметр, чтобы пользователь библиотеки, смог сделать свое сообщение об ошибке, поймав это исключение
    private int passedParameter;

    /**
     * Конструктор
     * @param passedParameter переданный параметр
     */
    public WrongMethodException(int passedParameter) {
        this.passedParameter = passedParameter;
    }

    /**
     * Публичный метод для получения параметра
     * @return
     */
    public int getPassedParameter() {
        return passedParameter;
    }

    @Override
    public String getMessage() {
        return "Параметр №2 (Вариант анализа) может находиться в пределах от 1 до 4. Был передан параметр со значением " + passedParameter;
    }
}
