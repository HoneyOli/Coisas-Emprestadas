package coisasemprestadas.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import coisasemprestadas.daos.CoisasDAO;
import coisasemprestadas.models.Coisas;


@Controller
public class CoisasController {
	@RequestMapping ("/coisas/form")
	public String form() {
		System.out.println("Chamou meu método");
		return "coisas/form";
	}
	
	@PostMapping ("/coisas")
	public String adicionar(Coisas coisas) {
		System.out.println("Chamou o método de adicionar");
		System.out.println(coisas);
		CoisasDAO coisasDAO = new CoisasDAO();
		coisasDAO.inserir(coisas);
		return "redirect:coisas";
	}
	
	@GetMapping ("/coisas")
	public ModelAndView listar () {
		System.out.println("Chamou método de listagem");
		CoisasDAO CoisasDAO = new CoisasDAO();
		List <Coisas> lista = CoisasDAO.getLista();
		ModelAndView model = new ModelAndView ("coisas/lista");
		model.addObject("coisas", lista);
		return model;
		
	}
	
	@RequestMapping("/coisas/remover")
	public String remover (Coisas coisas) {
		System.out.println("Chamou o método remover ");
		CoisasDAO coisasDAO = new CoisasDAO ();
		coisasDAO.remover(coisas);
		
		return "redirect:/coisas";
		
	}
	
	@RequestMapping("coisas/selecionar")
	public ModelAndView selecionar (Coisas coisas) {
		CoisasDAO coisasDAO = new CoisasDAO ();
		coisas = coisasDAO.getCoisasById(coisas.getId());
		
		ModelAndView model = new ModelAndView ("coisas/Form-alterar");
		model.addObject("coisas", coisas);
		return model;
	}
	
	@PostMapping("coisas/alterar")
	public String alterar (Coisas coisas) {
		System.out.println("Chamou o método alterar ");
		CoisasDAO coisasDAO = new CoisasDAO ();
		coisasDAO.alterar(coisas);
		return "redirect:/coisas";
	}
}

