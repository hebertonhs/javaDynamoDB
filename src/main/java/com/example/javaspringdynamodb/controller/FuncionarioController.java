package com.example.javaspringdynamodb.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.javaspringdynamodb.entity.Funcionario;
import com.example.javaspringdynamodb.repository.FuncionarioRepository;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/funcionario")
public class FuncionarioController {
	private FuncionarioRepository funcionarioRepository;

	@PostMapping
	public Funcionario save(@RequestBody Funcionario funcionario) {
		return funcionarioRepository.save(funcionario);
	}

	@GetMapping("/{id}")
	public Funcionario getFuncionarioById(@PathVariable("id") String funcionarioId) {
		return funcionarioRepository.getFuncionarioById(funcionarioId);
	}

	@DeleteMapping("/{id}")
	public String delete(@PathVariable("id") String funcionarioId) {
		return funcionarioRepository.delete(funcionarioId);
	}

	@PutMapping("/{id}")
	public String update(@PathVariable("id") String funcionarioId, @RequestBody Funcionario funcionario) {
		return funcionarioRepository.update(funcionarioId, funcionario);
	}
}