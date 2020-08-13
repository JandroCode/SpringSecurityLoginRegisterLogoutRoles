package com.example.demo.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IUsuarioDAO;
import com.example.demo.entity.Usuario;
import com.example.demo.security.IUsuarioService;

@Service
public class UsuarioServiceImpl implements IUsuarioService {
	
	@Autowired
	private IUsuarioDAO usuarioDao;

	@Override
	public void save(Usuario usuario) {
		usuarioDao.save(usuario);
		
		
	}



}
