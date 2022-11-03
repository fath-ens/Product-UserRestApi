package com.productuserapi.productUser.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;

    @ManyToOne
    @JoinColumn(name = "userid")
    private User userid;

    @Column
    private String name;

    @Column
    private String os;

    @Column
    private String cpu;

    @Column
    private int gpu;

    @Column
    private int ram;

    public Product(User userid, String name, String os, String cpu, int gpu, int ram) {
        this.userid = userid;
        this.name = name;
        this.os = os;
        this.cpu = cpu;
        this.gpu = gpu;
        this.ram = ram;
    }
}