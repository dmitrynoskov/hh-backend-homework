create type popularity AS enum ('POPULAR', 'REGULAR');

create table if not exists area (
    area_id bigint primary key,
    area_name varchar(100) not null
);

create table if not exists favourite_employer (
    employer_id bigint primary key,
    employer_name varchar(255) not null,
    date_creation varchar(50) not null,
    description text,
    area_id bigint references area(area_id) not null,
    comment varchar(255),
    popularity popularity not null,
    views_count int not null
);

create table if not exists favourite_vacancy (
    vacancy_id bigint primary key,
    vacancy_name varchar(255) not null,
    date_creation varchar(50) not null,
    area_id bigint references area(area_id) not null,
    salary_from int,
    salary_to int,
    salary_currency varchar(5) not null,
    salary_gross boolean,
    created_at varchar(50) not null,
    employer_id bigint,
    employer_name varchar(255),
    popularity popularity not null,
    views_count int not null,
    comment varchar(255)
);
