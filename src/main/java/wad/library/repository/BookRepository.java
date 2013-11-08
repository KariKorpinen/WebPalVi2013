/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wad.library.repository;
//package wad.moviedb.repository;

import org.springframework.data.repository.CrudRepository;
import wad.library.domain.Book;



public interface BookRepository extends CrudRepository<Book, Long> {
}
/**
 *
 * @author kkkorpin
 */
