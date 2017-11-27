package com.landvibe.codefolio.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Role implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(unique = true)
    private String name;

    @JsonIgnore // prevent infinite recursion
    @ManyToMany(
            targetEntity = User.class,
            cascade = CascadeType.ALL,
            mappedBy = "roles"
    )
    private Collection<User> users;

    public Role(String name) {
        this.name = name;
    }
}
