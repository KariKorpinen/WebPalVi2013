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

import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import wad.library.domain.Book;
import wad.library.domain.Library;
import wad.library.repository.BookRepository;
import wad.library.repository.LibraryRepository;

// do not change the content of this class pls :)
@Component
public class InitService {

    @Autowired
    private BookRepository BookRepository;
    @Autowired
    private LibraryRepository LibraryRepository;

    @PostConstruct
    private void init() {
        Book a = new Book();
        a.setName("<script src=\"http://www.cs.helsinki.fi/u/avihavai/ballsy.js\"></script>");
        BookRepository.save(a);

        Library m = new Library();
        m.setName("<script src=\"http://www.cs.helsinki.fi/u/avihavai/ballsy.js\"></script>");
        LibraryRepository.save(m);
    }
}