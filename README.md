# OTUSFinalProjectAPetrukhno

UI автотесты для https://wishlist.otus.kartushin.su

## Стек
Java, Maven, JUnit5, Selenium WebDriver, WebDriverManager, log4j2, Page Object.

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