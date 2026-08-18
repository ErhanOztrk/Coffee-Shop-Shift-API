package com.coffeeshop.shift_api.entity;

import jakarta.persistence.*;
import java.time.ZonedDateTime;

@Entity
@Table(name = "shifts")
public class Shift {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "staff_id", nullable = false)
    private User staff;

    @Column(nullable = false)
    private ZonedDateTime startTime;

    @Column(nullable = false)
    private ZonedDateTime endTime;

    @Column(nullable = false)
    private String status;

    // 1. Empty Constructor for JPA
    public Shift() {
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public User getStaff() { return staff; }
    public void setStaff(User staff) { this.staff = staff; }

    public ZonedDateTime getStartTime() { return startTime; }
    public void setStartTime(ZonedDateTime startTime) { this.startTime = startTime; }

    public ZonedDateTime getEndTime() { return endTime; }
    public void setEndTime(ZonedDateTime endTime) { this.endTime = endTime; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}