package com.maveric.techhub.like.model;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class LikeDTO {

    private String id;
    private String likedBy;
    private String commentId;
    private String type;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;
}
