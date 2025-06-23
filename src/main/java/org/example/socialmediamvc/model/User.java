package org.example.socialmediamvc.model;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import java.sql.Timestamp;


@Entity
@Table(name="users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String username;
    @Column(unique=true)
    private String email;
    private String password;
    private String salt;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "image_id")
    private Image profileImage;
    @CreationTimestamp
    @Column(name="created_at")
    private Timestamp createdAt;
    @UpdateTimestamp
    @Column(name="updated_at")
    private Timestamp updatedAt;


}
