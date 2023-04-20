package com.tpe.dao;

import java.util.List;
import java.util.Optional;

public interface GenericDao <T> {
	
	public void save(T t);
	public void update(T t);
	public void delete(Long id);
	public Optional<T> find(Long id);
	public List<T> getAll();

}
