package org.example.socialmediamvc.repository;

import org.example.socialmediamvc.model.FriendRequest;
import org.example.socialmediamvc.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FriendRequestRepository extends JpaRepository<FriendRequest, Integer> {
    boolean existsBySenderAndReceiver(User sender, User receiver);
}
