package com.example.demo.bean;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(indexes = {@Index(name = "idx_equipCode", columnList = "equipCode")})
public class ZhenDong {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long date;
    private String equipName;
    private String equipType;
    private String equipCode;
    private String value;

}
