package com.durc.crud;

import com.durc.crud.entidade.Estudante;
import com.durc.crud.repository.EstudanteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudApplication.class, args);
	}

	@Autowired
	private EstudanteRepositorio estudanteRepositorio;

//	@Override
//	public void run(String... args) throws Exception {
//		Estudante estudante1 = new Estudante("Willyam", "Rodrigo", "willyamrec1993@gmail.com");
//		estudanteRepositorio.save(estudante1);
//
//		Estudante estudante2 = new Estudante("Rafael", "Santiago", "santiago2000@gmail.com");
//		estudanteRepositorio.save(estudante2);
//	}
}
