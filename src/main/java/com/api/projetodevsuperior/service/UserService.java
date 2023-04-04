package com.api.projetodevsuperior.service;

import com.api.projetodevsuperior.converter.UserConverter;
import com.api.projetodevsuperior.dtos.request.UserRequestDTO;
import com.api.projetodevsuperior.dtos.response.UserResponseDTO;
import com.api.projetodevsuperior.exceptions.custom.UserNotFoundException;
import com.api.projetodevsuperior.model.User;
import com.api.projetodevsuperior.repository.DepartmentRepository;
import com.api.projetodevsuperior.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository repository;
    @Autowired
    DepartmentRepository departmentRepository;
    @Autowired
    UserConverter converter;
    public UserResponseDTO buscarPorId(Long id){
        return converter.converterToResponse(repository.findById(id).orElseThrow(() -> new UserNotFoundException(id)));
    }

    public List<UserResponseDTO> findAll(){
        return converter.converterUsersToResponse(repository.findAll());
    }

    public UserResponseDTO cadastrarUsuario(UserRequestDTO requestDTO){
        User user = new User();
        user.setName(requestDTO.getName());
        user.setEmail(requestDTO.getEmail());
        user.setDepartment(departmentRepository.findById(requestDTO.getDepartmentId()).get());
        return converter.converterToResponse(repository.save(user));
    }

    public UserResponseDTO alterarUsuario(UserRequestDTO request){
        User user = repository.findById(request.getId()).orElseThrow(()-> new UserNotFoundException(request.getId()));
        user.setEmail(request.getEmail());
        user.setName(request.getName());
        user.setDepartment(departmentRepository.findById(request.getDepartmentId()).get());
        return converter.converterToResponse(repository.save(user));
    }

}
