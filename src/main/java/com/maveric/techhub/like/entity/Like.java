package com.maveric.techhub.like.entity;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "Like_Info")
@EntityListeners(AuditingEntityListener.class)
public class Like {
    @Id
    @Column
    private String id;
    @Column
    private String likedBy;
    @Column
    private String commentId;
    @Column
    private String type;
    @Column
    @CreatedDate
    private LocalDateTime createdDate;
    @Column
    @LastModifiedDate
    private LocalDateTime updatedDate;

}
