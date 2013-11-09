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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import wad.library.domain.Book;
import wad.library.domain.Library;
import wad.library.repository.BookRepository;
import wad.library.repository.LibraryRepository;

@Service
public class RepositoryBookService implements BookService {

    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private LibraryRepository libraryRepository;

    @Override
    public Iterable<Book> list() {
        return bookRepository.findAll();
    }

    @Override
    @Transactional
    public void add(String name) {
        Book book = new Book();
        book.setName(name);

        bookRepository.save(book);
    }

    @Override
    @Transactional
    public void remove(Long bookId) {
        Book book = bookRepository.findOne(bookId);
        for (Library library : book.getLibraries()) {
            //library.
            library.getBooks().remove(book);
        }

        bookRepository.delete(bookId);
    }

    @Override
    @Transactional
    public void addBookToLibrary(Long bookId, Long libraryId) {
        Book book = bookRepository.findOne(bookId);
        Library library = libraryRepository.findOne(libraryId);

        book.getLibraries().add(library);
        library.getBooks().add(book);
    }

    @Override
    public Book findById(Long bookId) {
        return bookRepository.findOne(bookId);
    }
}
