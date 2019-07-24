package com.fornalskiapp.models.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.fornalskiapp.models.Pessoa;
import com.fornalskiapp.repositories.PessoaRepository;

@Controller
public class PessoaController {

	/* INJEÇÃO DE DEPENDENCIAS APARTIR DAQUI */
	@Autowired
	private PessoaRepository pessoaRepo;

	@RequestMapping(value = "/cadastropessoa", method = RequestMethod.GET)
	public ModelAndView inicio() {
		
		ModelAndView mv = new ModelAndView("cadastro/cadastropessoa");
		Iterable<Pessoa> pList = pessoaRepo.findAll();
		mv.addObject("pList", pList);
		mv.addObject("pessoaObj",new Pessoa());
		
		
		return mv;
	}

	/* METODO SALVAR NO BANCO */

	@RequestMapping(value = "**/salvarpessoa", method = RequestMethod.POST)
	public ModelAndView salvar(Pessoa p) {
		pessoaRepo.save(p);

		/*
		 * Método para mostrar a lista Pessoa na mesma tela. só copiar do ModelAndView
		 * do /METODO LISTAR DADOS DO BANCO/
		 */
		ModelAndView mv = new ModelAndView("cadastro/cadastropessoa");
		Iterable<Pessoa> pList = pessoaRepo.findAll();
		mv.addObject("pList", pList);
		mv.addObject("pessoaObj",new Pessoa());

		return mv;

	}
	/* METODO LISTAR DADOS DO BANCO */

	@RequestMapping(value = "/listarPessoas", method = RequestMethod.GET)
	public ModelAndView Pessoa() {

		ModelAndView mv = new ModelAndView("cadastro/cadastropessoa");
		Iterable<Pessoa> pList = pessoaRepo.findAll();
		mv.addObject("pList", pList);
		mv.addObject("pessoaObj",new Pessoa());

		return mv;

	}

	/*MÉTODO EDITAR*/
	
	/*nova anotacao do spring @GetMapping e @PostMapping*/
	
	@GetMapping("/editarPessoa/{idPessoa}")
	public ModelAndView editar(@PathVariable("idPessoa") long idPessoa) {

		Optional<Pessoa> p = pessoaRepo.findById(idPessoa);
		
		ModelAndView mv = new ModelAndView("cadastro/cadastropessoa");
		mv.addObject("pessoaObj",p.get());
		
		return mv;
	}
	
    /*MÉTODO EXCLUIR*/	
	
	@GetMapping("/removerPessoa/{idPessoa}")
	public ModelAndView excluir(@PathVariable("idPessoa") long idPessoa) {
		 
		pessoaRepo.deleteById(idPessoa);
		ModelAndView mv = new ModelAndView("cadastro/cadastropessoa");
		mv.addObject("pessoa", pessoaRepo.findAll());
		mv.addObject("pessoaObj",new Pessoa());
		return mv;
	} 	
	
	/*METÓDO PESQUISAR*/
	@PostMapping(value = "/pesquisarPessoa")
	public ModelAndView pesquisar (@RequestParam("nomePesquisa")String nomePesquisa) {
		ModelAndView mv = new ModelAndView("cadastro/cadastropessoa");
		mv.addObject("pList",pessoaRepo.findPessoaByName(nomePesquisa));
		mv.addObject("pessoaObj",new Pessoa());
		
		return mv;
		
	}
	
	/*METODO PARA INTERCEPTAR O LINK(telefones) da lista Pessoas da pagina cadastroPessoas*/
	
	@GetMapping("/telefones/{idPessoa}")
	public ModelAndView telefones (@PathVariable("idPessoa") long idPessoa) {

		Optional<Pessoa> p = pessoaRepo.findById(idPessoa);
		
	 	ModelAndView mv = new ModelAndView("cadastro/telefones");/*criado para retornar em outra TELA e não mais na cadastroPessoa*/
		mv.addObject("pessoaObj",p.get());
		
		return mv;
	}
	
}









