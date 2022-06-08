package com.medicalclinc.medicalclinc.model.entities;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name="appointments")
public class CancelReason implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name="REASON")
    private String lastName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
