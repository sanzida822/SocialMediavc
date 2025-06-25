package org.example.socialmediamvc.model;

import jakarta.persistence.*;
import lombok.Builder;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;
import java.util.Arrays;
@Entity
@Table(name="images")
@Builder
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Lob
    private byte[] data;
    @Column(name="size")
    private long sizeBytes;

    @CreationTimestamp
    private Timestamp createdAt;

    @UpdateTimestamp
    private Timestamp updatedAt;

    public Image(int id, byte[] data, long sizeBytes, Timestamp createdAt, Timestamp updatedAt) {
        super();
        this.id = id;
        this.data = data;
        this.sizeBytes = sizeBytes;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
public Image() {}
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    public long getSizeBytes() {
        return sizeBytes;
    }

    public void setSizeBytes(long sizeBytes) {
        this.sizeBytes = sizeBytes;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return "Image [id=" + id + ", data=" + Arrays.toString(data) + ", sizeBytes=" + sizeBytes + ", createdAt="
                + createdAt + ", updatedAt=" + updatedAt + "]";
    }

}
