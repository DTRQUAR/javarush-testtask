#Тестовое задания для допуска к онлайн-стажировке от JavaRush

Cтандартное crud приложение, которое отображаем список всех юзеров в базе (с пейджингом). 
С возможностью их удаления, редактирования, добавления новых. И поиска по уже существующим.

Запрос для создания базы данных, таблицы и заполнения ее
тестовыми данными осуществляется с помощью sql запроса из файла:
JavaRushTestQuery_Ildar_Makhmutov.sql

После деплоя в Томкэт приложение будет доступно по урл:
http://localhost:8080/javarush-testtask/jvtestbd/main/users

===========================
Используемые технологии:
- Maven (для сборки проекта)	
- Spring
- Hibernate (для маппинга сущностей приложения на БД, и работы с БД)
- Tomcat (для тестирования своего приложения)
- Mysql (база данных).

