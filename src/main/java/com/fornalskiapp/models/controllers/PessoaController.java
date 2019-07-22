package com.fornalskiapp.models.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.fornalskiapp.models.Pessoa;
import com.fornalskiapp.repositories.PessoaRepository;

@Controller
public class PessoaController {

	/* INJEÇÃO DE DEPENDENCIAS APARTIR DAQUI */
	@Autowired
	private PessoaRepository pessoaRepo;

	@RequestMapping(value = "/cadastropessoa", method = RequestMethod.GET)
	public String inicio() {
		return "cadastro/cadastropessoa";
	}

	/* METODO SALVAR NO BANCO */

	@RequestMapping(value = "salvarpessoa", method = RequestMethod.POST)
	public ModelAndView salvar(Pessoa p) {
		pessoaRepo.save(p);

		/*
		 * Método para mostrar a lista Pessoa na mesma tela. só copiar do ModelAndView
		 * do /METODO LISTAR DADOS DO BANCO/
		 */
		ModelAndView mv = new ModelAndView("cadastro/cadastropessoa");
		Iterable<Pessoa> pList = pessoaRepo.findAll();
		mv.addObject("pList", pList);

		return mv;

	}
	/* METODO LISTAR DADOS DO BANCO */

	@RequestMapping(value = "/listarPessoas", method = RequestMethod.GET)
	public ModelAndView Pessoa() {

		ModelAndView mv = new ModelAndView("cadastro/cadastropessoa");
		Iterable<Pessoa> pList = pessoaRepo.findAll();
		mv.addObject("pList", pList);

		return mv;

	}

}
