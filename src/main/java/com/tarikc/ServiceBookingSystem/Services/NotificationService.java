package com.tarikc.ServiceBookingSystem.Services;

import com.tarikc.ServiceBookingSystem.Entity.Notification;
import com.tarikc.ServiceBookingSystem.Enum.ReservationStatus;
import com.tarikc.ServiceBookingSystem.Repository.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationService {
    @Autowired
    private NotificationRepository notificationRepository;

    public void sendNotification(Long userId, String message, ReservationStatus status) {
        Notification notification = new Notification();
        notification.setUserId(userId);
        notification.setMessage(message);
        notification.setStatus(status);
        notificationRepository.save(notification);
    }

    public List<Notification> getUserNotifications(Long userId) {
        return notificationRepository.findByUserId(userId);
    }
}