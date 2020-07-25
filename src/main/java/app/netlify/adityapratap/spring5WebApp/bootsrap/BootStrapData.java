package app.netlify.adityapratap.spring5WebApp.bootsrap;

import app.netlify.adityapratap.spring5WebApp.domain.Author;
import app.netlify.adityapratap.spring5WebApp.domain.Book;
import app.netlify.adityapratap.spring5WebApp.domain.Publisher;
import app.netlify.adityapratap.spring5WebApp.repositories.AuthorRepository;
import app.netlify.adityapratap.spring5WebApp.repositories.BookRepository;
import app.netlify.adityapratap.spring5WebApp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println("Started in Bootstrap");

        Publisher cronos = new Publisher();
        cronos.setName("Cronos");
        cronos.setCity("New York");
        cronos.setAddressLine1("56th street");
        cronos.setState("NY");
        cronos.setZip("789556");

        publisherRepository.save(cronos);

        System.out.println(cronos);
        System.out.println("Number of publishers: " + publisherRepository.count());

        Author john = new Author("John", "Wick");
        Book tc = new Book("The Continental", "12344321");
        john.getBooks().add(tc);
        tc.getAuthors().add(john);

        tc.setPublisher(cronos);
        cronos.getBooks().add(tc);

        authorRepository.save(john);
        bookRepository.save(tc);
        publisherRepository.save(cronos);

        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE Development without EJB", "356648979875");
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);

        noEJB.setPublisher(cronos);
        cronos.getBooks().add(noEJB);

        authorRepository.save(rod);
        bookRepository.save(noEJB);
        publisherRepository.save(cronos);


        System.out.println("Number of books: " + bookRepository.count());

        System.out.println("Number of books published by cronos: " + cronos.getBooks().size());
    }
}
