package sv.edu.udb.desafio1.service;

import sv.edu.udb.desafio1.model.Book;
import java.util.List;


public interface BookService {
List<Book> getAllBooks();
Book createBook(Book book);
List<Book> searchBooksByTitle(String title);
void deleteBook(Long id);
}
