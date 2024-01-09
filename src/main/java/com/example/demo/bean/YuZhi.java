package com.example.demo.bean;

import lombok.*;

import javax.persistence.*;

@Setter
@Getter
@Entity
@Table

public class YuZhi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String equipName;
    private String min;
    private String max;
    private String equipCode;

    @Override
    public String toString() {
        return "YuZhi{" +
                "id=" + id +
                ", equipName='" + equipName + '\'' +
                ", min='" + min + '\'' +
                ", max='" + max + '\'' +
                ", equipCode='" + equipCode + '\'' +
                '}';
    }
}
