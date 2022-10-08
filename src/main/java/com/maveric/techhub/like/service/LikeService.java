package com.maveric.techhub.like.service;

import com.maveric.techhub.like.entity.Like;
import com.maveric.techhub.like.exception.EntityNotFoundException;
import com.maveric.techhub.like.mapper.LikeMapper;
import com.maveric.techhub.like.model.LikeRequest;
import com.maveric.techhub.like.model.LikeDTO;
import com.maveric.techhub.like.repository.LikeRepository;
import com.maveric.techhub.like.model.ServiceResponse;
import com.maveric.techhub.like.util.ServiceConstants;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Slf4j
@Component
@RequiredArgsConstructor
public class LikeService {

    private final LikeRepository likeRepository;
    private final LikeMapper likeMapper;

    public ResponseEntity<ServiceResponse> createLike(LikeRequest likeRequest) {
            Like like = likeMapper.toEntity(likeRequest);
            like.setId(ServiceConstants._UUID());
            likeRepository.save(like);
            LikeDTO LikeDTO = likeMapper.toDTO(like);
            return ResponseEntity.status(HttpStatus.CREATED).
                    body(ServiceResponse.builder().response(LikeDTO).build());
    }

    public ResponseEntity<ServiceResponse> getLike(String id) {
        Optional<Like> optional = likeRepository.findById(id);
        if (optional.isPresent()) {
            Like like = optional.get();
            LikeDTO LikeDTO = likeMapper.toDTO(like);
            return ResponseEntity.status(HttpStatus.OK).
                    body(ServiceResponse.builder().response(LikeDTO).build());
        }
        throw new EntityNotFoundException(String.format(ServiceConstants.ENTITY_NOT_FOUND, id));
    }

    public ResponseEntity<ServiceResponse> deleteLike(String id) {
        Optional<Like> optionalUser = likeRepository.findById(id);
        if (optionalUser.isPresent()) {
            Like like = optionalUser.get();
            likeRepository.delete(like);
            ServiceResponse serviceResponse = ServiceResponse.builder().
                    message(String.format(ServiceConstants.ENTITY_DELETED, id)).build();
            return ResponseEntity.status(HttpStatus.OK).body(serviceResponse);
        }
        throw new EntityNotFoundException(String.format(ServiceConstants.ENTITY_NOT_FOUND, id));
    }

    public ResponseEntity<ServiceResponse> getLikes() {
        ServiceResponse serviceResponse = ServiceResponse.builder().build();
        List<Like> likes = likeRepository.findAll();
        if (!likes.isEmpty()) {
            List<LikeDTO> likeDTOS = likeMapper.toDTO(likes);
            serviceResponse.setResponse(likeDTOS);
        }
        return ResponseEntity.status(HttpStatus.OK).body(serviceResponse);
    }

}
