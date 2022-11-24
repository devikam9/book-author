package com.example.demo.bootstrap;

import com.example.demo.domain.Author;
import com.example.demo.domain.Book;
import com.example.demo.domain.Publisher;
import com.example.demo.domain.repositories.AuthorRepository;
import com.example.demo.domain.repositories.BookRepository;
import com.example.demo.domain.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository,
                         PublisherRepository publisherRepository ) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println("bootstrap started");

        Publisher publisher = new Publisher();
        publisher.setName("SGF Publishing");
        publisher.setCity("hyderabad");
        publisher.setState("telangana");
        publisher.setZip("500000");

        publisherRepository.save(publisher);
        System.out.println("publisher count:" +publisherRepository.count());

        Author eric = new Author("minnu","mogili");
        Book ddd = new Book("Domain Driven Design","123123");
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);
        ddd.setPublisher(publisher);
        publisher.getBooks().add(ddd);


        authorRepository.save(eric);
        bookRepository.save(ddd);
        publisherRepository.save(publisher);

        Author rod = new Author("bittu","rohith");
        Book abc = new Book("j2ee ","3214567");
        rod.getBooks().add(abc);
        abc.getAuthors().add(rod);
        abc.setPublisher(publisher);
        publisher.getBooks().add(abc);

        authorRepository.save(rod);
        bookRepository.save(abc);
        publisherRepository.save(publisher);

        System.out.println("started in bootstrap");
        System.out.println("number of books:" +bookRepository.count());
        System.out.println("publisher number of books" +publisher.getBooks().size());


    }
}
