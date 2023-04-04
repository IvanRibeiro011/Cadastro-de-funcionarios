package com.api.projetodevsuperior.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.api.projetodevsuperior.dtos.request.UserRequestDTO;
import com.api.projetodevsuperior.dtos.response.UserResponseDTO;
import com.api.projetodevsuperior.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	@Autowired
	UserService userService;

	@GetMapping("/all")
	public ResponseEntity<List<UserResponseDTO>> findAll() {
		return new ResponseEntity<>(userService.findAll(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<UserResponseDTO> findById(@PathVariable("id") Long id) {
		return new ResponseEntity<>(userService.buscarPorId(id), HttpStatus.OK);
	}

	@PostMapping("/register")
	public ResponseEntity<UserResponseDTO> cadastrarUsuario(@RequestBody UserRequestDTO user) {
		return new ResponseEntity<>(userService.cadastrarUsuario(user), HttpStatus.OK);
	}

	@PutMapping("/updateUser")
	public ResponseEntity<UserResponseDTO> atualizarUsuario(@RequestBody UserRequestDTO user){
		return new ResponseEntity<>(userService.alterarUsuario(user),HttpStatus.OK);
	}
}
