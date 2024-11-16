Insert into cv (id, uuid)
values (1, '6cf67bf1-735f-442c-99f2-af1231e44baf');

insert into skill (id)
values (1),
       (2),
       (3);

insert into cv_skills(cvs_id, skills_id)
values (1, 1),
       (1, 2),
       (1, 3);

insert into language (id)
values (1),
       (2),
       (3);

insert into cv_languages(cvs_id, languages_id)
values (1, 1),
       (1, 2),
       (1, 3);