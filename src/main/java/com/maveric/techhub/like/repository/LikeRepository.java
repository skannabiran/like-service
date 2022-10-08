package com.maveric.techhub.like.repository;

import com.maveric.techhub.like.entity.Like;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LikeRepository extends JpaRepository<Like, String> {

    Optional<Like> findById(String Id);

}