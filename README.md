# OTUSFinalProjectAPetrukhno

UI автотесты для https://wishlist.otus.kartushin.su

## Стек
Java, Maven, JUnit5, Selenium WebDriver, WebDriverManager, log4j2, Page Object.

## Критичные сценарии (автотесты)

1. Авторизация пользователя (LoginTest)
2. Выход из системы (LogoutTest)
3. Создание списка желаний (CreateWishlistTest)
4. Удаление списка желаний (DeleteWishlistTest)
5. Добавление подарка в список желаний (AddGiftToWishlistTest)
6. Дополнительно: просмотр списка пользователей (UsersPageTest)

## Запуск тестов

Тесты используют параметры JVM (System properties). Параметры логин/пароль передаются при запуске Maven:

### Chrome
```bash
mvn test -DbaseUrl=https://wishlist.otus.kartushin.su -Dbrowser=chrome -Dlogin=YOUR_LOGIN -Dpassword=YOUR_PASSWORD
```

### Firefox
```bash
mvn test -DbaseUrl=https://wishlist.otus.kartushin.su -Dbrowser=firefox -Dlogin=YOUR_LOGIN -Dpassword=YOUR_PASSWORD
```

### Remote (Selenium Grid)
```bash
mvn test -Dremote=true -DgridUrl=http://localhost:4444/wd/hub -Dbrowser=chrome -Dlogin=YOUR_LOGIN -Dpassword=YOUR_PASSWORD
```