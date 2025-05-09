CREATE TABLE IF NOT EXISTS movie(
    id serial PRIMARY KEY,
    title varchar(255) NOT NULL,
    description text,
    release_date date,
    rating decimal(2,1),
    created_at timestamp,
    updated_at timestamp
);