package com.igti.hexagonal.application.core.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity(name = "movies")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String origin;
    private String description;
    private LocalDateTime createdAt;
    private LocalDateTime releasedAt;
}