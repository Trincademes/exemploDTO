package com.example.demo.Servicies;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entities.Livro;
import com.example.demo.Repositories.LivroRepository;
import com.example.demo.dto.LivroDTO;



@Service
public class LivroService {
	
	private final LivroRepository livroRepository;
	
	@Autowired
	public LivroService(LivroRepository livroRepository) {
	    this.livroRepository = livroRepository;
	}

	public List<Livro> buscaTodos() {
	    return livroRepository.findAll();
	}

	public Livro buscaPorId(Long id) {
	    return livroRepository.findById(id).orElse(null);
	}

	public  LivroDTO salvar(Livro livro) {
	    Livro salvarLivro = livroRepository.save(livro);	    
	    return new LivroDTO(salvarLivro.getId(), salvarLivro.getTitulo(), salvarLivro.getAutor());
	}
	public LivroDTO atualizar(Long id, Livro livro) {
		 Livro exiteLivro = livroRepository.findById(id)
		         .orElseThrow(() -> new RuntimeException("livro " + id + " não encontrado"));
		 exiteLivro.setTitulo(livro.getTitulo());
		 exiteLivro.setAutor(livro.getAutor());
		 Livro updateLivro = livroRepository.save(exiteLivro);
		 return new LivroDTO(updateLivro.getId(), updateLivro.getTitulo(), updateLivro.getAutor());
		}

		public boolean deletar(Long id) {
		 Optional<Livro> exiteLivro = livroRepository.findById(id);
		 if (exiteLivro.isPresent()) {
		     livroRepository.deleteById(id);
		     return true;
		 } else {
		     throw new RuntimeException("livro " + id + " não encontrado");
		  }
		 }


	
}
