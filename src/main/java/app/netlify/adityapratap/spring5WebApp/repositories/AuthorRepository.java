package app.netlify.adityapratap.spring5WebApp.repositories;

import app.netlify.adityapratap.spring5WebApp.domain.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {

}
