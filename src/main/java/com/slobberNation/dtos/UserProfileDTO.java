package com.slobberNation.dtos;

import java.time.LocalDateTime;
import java.util.List;

public class UserProfileDTO {
    private Long id;
    private String username;
    private String email;
    private String fullName;
    private String bio;
    private String profileImageUrl;
    private LocalDateTime dateOfBirth;
    private List<String> interests;

    public UserProfileDTO() {
    }

    public UserProfileDTO(Long id, String username, String email, String fullName, String bio, String profileImageUrl, LocalDateTime dateOfBirth, List<String> interests) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.fullName = fullName;
        this.bio = bio;
        this.profileImageUrl = profileImageUrl;
        this.dateOfBirth = dateOfBirth;
        this.interests = interests;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getProfileImageUrl() {
        return profileImageUrl;
    }

    public void setProfileImageUrl(String profileImageUrl) {
        this.profileImageUrl = profileImageUrl;
    }

    public LocalDateTime getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDateTime dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public List<String> getInterests() {
        return interests;
    }

    public void setInterests(List<String> interests) {
        this.interests = interests;
    }
}
