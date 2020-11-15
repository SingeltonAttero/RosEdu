## РОССЕТИ "ТРЕНАЖЕР" 
### Хакатон
#### Приложение Цифровая подстанция - платформа, позволяющая обучать сотрудников работе с реальными устройствами подстанции с помощью эмуляции этих устройств в приложении. 

--------

#### Чтобы успешно пройти задание, пользователь должен выполнить все настройки устройств и соединить их между собой, а приложение самостоятельно проверит правильность настройки. Для оценки знаний после прохождения задания запускается тест.

--------

### Для запуска приложения необходима 
 * Android Studio v. 4.1 или выше. Так же можно запустить на  IntelliJ IDEA 2020.2.3 или выше
 * Необходимо добавить в AVD Manager эмулятор с конфигурацией
    * android os версия 6 или выше 
    * API VERSION 21 или выше  
    * диагональ 8.86
    * разрешения экрана  2048x1536 
    * рекомендуемое устройство в эмуляторе NEXUS 9 API 29
 * Эмуляторы Bluestack, Genymotion и т.д. позволяют использовать приложение на операционной системе Windows.
 * Для реального устройство 
     * android os версия 6 или выше 
     * диагональ 8.86
     * разрешения экрана  2048x1536 
     * ОЗУ 2 гб или больше
* Следующий шагом необходимо собрать из исходного кода апк и установить на эмуляторе или устройстве 

--------

### Демонстрация работы
* Авторизация пользователя

![Auth](https://github.com/askont/RosEdu/blob/master/image/auth.png)

* Настройка карты подключения с помощью простого меню

![setting_connection_open_menu](https://github.com/askont/RosEdu/blob/master/image/setting_connection_open_menu.png)
![setting_connection_device](https://github.com/askont/RosEdu/blob/master/image/setting_connection_device.png)
 
* Настройки коммутатора
  
![setting_switcher_1](https://github.com/askont/RosEdu/blob/master/image/setting_switcher_1.png)
  
* Настройка устройства 

![setting_device_1](https://github.com/askont/RosEdu/blob/master/image/setting_device_1.png)

  
### Стек технологий 
* Kotlin
* Gradle
* google architecture components
* MVVM
* Cicerone
* Koin
* Koin
* Flow
* Coroutines