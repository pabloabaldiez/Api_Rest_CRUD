package com.api.manager.product.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;


@ToString
@EqualsAndHashCode
@Data
@Entity
@DynamicUpdate
@DynamicInsert
@Table(name="product")
public class Product{

    @Id
    @Getter
    @Setter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="name")@Getter @Setter
    private String name;

    @Column(name="price")@Getter @Setter
    private float price;

    @Column(name="stock")@Getter @Setter
    private int stock;

    @Column(name="avaiable")@Getter @Setter
    private String avaiable;
}

