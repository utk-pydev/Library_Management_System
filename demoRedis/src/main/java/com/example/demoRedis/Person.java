package com.example.demoRedis;

import lombok.*;

import java.io.Serializable;


@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Person implements Serializable {
    private long id;
    private String name;
    private int creditScore;
}
