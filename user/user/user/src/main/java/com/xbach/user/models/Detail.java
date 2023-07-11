package com.xbach.user.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "detail")
@Data
public class Detail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name = "firstname")
    private String firstname;
    @Column(name = "lastname")
    private String lastname;
    private String address;
    private int sex;
    private String dob;

    private String phone;

    @Column(name = "user_id")
    private Long userId;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id")
    private User user;
}
