package org.example.socialmediamvc.repository;

import org.example.socialmediamvc.model.Friendship;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface FriendshipRepository extends JpaRepository<Friendship, Integer> {
    @Modifying
    @Query("INSERT INTO Friendship (sender, receiver, friendshipStatus, createdAt) " +
            "SELECT fr.sender, fr.receiver, 'ACTIVE', CURRENT_TIMESTAMP " +
            "FROM FriendRequest fr " +
            "WHERE fr.id = :requestId")
    void acceptFriendRequest(@Param("requestId") Integer requestId);


}
