package com.maveric.techhub.like.model;

import com.maveric.techhub.like.util.ServiceConstants;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
public class LikeRequest {

    @NotBlank(message = ServiceConstants.COMMENT_ID_IS_MANDATORY)
    private String commentId;
    @NotBlank(message = ServiceConstants.LIKED_BY_MANDATORY)
    private String likedBy;
    @NotBlank(message = ServiceConstants.TYPE_IS_MANDATORY)
    @Pattern(regexp = ("Idea|Project"), message=ServiceConstants.IDEA_OR_PROJECT)
    private String type;
}
