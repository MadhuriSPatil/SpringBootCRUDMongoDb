package com.sbms.mongo.api.resource;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sbms.mongo.api.model.Book;
import com.sbms.mongo.api.repository.BookRepository;

@RestController
public class BookController {

	@Autowired
	private BookRepository bookRepository;
	
	@PostMapping("/addNewBook")
	public String saveBook(@RequestBody Book book)
	{
		bookRepository.save(book);
		return "Book added with ID " + book.getId();
	}
	
	@GetMapping("/getAllBooks")
	public List<Book> getAllBooks()
	{
		return bookRepository.findAll();
	}
	
	@GetMapping("/getBook/{id}")
	public Optional<Book> getBookById(@PathVariable int bookId)
	{
		return bookRepository.findById(bookId);
	}
	
	@DeleteMapping("/deleteBook/{id}")
	public String deleteBook(@PathVariable int bookId)
	{
		bookRepository.deleteById(bookId);
		return "Book deleted with id: " + bookId;
	}
	
}
