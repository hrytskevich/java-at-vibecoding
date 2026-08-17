package org.hw_14;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class XMLUtilsTests {
    @Test
    public void test1() {
        String result = XMLUtils.createEmptyElement("user");
        Assertions.assertEquals("<user></user>", result, "Неверно сформирован XML тег при корректно переданном значении");
    }

    @Test
    public void test2() {
        String result = XMLUtils.createEmptyElement("");
        Assertions.assertEquals("<invalid/>", result, "Неверно сформирован XML тег, если передана пустая строка");
    }

    @Test
    public void test3() {
        String result = XMLUtils.createEmptyElement(null);
        Assertions.assertEquals("<invalid/>", result, "Неверно сформирован XML тег, если передан null");
    }
}
