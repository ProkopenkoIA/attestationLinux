# Итоговая аттестация
1. Используя команду cat в терминале операционной системы Linux, создать два файла Домашние животные (заполнив файл собаками, кошками, хомяками) и Вьючные животными заполнив файл Лошадьми, верблюдами и ослы), а затем объединить их.
![image](https://github.com/user-attachments/assets/5e070d12-a401-41b3-9319-dba1975f316a)

2. Создать директорию, переместить файл туда.
   
![image](https://github.com/user-attachments/assets/f9ae38f8-99bb-4000-8c40-188b8f415921)

3. Подключить дополнительный репозиторий MySQL. Установить любой пакет из этого репозитория.
   ```
     $ wget -c https://dev.mysql.com/get/mysql-apt-config_0.8.24-1_all.deb
     $ dpkg -i mysql-apt-config_0.8.24-1_all.deb
     $ apt install mysql-server mysql-client
   ```
   ![image](https://github.com/user-attachments/assets/7741d61e-7418-48a0-a2a7-b5f2c476efd3)

4.Установить и удалить deb-пакет с помощью dpkg

```
   $ sudo dpkg -i mysql-apt-config_0.8.24-1_all.deb
   $ sudo dpkg -r mysql-apt-config
   $ sudo dpkg --purge mysql-apt-config
```
5. Нарисовать диаграмму, в которой есть класс родительский класс, домашние животные и вьючные животные, в составы которых в случае домашних животных войдут классы: собаки, кошки, хомяки, а в класс вьючные животные войдут: Лошади, верблюды и ослы).
   
![image](https://github.com/user-attachments/assets/d2de2162-7527-458e-836e-29eb49058448)

![image](https://github.com/user-attachments/assets/d9bf898d-929c-4c2f-af83-6699ed7a6422)

6. В подключенном MySQL репозитории создать базу данных “Друзья человека”
   ```CREATE DATABASE IF NOT EXISTS HumanFriends;
   USE HumanFriends;```




