package com.tarikc.ServiceBookingSystem.Entity;

import com.tarikc.ServiceBookingSystem.Enum.ReservationStatus;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;
    private String message;
    private Boolean isRead = false;
    private Date date = new Date();

    @Enumerated(EnumType.STRING)
    private ReservationStatus status;

    public void setStatus(ReservationStatus status) {
    }
}

