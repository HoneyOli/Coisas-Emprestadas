package coisasemprestadas.controllers;

import java.util.Calendar;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import coisasemprestadas.daos.CoisasDAO;
import coisasemprestadas.daos.EmprestimoDAO;
import coisasemprestadas.daos.UsuarioDAO;
import coisasemprestadas.models.Coisas;
import coisasemprestadas.models.Emprestimo;
import coisasemprestadas.models.Usuario;


@Controller
public class EmprestimoController {
	@RequestMapping ("/emprestimo/form")
	public ModelAndView form() {
		System.out.println("Chamou meu método");
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		List<Usuario> listaU = usuarioDAO.getUsuario();
		CoisasDAO coisasDAO = new CoisasDAO();
		List<Coisas> listaC = coisasDAO.getLista();

		ModelAndView model = new ModelAndView("emprestimo/form");

		model.addObject("usuario", listaU);
		model.addObject("coisas", listaC);

		return model;
	}
	
	@PostMapping ("/emprestimo/executarEmprestimo")
	public String adicionar(Emprestimo emprestimo) {
		System.out.println("Chamou o método de adicionar");
		System.out.println(emprestimo);
		EmprestimoDAO EmprestimoDAO = new EmprestimoDAO();
		EmprestimoDAO.inserir(emprestimo);
		return "redirect:listarEmprestimo";
	}
	



	@RequestMapping("/emprestimo/listarEmprestimo")
	public ModelAndView listar() {
		System.out.println("Chamou o metódo de listagem");
		EmprestimoDAO emprestimoDAO = new EmprestimoDAO();
		List<Emprestimo> lista = emprestimoDAO.getLista();
		ModelAndView model = new ModelAndView("emprestimo/lista");
		model.addObject("emprestimos", lista);
		return model;
	}

	@GetMapping("/emprestimo/EmpAbertos")
	public ModelAndView listarAbertos() {
		System.out.println("Chamou o metódo de listagem de emprestimos abertos");
		EmprestimoDAO emprestimoDAO = new EmprestimoDAO();
		List<Emprestimo> lista = emprestimoDAO.getAcessiveis();
		ModelAndView model = new ModelAndView("emprestimo/lista");
		model.addObject("emprestimo", lista);
		return model;
	}

	@GetMapping("/emprestimo/EmpAtrasados")
	public ModelAndView listarAtrasado() {
		System.out.println("Chamou o metódo de listagem");
		EmprestimoDAO emprestimoDAO = new EmprestimoDAO();
		List<Emprestimo> lista = emprestimoDAO.getAtrasados();
		ModelAndView model = new ModelAndView("emprestimo/EmpAtrasados");
		model.addObject("emprestimo", lista);
		return model;
	}
	@RequestMapping("/emprestimo/devolver")
	public String devolucao(Emprestimo emprestimo) {
		System.out.println("Chamou o método devolução");
		EmprestimoDAO emprestimoDAO = new EmprestimoDAO();
		System.out.println(emprestimo);
		emprestimoDAO.devolucao(emprestimo);
		return "redirect:listarEmprestimo";
	}
}
