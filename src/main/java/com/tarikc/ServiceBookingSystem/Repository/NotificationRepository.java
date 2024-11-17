package com.tarikc.ServiceBookingSystem.Repository;

import com.tarikc.ServiceBookingSystem.Entity.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, Long> {
    List<Notification> findByUserId(Long userId); // Fetch notifications for a user
}