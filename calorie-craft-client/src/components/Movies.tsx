import React, {useEffect, useState} from 'react';
import axios from 'axios';

// Define the type for movie data
interface Movie {
  id: string;
  name: string;
  genre: string;
  rating: string;
  releaseDate: string;
  duration: string;
  director: string;
  cast: string;
  description: string;
  trailer: string;
  poster: string;
  status: string;
  createdAt: string;
  updatedAt: string;
  deletedAt: string | null;
}

const Movies: React.FC = () => {
  const [movies, setMovies] = useState<Movie[]>([]);
  const [loading, setLoading] = useState<boolean>(true);
  const [error, setError] = useState<string | null>(null);

  useEffect(() => {
    const fetchMovies = async () => {
      try {
        const response = await axios.get('http://localhost:8080/api/v1/m/execution/movies');
        setMovies(response.data);
      } catch (err) {
        setError('Error fetching movies');
      } finally {
        setLoading(false);
      }
    };

    fetchMovies();
  }, []);

  if (loading) {
    return <div>Loading...</div>;
  }

  if (error) {
    return <div>{error}</div>;
  }

  return (
      <div>
        <h1>Movies List</h1>
        <ul>
          {movies.map(movie => (
              <li key={movie.id}>
                <h2>{movie.name}</h2>
                <p><strong>Genre:</strong> {movie.genre}</p>
                <p><strong>Rating:</strong> {movie.rating}</p>
                <p><strong>Release Date:</strong> {movie.releaseDate}</p>
                <p><strong>Duration:</strong> {movie.duration} minutes</p>
                <p><strong>Director:</strong> {movie.director}</p>
                <p><strong>Cast:</strong> {movie.cast}</p>
                <p><strong>Description:</strong> {movie.description}</p>
                <p><a href={movie.trailer} target="_blank" rel="noopener noreferrer">Watch
                  Trailer</a></p>
                <p><a href={movie.poster} target="_blank" rel="noopener noreferrer">View Poster</a>
                </p>
              </li>
          ))}
        </ul>
      </div>
  );
};

export default Movies;
