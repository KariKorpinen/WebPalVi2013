/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wad.library.repository;

/**
 *
 * @author kkkorpin
 */
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import wad.library.domain.Book;
import wad.library.domain.Library;

public interface LibraryRepository extends CrudRepository<Library, Long> {

    @Query("SELECT library FROM LIBRARY library WHERE :book NOT MEMBER OF library.books")
    List<Library> findLibrariesWithoutBook(@Param("book") Book book);
}
