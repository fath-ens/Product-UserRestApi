package com.productuserapi.productUser.Entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true,callSuper = false)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    @EqualsAndHashCode.Include
    private int id;

    @Column
    private String name;

    @Column
    private String email;

    @OneToMany(mappedBy = "userid", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Product> product;

    public User(String name) {
        this.name = name;
    }

    public static User getInstance() {
        User user = new User();
        return user;
    }
}