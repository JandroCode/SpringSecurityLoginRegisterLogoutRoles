package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entity.Perfil;
import com.example.demo.entity.Usuario;
import com.example.demo.security.IUsuarioService;

@Controller
public class RegisterController {
	
	@Autowired
	private IUsuarioService usuarioService;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@GetMapping("/register")
	public String registerForm(Model model) {
		model.addAttribute("usuario", new Usuario());
		return "registerForm";
	}
	
	@PostMapping("/register/save")
	public String saveUsuario(Usuario usuario) {
		
		Perfil perfilUser = new Perfil();
		perfilUser.setId(2);
		
		usuario.addPerfil(perfilUser);
		
		usuario.setEnabled(true);
		usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
		usuarioService.save(usuario);
		
		return "redirect:/home";
	}

}
