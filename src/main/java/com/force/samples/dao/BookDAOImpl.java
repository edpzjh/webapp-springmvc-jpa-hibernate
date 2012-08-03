package com.force.samples.dao;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Component;

import com.force.samples.entity.Book;
import com.force.samples.util.GenericJpaDAOImpl;

@Component
public class BookDAOImpl extends GenericJpaDAOImpl<Book, Integer> implements BookDAO {

	

	

	public List<Book> getBooksByTitle(String title) 
	    {
	        Query q = entityManager.createQuery ("select b from Book b where b.title= :title" );
	        q.setParameter("title", title);
	    

	        List<Book> results = q.getResultList();
	        return results;
	    }

	
}
