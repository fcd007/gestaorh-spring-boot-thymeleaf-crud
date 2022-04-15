package br.com.javacode.gestaorh.controllerRest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.javacode.gestaorh.model.Funcionario;
import br.com.javacode.gestaorh.service.FuncionarioService;

@Controller
public class FuncionarioControllerRest {

	@Autowired
	FuncionarioService funcionarioService;

	@GetMapping("/")
	public String viewHomePage(Model model) {
		model.addAttribute("listaFuncionarios", funcionarioService.getAllFuncionarios());
		return findPagenated(1, "nome", "asc", model);
	}

	@GetMapping("/showForm")
	public String showForm(Model model) {
		// criar modelo atributo para realizar o bind do dado
		Funcionario funcionario = new Funcionario();
		model.addAttribute("funcionario", funcionario);

		return "new_funcionario";
	}

	@PostMapping("/salvarFuncionario")
	public String salvarFuncionario(@ModelAttribute("funcionario") Funcionario funcionario) {
		// salvar funcionario para banco
		funcionarioService.salvarFuncionario(funcionario);
		return "redirect:/";
	}

	@GetMapping("/showFormForUpdate/{id}")
	public String showFormForUpdate(@PathVariable(value = "id") Long id, Model model) {
		// get funcionarios para o service
		Funcionario funcionario = funcionarioService.getFuncionarioById(id);
		// set funcionario as model attribute para pre-populate o form
		model.addAttribute("funcionario", funcionario);
		return "update_funcionario";
	}

	@GetMapping("deleteFuncionario/{id}")
	public String deleteFuncionario(@PathVariable(value = "id") Long id) {
		// cahamda service delete
		this.funcionarioService.deleteFuncionarioById(id);
		return "redirect:/";
	}

	@GetMapping("/page/{pageNo}")
	public String findPagenated(@PathVariable(value = "pageNo") int pageNo, @RequestParam("sortField") String sortField,
			@RequestParam("sortDir") String sortDir, Model model) {

		final int pageSize = 5;

		Page<Funcionario> page = funcionarioService.findPaginated(pageNo, pageSize, sortField, sortDir);
		List<Funcionario> listaFuncionarios = page.getContent();

		model.addAttribute("currentPage", pageNo);
		model.addAttribute("totalPages", page.getTotalPages());
		model.addAttribute("totalItems", page.getTotalElements());

		model.addAttribute("sortField", sortField);
		model.addAttribute("sortDir", sortDir);
		model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");

		model.addAttribute("listaFuncionarios", listaFuncionarios);

		return "index";
	}
}
