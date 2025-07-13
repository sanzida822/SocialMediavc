package org.example.socialmediamvc.repository;

import jakarta.transaction.Transactional;
import org.example.socialmediamvc.model.FriendRequest;
import org.example.socialmediamvc.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
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
    List<FriendRequest> findReceivedRequests(@Param("receiverId") Integer receiverId);

//@Query("update FriendRequest fr set fr.friendRequestStatus='ACCEPTED' where fr.id=:requestId")
//    void updateFriendRequestStatus(@Param("requestId") Integer requestId);

    @Query("SELECT fr FROM FriendRequest fr " +
            "JOIN FETCH fr.sender " +
            "JOIN FETCH fr.receiver " +
            "WHERE fr.sender.id = :senderId AND fr.friendRequestStatus = 'PENDING'")
    List<FriendRequest> findSentRequests(@Param("senderId") Integer senderId);


}
