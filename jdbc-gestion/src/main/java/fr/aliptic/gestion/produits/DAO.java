package fr.aliptic.gestion.produits;

import java.sql.Connection;
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
