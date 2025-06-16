package org.example.socialmediamvc.dao;


import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.example.socialmediamvc.model.User;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {
    @PersistenceContext
    private EntityManager entityManager ;
    @Transactional

    public void save(User user) {
        entityManager.persist(user);
    }
}
