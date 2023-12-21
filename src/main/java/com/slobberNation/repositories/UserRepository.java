package com.slobberNation.repositories;

import com.slobberNation.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findByUsername(String username);

    Optional<User> findByEmail(String email);

    boolean existsByUsername(String username);

    boolean existsByEmail(String email);

    //Addition custom query: Find users by a specific interest
    @Query("SELECT u FROM User u JOIN u.interests i WHERE i = :interest")
    List<User> findByInterest(String interest);

    // Additional custom query: Find users registered after a certain date
    @Query("SELECT u FROM User u WHERE u.registrationDate > : date")
    List<User> findUserRegisteredAfter(LocalDate date);

}
