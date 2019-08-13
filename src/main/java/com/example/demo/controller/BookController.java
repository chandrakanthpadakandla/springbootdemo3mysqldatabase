package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exceptions.BookNotFoundException;
import com.example.demo.model.Book;
import com.example.demo.service.BookService;

@RestController
@RequestMapping("/book")
public class BookController {
	@Autowired
	private BookService service;

	@RequestMapping("/addBook")
	public ResponseEntity<Book> addBook(@RequestBody Book book) {
		service.addBook(book);
		return new ResponseEntity<Book>(book, HttpStatus.OK);
	}

	@DeleteMapping("/deleteBook/{id}")
	public ResponseEntity<String> deleteBook(@PathVariable int id) {
		try {
			service.deleteBook(id);
			return new ResponseEntity<String>("record deleted", HttpStatus.OK);
		} catch (BookNotFoundException e) {
			return new ResponseEntity<String>("Record Not Found", HttpStatus.NOT_FOUND);
		}
	}

	@PutMapping("/updateBook/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable int id,@RequestBody Book book)
    {
        try
        {
        service.updateBook(id,book);
        return new ResponseEntity<Book>(HttpStatus.OK);
        }
        catch(BookNotFoundException e)
        {
            return new ResponseEntity<Book>(HttpStatus.NOT_FOUND);
        }
    }
	@GetMapping("/getAllBooks")
	public ResponseEntity<List<Book>> getAllBooks(){
        List<Book> books=service.getAllBooks();
        return new ResponseEntity<List<Book>>(books,HttpStatus.OK);
	}
	
	@GetMapping("/displaySpecificBook/{id}")
	public ResponseEntity<Book> displaySpecificBook(@PathVariable int id){
		Book book=null;
		try {
			book=service.displaySpecificBook(id);
	        return new ResponseEntity<Book>(book,HttpStatus.OK);
		}        catch(BookNotFoundException ex) {
            return new ResponseEntity<Book>(HttpStatus.NOT_FOUND);

		}

		}
	}
	
	


