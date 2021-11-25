package com.codegym.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Pig {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pigId;
    private String pigCode;
    private String enterBarnDate;
    private String beforePigWeight;
    private String outBarnDate;
    private String afterPigWeight;
    private String origin;
    private String status;




}
