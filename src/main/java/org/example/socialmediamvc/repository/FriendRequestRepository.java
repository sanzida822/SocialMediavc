package org.example.socialmediamvc.repository;

import org.example.socialmediamvc.model.FriendRequest;
import org.example.socialmediamvc.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FriendRequestRepository extends JpaRepository<FriendRequest, Integer> {
    boolean existsBySenderAndReceiver(User sender, User receiver);


    @Query("SELECT fr FROM FriendRequest fr " +
            "JOIN FETCH fr.sender " +
            "JOIN FETCH fr.receiver " +
            "WHERE fr.receiver.id = :receiverId AND fr.friendRequestStatus = 'PENDING'")
    List<FriendRequest> findPendingFriendRequests(@Param("receiverId") Integer receiverId);




}
