package com.usa.misiontic.reto3c3.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="user")
public class User  implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idUser;
    @Column(name="name" , length = 250, nullable = false)

    private String name;
    @Column(name="email" , length = 45, nullable = false)

    private String email;
    @Column(name="password" , length = 45, nullable = false)

    private String password;

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
