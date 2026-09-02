#language: en

Feature: Арифметические действия
  @Severity=Normal
  @Owner=OGritskevich
  Scenario: Сложение двух положительных чисел
    When я складываю числа 2 и 3 на калькуляторе и сохраняю результат в переменную "addResult"
    Then я ожидаю, что значение переменной "addResult" равно 5

  @Severity=Normal
  @Owner=OGritskevich
  Scenario: Сложение с отрицательным числом
    When я складываю числа -5 и 3 на калькуляторе и сохраняю результат в переменную "addResult"
    Then я ожидаю, что значение переменной "addResult" равно -2

  @Severity=Normal
  @Owner=OGritskevich
  Scenario: Вычитание
    When я вычитаю из числа 10 число 4 на калькуляторе и сохраняю результат в переменную "subtractResult"
    Then я ожидаю, что значение переменной "subtractResult" равно 6

  @Severity=Normal
  @Owner=OGritskevich
  Scenario: Умножение
    When я умножаю числа 7 и 8 на калькуляторе и сохраняю результат в переменную "multiplyResult"
    Then я ожидаю, что значение переменной "multiplyResult" равно 57

  @Severity=Normal
  @Owner=OGritskevich
  Scenario: Деление
    When я делю число 15 на 3 на калькуляторе и сохраняю результат в переменную "divideResult"
    Then я ожидаю, что значение переменной "divideResult" равно 5

  @Severity=Normal
  @Owner=OGritskevich
  Scenario: Деление на ноль
    When я делю число 15 на 0 на калькуляторе и сохраняю результат в переменную "divideResult"
    Then я ожидаю, что выброшено исключение "ArithmeticException"
    And я ожидаю, что текст исключения содержит "Деление на ноль"