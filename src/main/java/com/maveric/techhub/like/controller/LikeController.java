package com.maveric.techhub.like.controller;
import com.maveric.techhub.like.model.LikeRequest;
import com.maveric.techhub.like.model.ServiceResponse;
import com.maveric.techhub.like.service.LikeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * LikeController is the class to manage for employee Likes
 * @author      Kannabiran Shanmugam
 * @version     %I%, %G%
 * @since       1.0
 */
@RestController
@RequestMapping("/likes")
@RequiredArgsConstructor
class LikeController {

    private final LikeService likeService;

    @PostMapping
    ResponseEntity<ServiceResponse> createLike(@Valid @RequestBody LikeRequest likeRequest) {
        return likeService.createLike(likeRequest);
    }

    @GetMapping("/{id}")
    ResponseEntity<ServiceResponse> getLike(@PathVariable(name = "id") String id) {
        return likeService.getLike(id);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<ServiceResponse> deleteLike(@PathVariable(name = "id") String id) {
        return likeService.deleteLike(id);
    }

    @GetMapping
    ResponseEntity<ServiceResponse> getLikes() {
        return likeService.getLikes();
    }

}