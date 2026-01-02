create table organizations (
    id uuid primary key,
    name varchar(255) not null,
    created_at timestamptz not null
);

create table users (
    id uuid primary key,
    email varchar(255) not null unique,
    password_hash varchar(255) not null,
    created_at timestamptz not null
);

create table memberships (
    id uuid primary key,
    org_id uuid not null references organizations(id) on delete cascade,
    user_id uuid not null references users(id) on delete cascade,
    role varchar(50) not null,
    created_at timestamptz not null,
    unique (org_id, user_id)
);

create index idx_memberships_org on memberships(org_id);
create index idx_memberships_user on memberships(user_id);
