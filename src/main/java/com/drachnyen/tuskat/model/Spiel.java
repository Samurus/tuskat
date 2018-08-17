package com.drachnyen.tuskat.model;


import lombok.*;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;


@Data
@Entity
@Table(name="spiel")
@EntityListeners(AuditingEntityListener.class)
public class Spiel {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    private Date createdAt;

    private Long rundenId; //ungebundener Fremdschlüssel

    private Long spielerId; //Spieler, welcher die Punkte aufgeschrieben bekommt

    private Long wert; //Spielwerte von 18-144

    private Long faktor; //Folgende Möglichkeiten: -1, -2, 0


    public Long getRunde() {
        return rundenId;
    }

    public void setRunde(Long runde) {
        this.rundenId = runde;
    }


}
