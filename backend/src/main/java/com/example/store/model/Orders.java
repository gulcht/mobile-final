package com.example.store.model;

import java.time.LocalDateTime;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Entity(name="Orders")
@Table(
	name = "orders"
)
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
	@ManyToOne(fetch = FetchType.LAZY)

	@JoinColumn(name = "customer_id", nullable = false)
	@Fetch(FetchMode.JOIN)
	private Customers customer;
	
    @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "employee_id", nullable = false)
	@Fetch(FetchMode.JOIN)
	private Employees employee;

    @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "product_id", nullable = false)
	@Fetch(FetchMode.JOIN)
	private Products product;

    @Column(name = "order_total", nullable = false)
    private Integer orderTotal;


    @CreationTimestamp
    @Column(name = "created_at", nullable = false, 
			updatable = false, insertable = false)
	@ColumnDefault("CURRENT_TIMESTAMP")
	private LocalDateTime createdAt;

    public Orders() {
        
    }

    public Orders(Customers customer, Employees employee, Products productId, Integer orderTotal,LocalDateTime createdAt) {
        this.customer = customer;
        this.employee = employee;
        this.product = productId;
        this.orderTotal = orderTotal;
        this.createdAt = createdAt;
    }

}
