package com.codegym.validate_info_song.service;

import com.codegym.validate_info_song.model.Song;


import java.util.Optional;



public interface ISongService {
    Iterable<Song> findAll();

    Optional<Song> findById(Long id);

    void save(Song song);


}
