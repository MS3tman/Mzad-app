package com.mse.mzad.account.internal.infrastructure.database;

import com.mse.mzad.shared.base.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "user_locations")
@Setter
@Getter
public class UserLocationEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String address;
    private String country;
    private String city;
    private String postalCode;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    public UserLocationEntity() {
    }

    public UserLocationEntity(
            long id,
            String address,
            String country,
            String city,
            String postalCode,
            UserEntity user
    ) {
        this.id = id;
        this.address = address;
        this.country = country;
        this.city = city;
        this.postalCode = postalCode;
        this.user = user;
    }

    public UserLocationEntity(
            String address,
            String country,
            String city,
            String postalCode,
            UserEntity user
    ) {
        this.address = address;
        this.country = country;
        this.city = city;
        this.postalCode = postalCode;
        this.user = user;
    }

}
