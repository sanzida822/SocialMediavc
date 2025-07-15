package org.example.socialmediamvc.model;

import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class PostImageId implements Serializable {

    private int postId;
    private int imageId;
}
