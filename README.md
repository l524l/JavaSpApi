# Java библиотека для SPM API
Библиотека для упрощения работы с api сервера spm.

### Оглавление
* [Зависимости](#depend)
* [Установка](#install)
* [Использование](#use)
  * [Инициализация главного объекта](#init)
  * [Класс Weather](#Weather)
    * [Enum WeatherType](#WeatherType)
  * [Класс Time](#Time)
    * [Enum TimeOfDay](#TimeOfDay)
  * [Класс OnlinePlayers](#OnlinePlayers)
  * [Класс Player](#player)
  * [Класс LastChatMessages](#LastChatMessages)
  * [Класс Message](#Message)
  * [Исключения](#Exception)

### Зависимости <a name="depend"></a>
* [Google GSON v.2.8.6](https://mvnrepository.com/artifact/com.google.code.gson/gson/2.8.6)
* [Apache HttpClient v.4.5.13](https://mvnrepository.com/artifact/org.apache.httpcomponents/httpclient/4.5.13)
* [Junit Jupiter v.5.7.0](https://mvnrepository.com/artifact/org.junit.jupiter/junit-jupiter-api/5.7.0)

### Установка <a name="install"></a>
#### Maven
```xml
<dependency>
    <groupId>com.github.l524l</groupId>
    <artifactId>JavaSpApi</artifactId>
    <version>1.0</version>
</dependency>
```
#### Jar
Так же вы можете [скачать](https://oss.sonatype.org/service/local/repositories/releases/content/com/github/l524l/JavaSpApi/1.0/JavaSpApi-1.0.jar) jar файл и подключить его как библиотеку к своему проекту 

### Использование <a name="use"></a>
#### Инициализация главного объекта <a name="init"></a>
Для использования библиотеки нужно создать объект класса `SpApi`
```java
SpApi spApi = new SpApi();
```
Список основных методов класса SpApi:
* getServerWeather() - возвращает объект класса `Weather`
* getServerTime() - возвращает объект класса `Time`
* getServerOnlinePlayers() - возвращает объект класса `OnlinePlayers`
* getServerLastChatMessages() - возвращает объект класса `LastChatMessages`
> Важно! При работе с данными методами может быть вызвано исключение `SpApiException`, которое нужно обработать.
#### Класс Weather <a name="Weather"></a>
Класс предназначен для получения погоды на сервере

Список основных методов класса:
* getWeather() - возвращает элемент enum'а `WeatherType`

##### Enum WeatherType <a name="WeatherType"></a>
Содержит значение состояния погоды:
`CLEAR`, `RAIN`, `THUNDER`
##### Пример:
```java
public class Example {
public static void main(String[] args){
        try {
            SpApi spApi = new SpApi();
            Weather weather = spApi.getServerWeather();
            weather.getWeather(); //CLEAR, RAIN, THUNDER
        } catch (SpApiException e) {
            //Какая-либо ошибка библиотеки
        }
    }
}
```
#### Класс Time <a name="Time"></a>
Класс предназначен для получения времени на сервере

Список основных методов класса:
* getTime() - возвращает элемент enum'а `TimeOfDay`
* getTicks() - возвращает `int` кол-во игровых тиков на сервере
* getFormated() - возвращает `String` форматированное представление времени типа: `00:00` 

##### Enum TimeOfDay <a name="TimeOfDay"></a>
Содержит значение состояния времени:
`DAY`, `NIGHT`

##### Пример:
```java
public class Example {
public static void main(String[] args){
        try {
            SpApi spApi = new SpApi();
            Time time = spApi.getServerTime();
            time.getTime(); //DAY
            time.getTicks(); //12000
            time.getFormated(); //12:00
        } catch (SpApiException e) {
            //Какая-либо ошибка библиотеки
        }
    }
}
```
#### Класс OnlinePlayers <a name="OnlinePlayers"></a>
Класс предназначен для получения и работы со списком игроков которые играют на сервере в данный момент

Список основных методов класса:
* getPlayers() - возвращает массив `Player[]` объектов класса `Player`
* getPlayersAsList() - возвращает список `List<Player>` объектов класса `Player`
* getCount() - возвращает `int` кол-во играющих на сервере игроков в данный момент
* getMax() - возвращает `int` максимально возможное кол-во игроков на сервере
* checkStatusByName(`String nickname`) - возвращает `boolean` онлайн игрок или нет
* checkStatusByUUID(`UUID playerUUID`) - возвращает `boolean` онлайн игрок или нет
* findByName(`String nickname`) - возвращает объект класса `Player`, если игрок онлайн если нет генерирует исключение PlayerNotFoundException
* findByUUID(`UUID playerUUID`) - возвращает объект класса `Player`, если игрок онлайн если нет генерирует исключение PlayerNotFoundException

##### Пример:
```java
public class Example {
public static void main(String[] args){
        try {
            SpApi spApi = new SpApi();
            OnlinePlayers players = spApi.getServerOnlinePlayers();
            Player[] playersArray = players.getPlayers();
            List<Player> playersList = players.getPlayersAsList();
            int count = players.getCount();
            int max = players.getMax();
            boolean status1 = players.checkStatusByName("nickname");
            boolean status2 = players.checkStatusByUUID(UUID.fromString("3717bdea-73f6-490b-b525-da415c0879e7"));
            Player player1 = players.findByName("nickname");
            Player player1 = players.findByUUID(UUID.fromString("3717bdea-73f6-490b-b525-da415c0879e7"));
        } catch (PlayerNotFoundException e) {
            //Пользователь не найден
        } catch (SpApiException e) {
            //Какая-либо ошибка библиотеки
        }
    }
}
```
#### Класс Player <a name="player"></a>

Класс предназначен для работы с данными игрока

Список основных методов класса:
* getNickname() - возвращает `String` никнейм игрока
* getUuid() - возвращает `UUID` uuid игрока

##### Пример:
```java
public class Example {
public static void main(String[] args){
        try {
            SpApi spApi = new SpApi();
            OnlinePlayers players = spApi.getServerOnlinePlayers();
            Player player = players.findByName("nickname");
            player.getNickname(); //nickname
            UUID uuid = player.getUuid();
            uuid.toString(); //3717bdea-73f6-490b-b525-da415c0879e7
        } catch (PlayerNotFoundException e) {
            //Пользователь не найден
        } catch (SpApiException e) {
            //Какая-либо ошибка библиотеки
        }
    }
}
```

#### Класс LastChatMessages <a name="LastChatMessages"></a>
Класс предназначен для работы со списком последних 50 сообщений глобального чата

Список основных методов класса:
* getMessages() - возвращает массив `Message[]` объектов класса `Message`
* getMessagesAsList() - возвращает список `List<Message>` объектов класса `Message`
* findMessagesBySenderName(`String nickname`) - возвращает список `List<Message>` объектов класса `Message` отправленных конкретным игроком, если сообщений нет вернёт пустой список
* findMessagesBySenderUUID(`UUID playerUUID`) - возвращает список `List<Message>` объектов класса `Message` отправленных конкретным игроком, если сообщений нет вернёт пустой список

##### Пример:
```java
public class Example {
public static void main(String[] args){
        try {
            SpApi spApi = new SpApi();
            LastChatMessages lastChatMessages = spApi.getServerLastChatMessages();
            Message[] messageArray = lastChatMessages.getMessages();
            List<Message> messageList = lastChatMessages.getMessagesAsList();
            List<Message> senderMessages1 = lastChatMessages.findMessagesBySenderName("nickname");
            List<Message> senderMessages2 = lastChatMessages.findMessagesBySenderUUID(UUID.fromString("3717bdea-73f6-490b-b525-da415c0879e7"));
        } catch (SpApiException e) {
            //Какая-либо ошибка библиотеки
        }
    }
}
```

#### Класс Message <a name="Message"></a>
Класс предназначен для работы с данными сообщения чата

Список основных методов класса:
* getSender() - возвращает объект класса `Player` игрока, отправившего сообщение
* getMessage() - возвращает `String` текст сообщения
* getTime() - возвращает объект класса `LocalDateTime` время отправления сообщения
* getTimeAsLong() - возвращает `long` [UnixTime](https://ru.wikipedia.org/wiki/Unix-%D0%B2%D1%80%D0%B5%D0%BC%D1%8F) время отправления сообщения

##### Пример:
```java
public class Example {
public static void main(String[] args){
        try {
            SpApi spApi = new SpApi();
            LastChatMessages lastChatMessages = spApi.getServerLastChatMessages();
            Message[] messageArray = lastChatMessages.getMessages();
            Message message = messageArray[0];
            Player sender = message.getSender();
            String text = message.getMessage();
            long unixTime = message.getTimeAsLong();
            LocalDateTime localDateTime = message.getTime();
        } catch (SpApiException e) {
            //Какая-либо ошибка библиотеки
        }
    }
}
```

#### Исключения <a name="Exception"></a>
Список исключений:
* SpApiException - любое исключение при работе с библиотекой
* PlayerNotFoundException - наследует `SpApiException` исключение если игрок не найден
* SpApiServerException - наследует `SpApiException` исключение вызванное в ходе получения данных с сервера API
