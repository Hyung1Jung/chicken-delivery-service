package com.deliveryservice.domain.user.entity;

import com.deliveryservice.domain.user.BaseTime;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User extends BaseTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;

    private String password;

    private String name;

    private String phone;

    private String address;

    @Builder
    public User(Long id, String email, String password, String name, String phone, String address) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.name = name;
        this.phone = phone;
        this.address = address;
    }
}
