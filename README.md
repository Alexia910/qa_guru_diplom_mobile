# Проект по автоматизации тестирования приложения GnuCash
<a target="_blank" href="https://github.com/codinguser/gnucash-android">Репозиторий с приложением</a>

<a href="https://www.gnucash.org/"><img src="images\logoapp.png" height="60" alt="GnuCash"/></a>
## Содержание:
- [Технологии и инструменты](#alien-технологии-и-инструменты)
- [Реализованные проверки](#fairy-Реализованные-проверки)
- [Запуск тестов](#alien-Запуск-тестов)
- [Allure отчет](#alien-Allure-отчет)
- [Видео прохождения тестов](#fairy-Видео-прохождения-тестов)
- [Отчет в Telegram](#alien-Отчет-в-Telegram)

## :alien: Технологии и инструменты

<p align="center">
<a href="https://www.jetbrains.com/idea/"><img src="images\logo\Idea.svg" width="50" height="50"  alt="IDEA"/></a>
<a href="https://www.java.com/"><img src="images\logo\Java.svg" width="50" height="50"  alt="Java"/></a>
<a href="https://www.browserstack.com/"><img src="images\logo\browserstack-icon.svg" width="50" height="50"  alt="Browserstack"/></a>
<a href="https://appium.io/"><img src="images\logo\appium.svg" width=50" height="50"  alt="Appium"/></a>
<a href="https://github.com/"><img src="images\logo\GitHub.svg" width="50" height="50"  alt="Github"/></a>
<a href="https://junit.org/junit5/"><img src="images\logo\Junit5.svg" width="50" height="50"  alt="JUnit 5"/></a>
<a href="https://gradle.org/"><img src="images\logo\Gradle.svg" width="50" height="50"  alt="Gradle"/></a>
<a href="https://selenide.org/"><img src="images\logo\Selenide.svg" width="50" height="50"  alt="Selenide"/></a>
<a href="https://github.com/allure-framework/allure2"><img src="images\logo\Allure.svg" width="50" height="50"  alt="Allure"/></a>
<a href="https://www.jenkins.io/"><img src="images\logo\Jenkins.svg" width="50" height="50"  alt="Jenkins"/></a>
<a href="https://web.telegram.org/"><img width="50" height="50"  alt="Telegram" src="images\logo\Telegram.svg"></a>

## :fairy: Реализованные проверки
- [✓] Проверка экранов онбоардинга
- [✓] Проверка поиска на главной странице
- [✓] Проверка операции создания счёта

## :alien: Запуск тестов 
### Запуск в browserstack
* Создать файл с настройками:
> ```src/test/resources/browserstack.properties```
>
* Добавить данные:
>```
>username={из browserstack}
>password={из browserstack}
>identificateapp=bs://1c1a0c6b5e2c40df8140419c712e9dd1e0e0dff5
>url=http://hub.browserstack.com/wd/hub
>```
* Запуск тестов
> ```gradle clean test -DdeviceHost=browserstack```
### Запуск на эмуляторе или реальном девайсе
* Создать файл с настройками:
> ```src/test/resources/local.properties```
* Добавить данные:
>```
>deviceName={Название из android studio или adb, например: Nexus 4 API 30}
>platformName=Android
>platformVersion={Например: 11.0}
>rl=http://localhost:4723/wd/hub
>appFileName=GnucashAndroid_v2.4.0.apk
>appUrl=https://github.com/codinguser/gnucash-android/releases/download/v2.4.0/GnucashAndroid_v2.4.0.apk?raw=true
>```
* Запустить Appium на 4723 порту
* Запуск тестов
> ```gradle clean test -DdeviceHost=local```

## :alien: Allure отчет
После того как тесты завершились, можно получить визуальный Allure отчет.
<br>Способ 1: Сформировать отчет средствами IJ IDEA (Allure Serve)
<br>Способ 2:
<br>1. Выполнить сборку в Jenkins
<br>2. Убедиться, что в блоке История сборок (напротив номера #) появился желтый значок Allure Report
<br>3. Кликнуть по значку Allure Report
<br>Ожидаемый результат: Откроется страница с готовым Allure Report

###### Главный экран отчета (Owerwiev)
<p align="center">
<img title="Allure Graphics" src="images\allure_mian.png">
</p>

###### Страница с проведенными тестами (Suites)
<p align="center">
<img title="Allure Graphics" src="images\allure_tests.png">
</p>

## :fairy: Видео прохождения тестов
К каждому тесту (в отчете) прилагается автоматически сгенерированное видео. Пример:
<p align="center">
  <img title="Selenoid Video" src="images\video_test.gif" alt="video">
</p>

## :alien: Отчет в Telegram
После завершения сборки специальный Telegram-бот отправляет сообщение с отчетом о прогоне тестов.
Чтобы видеть сообщения от бота, вступите (временно) в телеграм-группу `TestNotification_alexiaair`

<p align="center">
<img title="Telegram Bot" src="images\telegram.png">
</p>