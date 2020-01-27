package com.mairie.biblio.dao;

import com.mairie.biblio.model.User;

public interface userDaoInterface {

	User findByUsername(String username);
	User findById(int id);
}
