package app.netlify.adityapratap.spring5WebApp.repositories;

import app.netlify.adityapratap.spring5WebApp.domain.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
