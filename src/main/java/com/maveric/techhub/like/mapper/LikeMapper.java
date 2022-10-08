package com.maveric.techhub.like.mapper;

import com.maveric.techhub.like.entity.Like;
import com.maveric.techhub.like.model.LikeDTO;
import com.maveric.techhub.like.model.LikeRequest;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface LikeMapper {
    Like toEntity(LikeRequest likeRequest);
    LikeDTO toDTO(Like like);
    List<LikeDTO> toDTO(List<Like> likes);

}
