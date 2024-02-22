package com.example.demo.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entities.Livro;

public interface LivroRepository extends JpaRepository<Livro, Long>{
	
}

