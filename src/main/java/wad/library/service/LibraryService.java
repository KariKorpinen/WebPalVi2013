/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wad.library.service;

/**
 *
 * @author kkkorpin
 */
//package wad.moviedb.service;

import wad.library.domain.Library;

public interface LibraryService {
    Iterable<Library> list();
    void add(String name, int lengthInMinutes);// lenght ??
    void remove(Long libraryId);
    Iterable<Library> listLibrariesWithout(Long bookId);
}
