## Утилита фильтрации содержимого файлов.

#### При запуске утилиты в командной строке подается несколько файлов, содержащих в перемешку целые числа, строки и вещественные числа. В качестве разделителя принимается перевод строки. Строки из файлов читаются по очереди в соответствии с их перечислением в командной строке.

#### Задача утилиты записать разные типы данных в разные файлы. Целые числа в один выходной файл, вещественные в другой, строки в третий. По умолчанию файлы с результатами располагаются в папке `export/` с именами `integers.txt, floats.txt, strings.txt`.
#### Дополнительно с помощью опции `-o` можно задавать путь для результатов. Опция `-p` задает префикс имен выходных файлов. Например `-o some/path -p result_` задают вывод в файлы `some/path/result_integers.txt, some/path/result_strings.txt` и тд. Утилита поддерживает указание относительного и абсолютного пути до входящего файла и для опции директории экспорта результатов `data/test/in3.txt` и `-o C:\ProectDir\export\out`

#### По умолчанию файлы результатов перезаписываются. С помощью опции -a можно задать режим добавления в существующие файлы.

#### Файлы с результатами создаются по мере необходимости. Если какого-то типа данных во входящих файлах нет, то исходящий файл не создается.

#### В процессе фильтрации данных собирается статистика по каждому типу данных Статистика поддерживается двух видов: краткая и полная. Выбор статистики производится опциями `-s и -f` соответственно. Указание двух опций одновременно вызывает ошибку и статистика не показывается. Если опция не указана, статистика не выводится

##### Краткая статистика содержит только количество элементов записанных в исходящие файлы. 

##### Полная статистика для чисел дополнительно содержит минимальное и максимальное значения, сумма и среднее.

##### Полная статистика для строк, помимо их количества, содержит также размер самой короткой строки и самой длинной.

#### Статистику по каждому типу отфильтрованных данных утилита выводит в консоль.

Для реализации использовался язык программирования `Java JDK 17`

Использовалась системы сборки проекта `Maven-4.0.0`.

В проекте используются следующие библиотеки:
- <dependency>
    <groupId>org.jcommander</groupId>
    <artifactId>jcommander</artifactId>
    <version>2.0</version>
  </dependency>

- <dependency>
    <groupId>org.projectlombok</groupId>
    <artifactId>lombok</artifactId>
    <version>1.18.36</version>
    <scope>provided</scope>
  </dependency>

Для сборки исполняемого файла используется следующий плагин:
- <plugin>
      <groupId>org.apache.maven.plugins</groupId>
      <artifactId>maven-assembly-plugin</artifactId>
      <version>3.7.1</version>
  </plugin> 

### run app

#### Название пакета следующее
- <groupId>ru.cft.shift</groupId>
<artifactId>FIlterDataUtilits</artifactId>
<version>1.0-SNAPSHOT</version>

#### После клонирования репозитория на локальный хост нужно скомпилировать пакет командой из корневой директории проекта

`mvn clean package`

#### В папке `target/` нужно проверить скомпилированный jar и запустить файл с необходимыми аргументами, например:
`java   -jar  target/FIlterDataUtilits-1.0-SNAPSHOT-jar-with-dependencies.jar -f -a -o export/out -p good_job_ in1.txt data/in2.txt data/test/in3.txt`
