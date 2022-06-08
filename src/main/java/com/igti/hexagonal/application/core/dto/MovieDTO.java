package com.igti.hexagonal.application.core.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MovieDTO {

    private int id;
    private String name;
    private String origin;
    private String description;
    private String releasedAt;
}