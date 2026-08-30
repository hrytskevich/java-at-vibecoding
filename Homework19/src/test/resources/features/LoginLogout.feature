# language: ru

Функция: Login-Logout на Form Authentication
  Предыстория:
    Дано открываю стартовую страницу

    Сценарий: осуществить Login и Logout
      Когда кликаю на стартовой странице на элемент "Form Authentication"
      То заголовок страницы содержит текст "Login Page"
      Когда ввожу в поле Username значение "tomsmith"
      И ввожу в поле Password значение "SuperSecretPassword!"
      И кликаю на кнопку Login
      То проверяю, что сообщение с результатом содержит текст "You logged into a secure area!"
      И проверяю, что на экране есть кнопка Logout
      Когда кликаю на кнопку Logout
      То заголовок страницы содержит текст "Login Page"

  Сценарий: осуществить Login с неверными кредами
    Когда кликаю на стартовой странице на элемент "Form Authentication"
    То проверяю, что на экране есть ссылка с текстом "Elemental Selenium"
    Когда ввожу в поле Username значение "admin"
    И ввожу в поле Password значение "1234"
    И кликаю на кнопку Login
    То проверяю, что сообщение с результатом содержит текст "Your username is invalid!"
