package com.example.store.model;

import java.time.LocalDateTime;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Entity(name="Customers")
@Table(
	name = "customers",
    uniqueConstraints = {
                @UniqueConstraint(name = "customers_c_user_unique", columnNames = "c_user")
        }
)
public class Customers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "c_user", unique = true, nullable = true)
    private String cUser;

    @Column(name = "password", nullable = false)
    private String password;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, 
			updatable = false, insertable = false)
	@ColumnDefault("CURRENT_TIMESTAMP")
	private LocalDateTime createdAt;

    public Customers() {
        
    }

    public Customers(String firstName, String lastName, String cUser, String password,LocalDateTime createdAt) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.cUser = cUser;
        this.password = password;
        this.createdAt = createdAt;
    }

}
