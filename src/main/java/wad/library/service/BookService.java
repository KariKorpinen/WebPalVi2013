/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wad.library.service;

/**
 *
 * @author kkkorpin
 */

//package wad.library.service;

import wad.library.domain.Book;

public interface BookService {
    Iterable<Book> list();
    void add(String name);    
    void remove(Long bookId);
    Book findById(Long bookId);
    void addBookToLibrary(Long bookId, Long libraryId);
}
