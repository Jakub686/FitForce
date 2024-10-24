create sequence stat.weights_seq increment by 1;

select setval('stat.weights_seq', 7);

create sequence stat.trainings_seq increment by 1;

select setval('stat.trainings_seq', 2);

create TABLE stat.trainings (
    id BIGINT PRIMARY KEY,
    member_id bigint,
    appointment DATE
);

    insert into stat.trainings (id, member_id, appointment)
values
  (1, 1, '2024-10-01'),
  (2, 1, '2024-10-30');

create TABLE stat.weights (
    id BIGINT PRIMARY KEY,
    member_id bigint,
    created DATE,
    weight_value double precision
);

  insert into stat.weights (id, member_id, created, weight_value)
values
  (1, 1, '2024-01-10', 70.5),
  (2, 1, '2024-02-10', 75.0),
  (3, 1, '2025-03-10', 78.8),
  (4, 1, '2025-04-10', 82.3),
  (5, 1, '2025-05-10', 77.5),
  (6, 1, '2025-06-10', 74.2);


--SELECT setval('stat.weights_seq', (SELECT MAX(id) FROM stat.weights) + 1);
