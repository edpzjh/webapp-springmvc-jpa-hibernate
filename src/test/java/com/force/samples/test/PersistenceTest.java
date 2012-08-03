package com.force.samples.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.force.samples.dao.AuthorDAO;
import com.force.samples.dao.BookDAO;
import com.force.samples.entity.Author;
import com.force.samples.entity.Book;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/resources/applicationContext-core.xml" })
@Transactional
@TransactionConfiguration(defaultRollback = false)
public class PersistenceTest
{

   private static Logger log = LoggerFactory.getLogger(PersistenceTest.class);

   @Autowired
   private AuthorDAO authorDAO;

   @Autowired
   private BookDAO bookDAO;
   
   @Test
   public void testDatabaseSave()
   {
      log.info("Running testDatabaseSave");

      Author author = new Author();
      author.setFirstName("Oliver");
      author.setLastName("Raupach");

      Book book = new Book();
      book.setAuthor(author);
      book.setTitle("jdhsjg");
      author.getBooks().add(book);
      
      authorDAO.makePersistent(author);
      bookDAO.makePersistent(book);
   }
   
   @Test
   public void testDatabaseRetrieve()
   {
      List<Author> authors =  authorDAO.get();
      
      for (Author author: authors)
      {
         for (Book book:author.getBooks())
         {
            log.info(book.getTitle());
         }
      }
      
      
   }
}
