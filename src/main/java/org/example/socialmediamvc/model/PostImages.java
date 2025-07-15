package org.example.socialmediamvc.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="post_images")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostImages {
    @EmbeddedId
    private PostImageId postImageId;

    @ManyToOne
    @MapsId("postId")
    @JoinColumn(name = "post_id")
    private Post post;

    @ManyToOne
    @MapsId("imageId")
    @JoinColumn(name="image_id")
    private Image image;



}
