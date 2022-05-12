-- 13. The directors of the movies in the "Harry Potter Collection" (4 rows)

SELECT DISTINCT person_name
FROM movie
JOIN collection ON collection.collection_id = movie.collection_id
JOIN person ON person.person_id = movie.director_id
WHERE collection_name = 'Harry Potter Collection';