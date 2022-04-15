package br.com.javacode.gestaorh.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface PagingAndSortingRepository <T, ID> extends CrudRepository<T, ID>{

	/**
	 * @param sort
	 * @return all entities sorted
	 */
	Iterable<T> findAll(Sort sort);
	
	/**
	 * @param pageable
	 * @return sorted pages
	 */
	Page<T> findAll(Pageable pageable);
}
