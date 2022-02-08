package com.seledtsova.java.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "gender")
public class Gender {

    @Id
    @SequenceGenerator(name = "gender_id_seq", sequenceName = "gender_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "gender_id_seq")
    @Column(updatable = false, nullable = false)
    private Long id;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private GenderType name;

    @Override
    public String toString() {
        return "Gender{" +
                "id=" + id +
                ", name=" + name +
                '}';
    }
}
