package app.netlify.adityapratap.spring5WebApp.repositories;

import app.netlify.adityapratap.spring5WebApp.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {

}
