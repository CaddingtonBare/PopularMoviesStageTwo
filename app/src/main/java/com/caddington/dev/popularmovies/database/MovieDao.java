package com.caddington.dev.popularmovies.database;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.caddington.dev.popularmovies.model.Movie;

import java.util.List;

@Dao
public interface MovieDao {

    @Query("SELECT * FROM movie ORDER BY title ASC")
    LiveData<List<Movie>> getFavoriteMovies();

    @Query("SELECT * FROM movie WHERE id = :id")
    Movie getMovieById(int id);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void insertMovie(Movie movie);

    @Update(onConflict = OnConflictStrategy.REPLACE)
    public void updateMovie(Movie movie);

    @Query("DELETE FROM movie WHERE id = :id")
    public void deleteMovie(int id);


}
