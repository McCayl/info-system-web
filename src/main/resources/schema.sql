DROP TABLE IF EXISTS track, album, track_album;

CREATE TABLE track (
    id SERIAL PRIMARY KEY,
    name VARCHAR(45) NOT NULL,
    author VARCHAR(45) NOT NULL,
    genre VARCHAR(45) NOT NULL,
    length INT NOT NULL
);

CREATE TABLE album (
    id SERIAL PRIMARY KEY,
    name VARCHAR(45) NOT NULL,
    year INT NOT NULL
);

CREATE TABLE track_album (
    track_id INT NOT NULL,
    album_id INT NOT NULL,
    PRIMARY KEY(track_id, album_id),
    CONSTRAINT fk_track FOREIGN KEY(track_id) REFERENCES track(id),
    CONSTRAINT fk_album FOREIGN KEY(album_id) REFERENCES album(id)
);