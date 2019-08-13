package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.dao.BookDAO;
import com.example.demo.exceptions.BookNotFoundException;
import com.example.demo.model.Book;

@Service
public class BookServiceImpl implements BookService {
	@Autowired
	private BookDAO dao;

	@Override
	public void addBook(Book book) {
		dao.save(book);
	}

	@Override
	public boolean deleteBook(int id) throws BookNotFoundException {
		boolean found = false;
		Book book = dao.findById(id).get();
		if (book == null) {
			throw new BookNotFoundException("Book Not Found Exception");
		} else {
			dao.deleteById(id);

		}
		return found;
	}

	@Override
	public void updateBook(int id, Book book) throws BookNotFoundException {
		boolean found = false;
		found = dao.existsById(id);
		if (!found) {
			throw new BookNotFoundException("Book not updated exception");
		} else {
			dao.save(book);
		}
	}

	@Override
	public List<Book> getAllBooks() {
		return (List<Book>) dao.findAll();
	}

	@Override
	public Book displaySpecificBook(int id) throws BookNotFoundException {
		Book book = dao.findById(id).get();
		if (book == null) {
			throw new BookNotFoundException("Book Not Found");

		}
		return book;
	}

}
