package fr.aliptic.gestion.produits;

import java.sql.Connection;
<<<<<<< HEAD
=======
import java.sql.ResultSet;
>>>>>>> dea54a61a5c8092fcad515f3f559765d2e229d54
import java.util.List;


public abstract class DAO<T> {
	protected Connection connection = null;
	
	public DAO(Connection connection) {
		this.connection = connection;
	}
	
	public abstract boolean create(T obj);
	public abstract boolean update(T obj);
	public abstract boolean delete(T obj);
	public abstract T find(Object key);
	public abstract List<T> findAll();
}
