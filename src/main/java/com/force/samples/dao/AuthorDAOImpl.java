package com.force.samples.dao;

import java.util.List;

import org.springframework.orm.jpa.support.JpaDaoSupport;

import com.force.samples.entity.Author;

public class AuthorDAOImpl extends JpaDaoSupport implements AuthorDAO {

	public List<Author> getAllAuthors() {
		return getJpaTemplate().find("select b from Author b");
	}


}
