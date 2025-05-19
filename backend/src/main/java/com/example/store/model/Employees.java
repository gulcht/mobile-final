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

@Entity(name="Employees")
@Table(
	name = "employees",
    uniqueConstraints = {
                @UniqueConstraint(name = "employees_user_unique", columnNames = "user")
        }
)
public class Employees {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "user", unique = true, nullable = false)
    private String user;

    @Column(name = "password", nullable = false)
    private String password;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, 
			updatable = false, insertable = false)
	@ColumnDefault("CURRENT_TIMESTAMP")
	private LocalDateTime createdAt;

    public Employees() {
        
    }

    public Employees(String firstName, String lastName, String user, String password,LocalDateTime createdAt) {
        // this.id = id;
        this.firstName = firstName;
        this.lastName = firstName;
        this.user = user;
        this.password = password;
        this.createdAt = createdAt;
    }

}
