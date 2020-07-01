DROP TABLE IF EXISTS USER;
DROP TABLE IF EXISTS OFFICE;
DROP TABLE IF EXISTS COUNTRY;
DROP TABLE IF EXISTS DOCUMENT;
DROP TABLE IF EXISTS ORGANIZATION;

CREATE TABLE IF NOT EXISTS Organization
(
    id        INTEGER COMMENT 'Уникальный идентификатор' PRIMARY KEY AUTO_INCREMENT,
    version   INTEGER      NOT NULL COMMENT 'Служебное поле hibernate',
    name      VARCHAR(50)  NOT NULL COMMENT 'Название компании',
    inn       BIGINT      NOT NULL UNIQUE COMMENT 'Индентификационный номер налогоплательщика',
    kpp       BIGINT      NOT NULL UNIQUE COMMENT 'Код причины постановки на учет',
    address   VARCHAR      NOT NULL COMMENT 'Юридический адрес',
    phone     BIGINT COMMENT 'Номер телефона',
    is_active BOOLEAN      NOT NULL COMMENT '',
    full_name VARCHAR(255) NOT NULL COMMENT 'Юридическое название компании'
);
COMMENT ON TABLE Organization IS 'Организация';

CREATE TABLE IF NOT EXISTS Document
(
    code    INTEGER COMMENT 'Уникальный идентификатор (код документа)' PRIMARY KEY,
    version INTEGER     NOT NULL COMMENT 'Служебное поле hibernate',
    name    VARCHAR(200) NOT NULL COMMENT 'Название документа'
);
COMMENT ON TABLE Document IS 'Спарвочник документов';

CREATE TABLE IF NOT EXISTS Country
(
    code    INTEGER COMMENT 'Уникальный идентификатор (код страны по ОКСМ)' PRIMARY KEY,
    version INTEGER     NOT NULL COMMENT 'Служебное поле hibernate',
    name    VARCHAR(50) NOT NULL COMMENT 'Название страны'
);
COMMENT ON TABLE Country IS 'Справочник стран';

CREATE TABLE IF NOT EXISTS Office
(
    id        INTEGER COMMENT 'Уникальный идентификатор офиса' PRIMARY KEY AUTO_INCREMENT,
    version   INTEGER NOT NULL COMMENT 'Служебное поле hibernate',
    org_id    INTEGER NOT NULL COMMENT 'Внешний ключ на идентификатор организации',
    name      VARCHAR(50) COMMENT 'Название офиса',
    address   VARCHAR(255) COMMENT 'Адрес офиса',
    phone     BIGINT COMMENT 'Номер телефона офиса',
    is_active BOOLEAN COMMENT ''
);
COMMENT ON TABLE Office IS 'Офис';

CREATE TABLE IF NOT EXISTS User
(
    id            INTEGER COMMENT 'Уникальный идентификатор пользователя',
    version       INTEGER      NOT NULL COMMENT 'Служебное поле hibernate',
    office_id     INTEGER      NOT NULL COMMENT 'Внешний ключ на идентификатор организации',
    first_name    VARCHAR(50)  NOT NULL COMMENT 'Имя',
    last_name     VARCHAR(50) COMMENT 'Фамилия',
    middle_name   VARCHAR(50) COMMENT 'Отчество',
    position      VARCHAR(100) NOT NULL COMMENT 'Должность',
    phone         BIGINT COMMENT 'Номер телефона',
    doc_code      INTEGER      NOT NULL COMMENT 'Внешний ключ на код документа',
    doc_number    BIGINT COMMENT 'Номер документа',
    doc_date      DATE COMMENT 'Дата выдачи документа',
    country_code  INTEGER      NOT NULL COMMENT 'Внешний ключ на код страны гражданства',
    is_identified BOOLEAN COMMENT 'Прошел ли пользователь идентификацию'
);
COMMENT ON TABLE User IS 'Пользователь';

ALTER TABLE Office
    ADD FOREIGN KEY (org_id) REFERENCES Organization (id);

ALTER TABLE User
    ADD FOREIGN KEY (office_id) REFERENCES Office (id);
ALTER TABLE User
    ADD FOREIGN KEY (doc_code) REFERENCES Document (code);
ALTER TABLE User
    ADD FOREIGN KEY (country_code) REFERENCES Country (code);

