package com.tekarch.usermangementservice.Models;

import com.fasterxml.jackson.annotation.JsonTypeId;
import jakarta.persistence.*;
import jdk.jfr.DataAmount;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.logging.log4j.message.AsynchronouslyFormattable;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import java.time.LocalDateTime;
import java.sql.Timestamp;

@Entity
@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long user_id;
@OneToOne(cascade = CascadeType.ALL)

    @CreatedDate
    private LocalDateTime created_at;

    @Column(name="updated_at")
    private LocalDateTime updated_at;
@PreUpdate
public void preUpdate() {
    updated_at = LocalDateTime.now();
}
    @Column(unique=true)

    private String username;
    private String email;
    private String password_hash;
    private String phone_number;
    private boolean two_factor_enabled;
    //private String kyc_status;
    public enum KYCStatus {
        PENDING,
        VERIFIED,
        REJECTED
    }
    @Enumerated(EnumType.STRING)
    @Column(name = "kyc_status")
    private KYCStatus kycStatus;

    {
        kycStatus = KYCStatus.PENDING;
    }

}
