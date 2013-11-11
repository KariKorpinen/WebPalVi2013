/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wad.library.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import wad.library.service.BookService;
import wad.library.service.LibraryService;

/**
 *
 * @author kkkorpin
 */
@Controller
public class BookController {
 

    @Autowired
    private BookService bookService;
    @Autowired
    private LibraryService libraryService;

    @RequestMapping(value = "books", method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("books", bookService.list());
        return "books";
    }

    @RequestMapping(value = "books", method = RequestMethod.POST)
    public String add(@RequestParam String name) {
        bookService.add(name);
        return "redirect:/app/books";
    }

    @RequestMapping(value = "books/{bookId}", method = RequestMethod.GET)
    public String view(Model model, @PathVariable(value = "bookId") Long bookId) {
        model.addAttribute("book", bookService.findById(bookId));
        model.addAttribute("libraries", libraryService.listLibrariesWithout(bookId));
        return "book";
    }

    @RequestMapping(value = "books/{bookId}/delete", method = RequestMethod.POST)
    public String add(@PathVariable(value = "bookId") Long bookId) {
        bookService.remove(bookId);
        return "redirect:/app/books";
    }

    @RequestMapping(value = "books/{bookId}/libraries", method = RequestMethod.POST)
    public String addBookToLibrary(@PathVariable(value = "bookId") Long bookId,
            @RequestParam(value = "libraryId") Long libraryId) {
        bookService.addBookToLibrary(bookId, libraryId);
        return "redirect:/app/books";
    }
}
