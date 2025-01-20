# Итоговая аттестация
1. Используя команду cat в терминале операционной системы Linux, создать два файла Домашние животные (заполнив файл собаками, кошками, хомяками) и Вьючные животными заполнив файл Лошадьми, верблюдами и ослы), а затем объединить их.
![image](https://github.com/user-attachments/assets/5e070d12-a401-41b3-9319-dba1975f316a)

2. Создать директорию, переместить файл туда.
   
![image](https://github.com/user-attachments/assets/f9ae38f8-99bb-4000-8c40-188b8f415921)

3. Подключить дополнительный репозиторий MySQL. Установить любой пакет из этого репозитория.
   ```shell
     $ wget -c https://dev.mysql.com/get/mysql-apt-config_0.8.24-1_all.deb
     $ dpkg -i mysql-apt-config_0.8.24-1_all.deb
     $ apt install mysql-server mysql-client
   ```
   ![image](https://github.com/user-attachments/assets/7741d61e-7418-48a0-a2a7-b5f2c476efd3)

4. Установить и удалить deb-пакет с помощью dpkg

```shell
   $ sudo dpkg -i mysql-apt-config_0.8.24-1_all.deb
   $ sudo dpkg -r mysql-apt-config
   $ sudo dpkg --purge mysql-apt-config
```
5. Нарисовать диаграмму, в которой есть класс родительский класс, домашние животные и вьючные животные, в составы которых в случае домашних животных войдут классы: собаки, кошки, хомяки, а в класс вьючные животные войдут: Лошади, верблюды и ослы).
   
![image](https://github.com/user-attachments/assets/d2de2162-7527-458e-836e-29eb49058448)

![image](https://github.com/user-attachments/assets/d9bf898d-929c-4c2f-af83-6699ed7a6422)

6. В подключенном MySQL репозитории создать базу данных “Друзья человека”
   ```sql
   CREATE DATABASE IF NOT EXISTS HumanFriends;
   USE HumanFriends;
   ```
7. Создать таблицы с иерархией из диаграммы в БД
   ```sql
   CREATE TABLE MainClass
   (
       id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
       name varchar(255)
   );
   
   CREATE TABLE AnimalType
   (
       id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
       name varchar(255),
       id_class INT,
       FOREIGN KEY (id_class) REFERENCES MainClass (id)
       ON DELETE CASCADE ON UPDATE CASCADE
   );
   
   CREATE TABLE Animals
   (
       id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
       name varchar(255),
       birth_date DATE,
       id_animal_type INT,
       FOREIGN KEY (id_animal_type) REFERENCES AnimalType (id)
       ON DELETE CASCADE ON UPDATE CASCADE
   );

    CREATE TABLE Commands
   (
       id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
       name varchar(255),
       description varchar(255)
   );
   
   CREATE TABLE AnimalCommands
   (
       id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
       id_animal INT NOT NULL,
       id_command INT NOT NULL,

       FOREIGN KEY (id_animal) REFERENCES Animals (id)
        ON DELETE CASCADE ON UPDATE CASCADE,
       FOREIGN KEY (id_command) REFERENCES Commands (id)
        ON DELETE CASCADE  ON UPDATE CASCADE
   );
   ```
8. Заполнить низкоуровневые таблицы именами(животных), командами которые они выполняют и датами рождения
      ```sql
       USE HumanFriends;

      INSERT INTO commands(name)
      VALUES
       ('Принести тапки'),
       ('Сидеть'),
       ('Бегать в колесе'),
       ('Галоп!'),
       ('Поклон!');
      
      INSERT INTO MainClass (name)
      VALUES
       ('Вьючные животные'),
       ('Домашние животные');
      
      INSERT INTO AnimalType (name, id_class)
      VALUES
       ('Лошадь', 1),
       ('Верблюд', 1),
       ('Осел', 1),
       ('Кошка', 2),
       ('Собака', 2),
       ('Хомяк', 2);
      
      INSERT INTO Animals (name, birth_date, id_animal_type)
      VALUES
       ('Плотва', '2020-03-04', 1),
       ('Гнедой', '2022-12-01', 1),
       ('Гора', '2019-08-20', 2),
       ('Осел', '2020-08-24', 3),
       ('Том', '2023-07-01', 4)
       ('Шарик', '2023-01-24', 5),
       ('Хомяк99', '2024-12-20', 6);
      
      INSERT INTO AnimalCommands (id_animal, id_command)
      VALUES
       (1, 4), (2, 5), (2, 4),
       (7, 3), (5, 1), (5, 4),
       (6, 2),(6, 1);
      ```
9. Удалив из таблицы верблюдов, т.к. верблюдов решили перевезти в другой питомник на зимовку. Объединить таблицы лошади, и ослы в одну таблицу.
   ```sql
      USE HumanFriends;
      DELETE FROM Animals WHERE id_animal_type = 2;
   
      CREATE TABLE HorseAndDonkey AS
      SELECT * from Animals WHERE id_animal_type = 1
      UNION
      SELECT * from Animals WHERE id_animal_type = 3;
   ```
10. Создать новую таблицу “молодые животные” в которую попадут все животные старше 1 года, но младше 3 лет и в отдельном столбце с точностью до месяца подсчитать возраст животных в новой таблице
   ```sql
      CREATE TABLE YoungAnimals AS
         SELECT id, name, birth_date, 
         CONCAT(TIMESTAMPDIFF(month, birth_date, curdate()) div 12,'y', TIMESTAMPDIFF(month, birth_date, curdate()) - ((TIMESTAMPDIFF(month, birth_date, curdate()) div 12)*12), 'm') as age, id_animal_type 
         from Animals 
         WHERE date_add(birth_date, INTERVAL 1 YEAR) < curdate() 
               AND date_add(birth_date, INTERVAL 3 YEAR) > curdate();
   ```
11. Объединить все таблицы в одну, при этом сохраняя поля, указывающие на прошлую принадлежность к старым таблицам.
   ```sql
   SELECT anml.name,
          anml.birth_date,
          CASE WHEN yng.id IS NOT NULL THEN 'Это животное молодое ему' ELSE 'Это не молодое животное' END young,
          CASE WHEN had.id IS NOT NULL THEN 'Это животное является конем или ослом' ELSE 'Это животное не является конем или ослом' END is_had          
   FROM Animals anml
   LEFT JOIN YoungAnimals as yng ON yng.id = anml.id
   LEFT JOIN HorseAndDonkey as had ON had.id = anml.id
   ```
    






