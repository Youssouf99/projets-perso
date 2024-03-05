package com.quest.etna.models;

import com.quest.etna.enums.UserRole;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Size(min=2)
    @Column(unique = true)
    private String username;

    @NotNull
    @Size(min = 2)
    private String password;

    @Enumerated(EnumType.STRING)
    private UserRole role = UserRole.ROLE_USER;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "creation_date", updatable = false)
    private Date creationDate =  new Date();

    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedDate;
}

