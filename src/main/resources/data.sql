INSERT INTO ORGANIZATION (ID, NAME, VERSION, INN, KPP, ADDRESS, PHONE, IS_ACTIVE, FULL_NAME)
VALUES (112, 'Рога и копыта', 0, 9999999999, 356563463646, 'Новоданиловская Набережная, 6 к1', 74951243232, true, 'ООО РиГ'),
       (113, 'Копыта и рога', 0, 9999999998, 356563463122, 'Варшавское шоссе, 125ж к6', 74951231111, true, 'ЗАО ГиР'),
       (114, 'ПСС', 0, 9999999997, 356537645646, 'Сормовский проезд, 7а к2', 74952565223, true, 'ОАО ПромСельСтрой');

INSERT INTO DOCUMENT (CODE, VERSION, NAME)
VALUES (3, 0, 'Свидетельство о рождении'),
       (7, 0, 'Военный билет'),
       (8, 0, 'Временное удостоверение, выданное взамен военного билета'),
       (10, 0, 'Паспорт иностранного гражданина'),
       (11, 0,
        'Свидетельство о рассмотрении ходатайства о признании лица беженцем на территории Российской Федерации по существу'),
       (12, 0, 'Вид на жительство в Российской Федерации'),
       (13, 0, 'Удостоверение беженца'),
       (15, 0, 'Разрешение на временное проживание в Российской Федерации'),
       (18, 0, 'Свидетельство о предоставлении временного убежища на территории Российской Федерации'),
       (21, 0, 'Паспорт гражданина Российской Федерации'),
       (23, 0, 'Свидетельство о рождении, выданное уполномоченным органом иностранного государства'),
       (24, 0, 'Удостоверение личности военнослужащего Российской Федерации'),
       (91, 0, 'Иные документы');

INSERT INTO COUNTRY (CODE, VERSION, NAME)
VALUES (643, 0, 'Российская Федерация'),
       (860, 0, 'Украина'),
       (112, 0, 'Республика Беларусь'),
       (300, 0, 'Греческая Республика'),
       (208, 0, 'Королевство Дания');

INSERT INTO OFFICE (ID, VERSION, ORG_ID, NAME, ADDRESS, PHONE, IS_ACTIVE)
VALUES (212, 0, 112, 'Данилов плаза', 'Новоданиловская Набережная, 6 к1', 74951243232, true),
       (213, 0, 113, 'Meridio', 'Варшавское шоссе, 125ж к6', 74951231111, true),
       (214, 0, 114, 'Севастополь', 'Сормовский проезд, 7а к2', 74952565223, true);

INSERT INTO USER (ID, VERSION, OFFICE_ID, FIRST_NAME, MIDDLE_NAME, LAST_NAME, POSITION, PHONE, DOC_CODE, DOC_NUMBER, DOC_DATE,
                  COUNTRY_CODE, IS_IDENTIFIED)
VALUES (310, 0, 212, 'Иван', 'Иванович','Иванов', 'Менеджер по продажам', 79168888288, 18, 3881661254, '2015-02-12', 643, true),
       (311, 0, 212, 'Сидр', 'Николаевич', 'Петров', 'Консультант', 79168458212, 18, 3881673223, '2010-06-13', 643, true),
       (312, 0, 212, 'Вениамин', 'Павлович', 'Сидоров', 'Директор', 79168588233, 18, 3481551254, '2013-09-11', 643, true),
       (321, 0, 213, 'Семен', 'Михайлович', 'Контров', 'Продавец', 79168828274, 18, 3182661293, '2011-12-02', 643, true),
       (322, 0, 213, 'Денис', 'Петрович', 'Межевой', 'Кладовщик', 79168828855, 18, 3781661277, '2016-01-31', 643, true),
       (323, 0, 213, 'Светлана', 'Константиновна', 'Михалкова', 'Директор', 79169999299, 18, 3291661244, '2015-11-20', 643, true),
       (331, 0, 214, 'Иван', 'Иванович', 'Иванов', 'Директор', 79168822222, 18, 3881661277, '2015-02-21', 643, true),
       (332, 0, 214, 'Софья', 'Ивановна', 'Иванова', 'Секретарь', 79168868245, 18, 3881663238, '2010-09-17', 643, true),
       (333, 0, 214, 'Василий', 'Иванович', 'Иванов', 'Экономист', 79164444244, 18, 3391161247, '2017-07-19', 643, true);