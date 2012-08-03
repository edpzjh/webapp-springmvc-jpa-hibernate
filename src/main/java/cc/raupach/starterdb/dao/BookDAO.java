package cc.raupach.starterdb.dao;

import java.util.List;

import cc.raupach.startderdb.util.GenericJpaDAO;
import cc.raupach.starterdb.entity.Book;


public interface BookDAO extends GenericJpaDAO<Book, Integer>
{

   List<Book> getBooksByTitle(String title);

}
