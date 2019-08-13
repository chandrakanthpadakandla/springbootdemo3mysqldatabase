package com.example.demo.service;
import java.util.List;

import com.example.demo.exceptions.BookNotFoundException;
import com.example.demo.model.Book;
public interface BookService {
    public void addBook(Book book);
    
    public boolean deleteBook(int id) throws BookNotFoundException;
    

	public void updateBook(int id,Book book)throws BookNotFoundException;
	
    public  List<Book> getAllBooks();

    
    public Book displaySpecificBook(int id) throws BookNotFoundException;
}