package com.teste.controller;

import java.util.ArrayList;
import java.util.*;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.teste.model.AmigoModel;

@Controller
public class AmigoController {

	@RequestMapping(value = "/GravarAmigo", method = RequestMethod.POST)
	public @ResponseBody void GravarAmigo(@RequestBody AmigoModel amigo) {

		
	}
	
	@RequestMapping(value = "/AlterarAmigo", method = RequestMethod.POST)
	public @ResponseBody void AlterarAmigo(@RequestBody AmigoModel amigo) {

		
	}
	
	@RequestMapping(value = "/ExcluirAmigo/{id}", method = RequestMethod.POST)
	public @ResponseBody void ExcluirAmigo(@PathVariable int id) {

		
	}
	
	@RequestMapping(value = "/ListarAmigo", method = RequestMethod.GET)
	public @ResponseBody List<AmigoModel> ListarAmigo() {
		
		List<AmigoModel> amigos = new ArrayList<AmigoModel>();
		
		AmigoModel amigo =new AmigoModel();
		amigo.setId(1);
		amigo.setNome("Lucas");
		amigo.setEmail("teste@teste.com");
		
		AmigoModel amigo2 =new AmigoModel();
		amigo2.setId(2);
		amigo2.setNome("João");
		amigo2.setEmail("teste2@teste2.com");		
		
		amigos.add(amigo);
		amigos.add(amigo2);
		
		return amigos;
		
	}

	@RequestMapping(value = "/SortearAmigo", method = RequestMethod.POST)
	public @ResponseBody List<AmigoModel> SortearAmigo(@RequestBody List<AmigoModel> amigos) {

		List<AmigoModel> amigos2 = new ArrayList<AmigoModel>();
		
		AmigoModel amigo =new AmigoModel();
		amigo.setId(1);
		amigo.setNome("Lucas");
		amigo.setEmail("teste@teste.com");
		
		AmigoModel amigo2 =new AmigoModel();
		amigo2.setId(2);
		amigo2.setNome("João");
		amigo2.setEmail("teste2@teste2.com");		
		amigo2.setSecreto(amigo);
		amigo.setSecreto(amigo2);
		
		amigos2.add(amigo);
		amigos2.add(amigo2);
		
		return amigos;
		
	}

	
}
