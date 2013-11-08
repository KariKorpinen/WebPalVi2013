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
public class RepositoryLibraryService implements LibraryService {

    @Autowired
    private LibraryRepository libraryRepository;
    @Autowired
    private BookRepository bookRepository;

    @Override
    public Iterable<Library> list() {
        return libraryRepository.findAll();
    }

    @Override
    @Transactional
    public void add(String name, int lengthInMinutes) {//length ??
        Library library = new Library();
        library.setName(name);
        library.setLengthInMinutes(lengthInMinutes);
        libraryRepository.save(library);
    }

    @Override
    @Transactional
    public void remove(Long libraryId) {
        Library library = LibraryRepository.findOne(libraryId);
        for (Book book : library.getBooks()) {
            book.getLibraries().remove(library);
        }

        LibraryRepository.delete(library);
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<Library> listLibrariesWithout(Long bookId) {
        Book book = BookRepository.findOne(bookId);
        return LibraryRepository.findLibrariesWithoutBook(book);
    }
}
