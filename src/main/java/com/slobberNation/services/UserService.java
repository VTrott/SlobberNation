package com.slobberNation.services;

import com.slobberNation.dtos.UserDTO;
import com.slobberNation.dtos.UserRegistrationDTO;
import com.slobberNation.models.User;
import com.slobberNation.repositories.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final ModelMapper modelMapper;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.modelMapper = modelMapper;
    }

    public UserDTO registerUser(UserRegistrationDTO registrationDTO){
        User user = modelMapper.map(registrationDTO,User.class);
        user.setPassword(passwordEncoder.encode(registrationDTO.getPassword()));
        User savedUser = userRepository.save(user);
        return modelMapper.map(savedUser, UserDTO.class);
    }

    public UserDTO getUserById(Long id){
        User user = userRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("User not Found"));
        return modelMapper.map(user, UserDTO.class);
    }

    public List<UserDTO> getAllUsers(){
        return userRepository.findAll().stream()
                .map(user-> modelMapper.map(user, UserDTO.class))
                .collect(Collectors.toList());
    }

    public UserDTO updateUser(Long id, UserDTO userDTO){
        User user = userRepository.findById(id)
                .orElseThrow(()->new RuntimeException("User not found"));
        modelMapper.map(userDTO,user);
        User updatedUser = userRepository.save(user);
        return modelMapper.map(updatedUser, UserDTO.class);
    }

    public void deleteUser(Long id){
        userRepository.deleteById(id);
    }

}
