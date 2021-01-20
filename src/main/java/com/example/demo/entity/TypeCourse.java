package com.example.demo.entity;

import javax.persistence.*;

@Entity
@Table(name = "typecourse")
public class TypeCourse {
    @Id
    @Column(name = "idtype")
    private String idType;
    @Column(name = "nametype")
    private String nameType;

    public TypeCourse() {
    }

    public TypeCourse(String idType, String nameType) {
        this.idType = idType;
        this.nameType = nameType;
    }

    public String getIdType() {
        return idType;
    }

    public void setIdType(String idType) {
        this.idType = idType;
    }

    public String getNameType() {
        return nameType;
    }

    public void setNameType(String nameType) {
        this.nameType = nameType;
    }
}
