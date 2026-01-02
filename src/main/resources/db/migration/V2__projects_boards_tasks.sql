create table projects (
    id uuid primary key,
    org_id uuid not null references organizations(id) on delete cascade,
    name varchar(255) not null,
    created_at timestamptz not null
);
create index idx_projects_org on projects(org_id);

create table boards(
    id uuid primary key,
    org_id uuid not null references organizations(id) on delete cascade,
    project_id uuid not null references projects(id) on delete cascade,
    name varchar(255) not null,
    created_at timestamptz not null
);
create index idx_boards_org on boards(org_id);
create index idx_boards_projects on boards(project_id);

create table tasks (
    id uuid primary key,
    org_id uuid not null references organizations(id) on delete cascade,
    board_id uuid not null references boards(id) on delete cascade,
    title varchar(255) not null,
    description text,
    status varchar(50) not null,
    priority varchar(50) not null,
    due_date date,
    assignee_user_id uuid references users(id),
    created_by_user_id uuid not null references users(id),
    created_at timestamptz not null,
    updated_at timestamptz not null
);

create index idx_tasks_org on tasks(org_id);
create index idx_tasks_board on tasks(board_id);
create index idx_tasks_org_status on tasks(org_id, status);
create index idx_tasks_org_assignee on tasks(org_id, assignee_user_id);