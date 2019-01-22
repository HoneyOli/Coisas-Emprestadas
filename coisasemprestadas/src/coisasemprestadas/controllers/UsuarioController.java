package coisasemprestadas.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import coisasemprestadas.daos.UsuarioDAO;
import coisasemprestadas.models.Usuario;



@Controller
public class UsuarioController {
	@RequestMapping ("/usuario/form")
	public String form() {
		System.out.println("Chamou meu método");
		return "usuario/form";
	}
	
	@PostMapping ("/usuario")
	public String adicionar(Usuario usuario) {
		System.out.println("Chamou o método de adicionar");
		System.out.println(usuario);
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		usuarioDAO.inserir(usuario);
		return "redirect:usuario";
	}
	
	@GetMapping ("/usuario")
	public ModelAndView listar () {
		System.out.println("Chamou método de listagem");
		UsuarioDAO UsuarioDAO = new UsuarioDAO();
		List <Usuario> lista = UsuarioDAO.getLista();
		ModelAndView model = new ModelAndView ("usuario/lista");
		model.addObject("usuario", lista);
		return model;
		
	}
	
	@RequestMapping("/usuario/remover")
	public String remover (Usuario usuario) {
		System.out.println("Chamou o método remover ");
		UsuarioDAO usuarioDAO = new UsuarioDAO ();
		usuarioDAO.remover(usuario);
		
		return "redirect:/usuario";
		
	}
	

}


