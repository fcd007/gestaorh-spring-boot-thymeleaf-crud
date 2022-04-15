package br.com.javacode.gestaorh.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.com.javacode.gestaorh.model.Funcionario;
import br.com.javacode.gestaorh.repository.FuncionarioRepository;

@Service
public class FuncionarioServiceImpl implements FuncionarioService {

	@Autowired
	FuncionarioRepository funcionarioRepository;

	@Override
	public List<Funcionario> getAllFuncionarios() {
		return funcionarioRepository.findAll();
	}

	@Override
	public void salvarFuncionario(Funcionario funcionario) {
		this.funcionarioRepository.save(funcionario);
	}

	@Override
	public Funcionario getFuncionarioById(Long id) {
		Optional<Funcionario> optional = funcionarioRepository.findById(id);

		Funcionario funcionario = null;

		if (optional.isPresent()) {
			funcionario = optional.get();
		} else {
			throw new RuntimeException("Funcionario não encontrado com id: " + id);
		}

		return funcionario;
	}

	@Override
	public void deleteFuncionarioById(Long id) {
		this.funcionarioRepository.deleteById(id);
	}

	@Override
	public Page<Funcionario> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
		Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending()
				: Sort.by(sortField).descending();

		Pageable pageable = PageRequest.of(pageNo -1, pageSize, sort);
		return this.funcionarioRepository.findAll(pageable);
	}
}
