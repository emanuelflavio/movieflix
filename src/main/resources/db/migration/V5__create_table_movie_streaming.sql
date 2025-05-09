CREATE TABLE movie_streaming(
    movie_id BIGINT UNSIGNED,
    streaming_id BIGINT UNSIGNED,
    CONSTRAINT fk_movie_streamig_movie FOREIGN KEY(movie_id) REFERENCES movie(id),
    CONSTRAINT fk_movie_streamig_streaming FOREIGN KEY(streaming_id) REFERENCES streaming(id)

);