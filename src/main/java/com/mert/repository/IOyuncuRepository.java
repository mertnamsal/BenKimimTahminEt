package com.mert.repository;

import com.mert.repository.entity.Oyuncu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IOyuncuRepository extends JpaRepository<Oyuncu,Long> {

    Optional<Oyuncu> findByUsername(String username);

    Optional<Oyuncu> findByUsernameAndPassword(String username,String password);

    List<Oyuncu> findByOrderByPuanDesc();
}
