package br.edu.ifpb.pdist.hospitalcare.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ifpb.pdist.hospitalcare.model.User;

public interface UserRepository extends JpaRepository<User, String> {
    
    public List<User> findByEnabledTrue();
}
