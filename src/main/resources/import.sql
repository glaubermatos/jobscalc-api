insert into profile (id, avatar_url, email, name, remuneration, vacation_week_per_year, value_hour, working_days_per_week, working_hours_per_day) values (1, 'https://avatars.githubusercontent.com/u/10993285?v=4', 'glaub.oliveira@hotmail.com', 'Glauber de Oliveira Matos', 400000, 4, 6250, 4, 14400)
insert into profile (id, avatar_url, email, name, remuneration, vacation_week_per_year, value_hour, working_days_per_week, working_hours_per_day) values (2, 'https://avatars.githubusercontent.com/u/10993285?v=4', 'glaub.oliveira2@hotmail.com', 'Glauber de Oliveira Matos2', 400000, 4, 6250, 4, 14400)

insert into job (id, closed_at, created_at, hours_estimate, name, profile_id, project_value, status, working_hours_per_day) values (1, null, CURRENT_TIMESTAMP(), 72000, 'Projeto 1', 1, 125000, 'NOTSTARTED', 7200)
insert into job (id, closed_at, created_at, hours_estimate, name, profile_id, project_value, status, working_hours_per_day) values (2, null, CURRENT_TIMESTAMP(), 72000, 'Projeto 2', 1, 125000, 'NOTSTARTED', 7200)
        
     