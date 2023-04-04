package com.api.projetodevsuperior.converter;

import com.api.projetodevsuperior.dtos.response.UserResponseDTO;
import com.api.projetodevsuperior.model.User;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserConverter {

	public UserResponseDTO converterToResponse(User user) {
		UserResponseDTO response = new UserResponseDTO();
		response.setId(user.getId());
		response.setName(user.getName());
		response.setEmail(user.getEmail());
		response.setDepartment(user.getDepartment());
		return response;
	}

	public List<UserResponseDTO> converterUsersToResponse(List<User> users) {
		return users.stream().map(this::converterToResponse).collect(Collectors.toList());
	}
}
