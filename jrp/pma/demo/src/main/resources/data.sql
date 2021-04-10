-- -- INSERT PROJECTS
insert into Project (id, name, stage, description)
values (1000, 'Large Production Deploy', 'NOTSTARTED',
        'This requires all hands on deck for the final deployment of the software into production');
insert into Project (id, name, stage, description)
values (1001, 'New Employee Budget', 'COMPLETED',
        'Decide on a new employee bonus budget for the year and figureout who will be promoted');
insert into Project (id, name, stage, description)
values (1002, 'Office Reconstruction', 'INPROGRESS',
        'The office building in Monroe has been damaged due to hurricane in the region. This needs to be reconstructed');
insert into Project (id, name, stage, description)
values (1003, 'Improve Intranet Security', 'INPROGRESS',
        'With the recent data hack, the office security needs to be improved and proper security team needs to be hired for implementation');

# --
# -- -- -- INSERT EMPLOYEES
insert into Employee (id, first_name, last_name, email, project_id)
values (1, 'John', 'Warton', 'jwarton@sql.com', 1001);
insert into Employee (id, first_name, last_name, email, project_id)
values (2, 'Mike', 'Lanister', 'mlani@sql.com', 1002);
insert into Employee (id, first_name, last_name, email, project_id)
values (3, 'Steve', 'Reeves', 'sreeves@sql.com', 1002);
insert into Employee (id, first_name, last_name, email, project_id)
values (4, 'Ronald', 'Connor', 'rc@geegee.com', 1000);
insert into Employee (id, first_name, last_name, email, project_id)
values (5, 'Jim', 'Salvator', 'jsalva@geegee.com', 1000);
insert into Employee (id, first_name, last_name, email, project_id)
values (6, 'Peter', 'Henley', 'phenley@geegee.com', 1000);
insert into Employee (id, first_name, last_name, email, project_id)
values (7, 'Richard', 'Carson', 'rcarson@geegee.com', 1003);
insert into Employee (id, first_name, last_name, email, project_id)
values (8, 'Honor', 'Miles', 'hmiles@geegee.com', 1003);
insert into Employee (id, first_name, last_name, email, project_id)
values (9, 'Tony', 'Roggers', 'troggers@geegee.com', 1003);
-- INSERT EMPLOYEES
insert into Employee (id, first_name, last_name, email, project_id)
values (10, 'John', 'Warton', 'warton@gmail.com', NULL);
insert into Employee (id, first_name, last_name, email, project_id)
values (11, 'Mike', 'Lanister', 'lanister@gmail.com', NULL);
insert into Employee (id, first_name, last_name, email, project_id)
values (12, 'Steve', 'Reeves', 'Reeves@gmail.com', NULL);
insert into Employee (id, first_name, last_name, email, project_id)
values (13, 'Ronald', 'Connor', 'connor@gmail.com', NULL);
insert into Employee (id, first_name, last_name, email, project_id)
values (14, 'Jim', 'Salvator', 'Sal@gmail.com', NULL);
insert into Employee (id, first_name, last_name, email, project_id)
values (15, 'Peter', 'Henley', 'henley@gmail.com', NULL);
insert into Employee (id, first_name, last_name, email, project_id)
values (16, 'Richard', 'Carson', 'carson@gmail.com', NULL);
insert into Employee (id, first_name, last_name, email, project_id)
values (17, 'Honor', 'Miles', 'miles@gmail.com', NULL);
insert into Employee (id, first_name, last_name, email, project_id)
values (18, 'Tony', 'Roggers', 'roggers@gmail.com', NULL);
#
# INSERT INTO stakeholder(id, first_name, last_name, role)
# VALUES  (101,'jimmy','piper','critiquer'),
#         (102,'AC','slater','bodyguard'),
#         (103,'Zach','Morris','preppy');
# -- --
# -- --
# INSERT INTO project_stakeholder(project_id, stakeholder_id)
# VALUES  (1000,101),
#         (1000,102),
#         (1000,103);