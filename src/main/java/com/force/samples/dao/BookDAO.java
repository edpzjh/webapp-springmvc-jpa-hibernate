package com.force.samples.dao;

import java.util.List;

import com.force.samples.entity.Book;
import com.force.samples.util.GenericJpaDAO;

public interface BookDAO extends GenericJpaDAO<Book, Integer>
{

   List<Book> getBooksByTitle(String title);

}
