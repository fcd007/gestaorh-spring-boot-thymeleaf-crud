package br.com.javacode.gestaorh.service;

import java.util.List;

import org.springframework.data.domain.Page;

import br.com.javacode.gestaorh.model.Funcionario;

public interface FuncionarioService {

	List<Funcionario> getAllFuncionarios();

	void salvarFuncionario(Funcionario funcionario);

	Funcionario getFuncionarioById(Long id);

	void deleteFuncionarioById(Long id);

	Page<Funcionario> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);
}
