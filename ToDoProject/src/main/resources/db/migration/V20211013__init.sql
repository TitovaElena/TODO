create table task.user
(
    id         serial      primary key,
    first_name varchar     not null,
    last_name  varchar     not null,
    email      varchar     not null,
    created_at timestamptz not null default now()
);

create table task.task
(
    id            serial      primary key,
    category      varchar     not null,
    priority      varchar     not null,
    deadline      timestamptz not null ,
    text          varchar     not null,
    creator_id    int         not null
        references task.user (id)
);