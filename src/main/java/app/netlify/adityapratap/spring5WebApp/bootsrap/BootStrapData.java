package app.netlify.adityapratap.spring5WebApp.bootsrap;

import app.netlify.adityapratap.spring5WebApp.domain.Author;
import app.netlify.adityapratap.spring5WebApp.domain.Book;
import app.netlify.adityapratap.spring5WebApp.repositories.AuthorRepository;
import app.netlify.adityapratap.spring5WebApp.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Author john = new Author("John", "Wick");
        Book tc = new Book("The Continental", "12344321");
        john.getBooks().add(tc);
        tc.getAuthors().add(john);

        authorRepository.save(john);
        bookRepository.save(tc);

        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE Development without EJB", "356648979875");
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);

        authorRepository.save(rod);
        bookRepository.save(noEJB);

        System.out.println("Started in Bootstrap");
        System.out.println("Number of books: " + bookRepository.count());
    }
}
