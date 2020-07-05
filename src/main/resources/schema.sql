DROP TABLE IF EXISTS USER;
DROP TABLE IF EXISTS OFFICE;
DROP TABLE IF EXISTS ORGANIZATION;
DROP TABLE IF EXISTS DOCUMENT;
DROP TABLE IF EXISTS ADDRESS;
DROP TABLE IF EXISTS COUNTRY;
DROP TABLE IF EXISTS DOCUMENT_TYPE;

CREATE TABLE IF NOT EXISTS DOCUMENT_TYPE
(
    id INTEGER COMMENT 'Уникальный идентификатор' PRIMARY KEY,
    code    INTEGER NOT NULL UNIQUE COMMENT 'Код документа',
    name    VARCHAR(200) NOT NULL COMMENT 'Название документа'
);
COMMENT ON TABLE DOCUMENT_TYPE IS 'Спарвочник типов документов';

CREATE TABLE IF NOT EXISTS COUNTRY
(
    id INTEGER COMMENT 'Уникальный идентификатор' PRIMARY KEY,
    code    INTEGER NOT NULL UNIQUE COMMENT 'Код страны по ОКСМ',
    name    VARCHAR(50) NOT NULL COMMENT 'Название страны'
);
COMMENT ON TABLE COUNTRY IS 'Справочник стран по ОКСМ';

CREATE TABLE IF NOT EXISTS ADDRESS
(
    id           INTEGER COMMENT 'Уникальный идентификатор' PRIMARY KEY AUTO_INCREMENT,
    version      INTEGER     NOT NULL COMMENT 'Служебное поле hibernate',
    country_id INTEGER     NOT NULL COMMENT 'Внешний ключ на ид страны',
    region       VARCHAR     NOT NULL COMMENT 'Название региона',
    city         VARCHAR(50) COMMENT 'Название города',
    town         VARCHAR(50) COMMENT 'Название населенного пункта',
    zip_code        INTEGER COMMENT 'Почтовый индекс',
    street       VARCHAR(100) COMMENT 'Название улицы',
    home         VARCHAR(30) COMMENT 'Номер дома, корпус, строение'
);
COMMENT ON TABLE ADDRESS IS 'Адрес';
ALTER TABLE ADDRESS
    ADD FOREIGN KEY (country_id) REFERENCES COUNTRY (id);
CREATE INDEX IX_address_country ON ADDRESS (country_id);

CREATE TABLE IF NOT EXISTS DOCUMENT
(
    id      BIGINT NOT NULL COMMENT 'Уникальный идентификатор (номер документа)' PRIMARY KEY,
    version INTEGER NOT NULL COMMENT 'Служебное поле hibernate',
    document_id    INTEGER NOT NULL COMMENT 'Внешний ключ на справочник типов документов',
    date    DATE COMMENT 'Дата выдачи документа'
);
COMMENT ON TABLE DOCUMENT IS 'Документы';
ALTER TABLE DOCUMENT
    ADD FOREIGN KEY (document_id) REFERENCES DOCUMENT_TYPE (id);

CREATE TABLE IF NOT EXISTS ORGANIZATION
(
    id         INTEGER COMMENT 'Уникальный идентификатор' PRIMARY KEY AUTO_INCREMENT,
    version    INTEGER      NOT NULL COMMENT 'Служебное поле hibernate',
    name       VARCHAR(50)  NOT NULL COMMENT 'Название компании',
    inn        BIGINT       NOT NULL UNIQUE COMMENT 'Индентификационный номер налогоплательщика',
    kpp        INTEGER       NOT NULL COMMENT 'Код причины постановки на учет',
    address_id INTEGER      NOT NULL COMMENT 'Внешний ключ на юридический адрес организации',
    phone      BIGINT COMMENT 'Номер телефона',
    is_active  BOOLEAN      NOT NULL,
    full_name  VARCHAR(255) NOT NULL COMMENT 'Юридическое название компании'
);
COMMENT ON TABLE ORGANIZATION IS 'Организация';
ALTER TABLE ORGANIZATION
    ADD FOREIGN KEY (address_id) REFERENCES ADDRESS (id);
CREATE INDEX IX_org_inn ON ORGANIZATION (inn);
CREATE INDEX IX_org_name ON ORGANIZATION (name);
CREATE INDEX IX_org_address ON ORGANIZATION (address_id);

CREATE TABLE IF NOT EXISTS OFFICE
(
    id         INTEGER COMMENT 'Уникальный идентификатор офиса' PRIMARY KEY AUTO_INCREMENT,
    version    INTEGER NOT NULL COMMENT 'Служебное поле hibernate',
    org_id     INTEGER NOT NULL COMMENT 'Внешний ключ на идентификатор организации',
    name       VARCHAR(50) COMMENT 'Название офиса',
    address_id VARCHAR(255) COMMENT 'Внешний ключ на адрес офиса',
    phone      BIGINT COMMENT 'Номер телефона офиса',
    is_active  BOOLEAN
);
COMMENT ON TABLE OFFICE IS 'Офис';
ALTER TABLE OFFICE
    ADD FOREIGN KEY (org_id) REFERENCES Organization (id);
ALTER TABLE OFFICE
    ADD FOREIGN KEY (address_id) REFERENCES ADDRESS (id);
CREATE INDEX IX_office_name ON OFFICE (name);
CREATE INDEX IX_office_phone ON OFFICE (phone);
CREATE INDEX IX_office_address ON OFFICE (address_id);

CREATE TABLE IF NOT EXISTS USER
(
    id            INTEGER COMMENT 'Уникальный идентификатор пользователя',
    version       INTEGER      NOT NULL COMMENT 'Служебное поле hibernate',
    office_id     INTEGER      NOT NULL COMMENT 'Внешний ключ на идентификатор организации',
    first_name    VARCHAR(50)  NOT NULL COMMENT 'Имя',
    last_name     VARCHAR(50) COMMENT 'Фамилия',
    middle_name   VARCHAR(50) COMMENT 'Отчество',
    position      VARCHAR(100) NOT NULL COMMENT 'Должность',
    phone         BIGINT COMMENT 'Номер телефона',
    doc_number    BIGINT COMMENT 'Номер документа (Внешний ключ на документ)',
    country_id  INTEGER      NOT NULL COMMENT 'Внешний ключ на страну гражданства',
    is_identified BOOLEAN COMMENT 'Прошел ли пользователь идентификацию'
);
COMMENT ON TABLE USER IS 'Пользователь';
ALTER TABLE USER
    ADD FOREIGN KEY (office_id) REFERENCES OFFICE (id);
ALTER TABLE USER
    ADD FOREIGN KEY (doc_number) REFERENCES DOCUMENT (id);
ALTER TABLE USER
    ADD FOREIGN KEY (country_id) REFERENCES COUNTRY (id);
CREATE INDEX IX_user_first_name ON USER (first_name);
CREATE INDEX IX_user_middle_name ON USER (middle_name);
CREATE INDEX IX_user_last_name ON USER (last_name);
CREATE INDEX IX_user_position ON USER (position);
CREATE INDEX IX_user_office ON USER (office_id);
CREATE INDEX IX_user_doc ON USER (doc_number);
CREATE INDEX IX_user_country ON USER (country_id);





