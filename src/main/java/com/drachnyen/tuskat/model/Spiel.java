package com.drachnyen.tuskat.model;

import com.sun.istack.NotNull;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;


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

    @NotNull
    private Long rundenId; //ungebundener Fremdschlüssel

    @NotNull
    private Long spielerId; //Spieler, welcher die Punkte aufgeschrieben bekommt

    @NotNull
    private Long wert; //Spielwerte von 18-144

    private Long faktor; //Folgende Möglichkeiten: -1, -2, 0


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Long getRunde() {
        return rundenId;
    }

    public void setRunde(Long runde) {
        this.rundenId = runde;
    }

    public Long getSpielerId() {
        return spielerId;
    }

    public void setSpielerId(Long spielerId) {
        this.spielerId = spielerId;
    }

    public Long getWert() {
        return wert;
    }

    public void setWert(Long wert) {
        this.wert = wert;
    }

    public Long getFaktor() {
        return faktor;
    }

    public void setFaktor(Long faktor) {
        this.faktor = faktor;
    }




}
