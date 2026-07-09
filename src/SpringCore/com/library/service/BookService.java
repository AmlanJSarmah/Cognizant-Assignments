package SpringCore.com.library.service;

import SpringCore.com.library.repository.BookRepository;

public class BookService {
    private BookRepository bookRepository;

    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void manageBooks() {
        System.out.println("Managing books...");
        bookRepository.save();
    }
}
