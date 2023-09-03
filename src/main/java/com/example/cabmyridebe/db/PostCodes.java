package com.example.cabmyridebe.db;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

@Entity
@Table(name = "post_codes")
@Getter
@Setter
@NoArgsConstructor
public class PostCodes {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "post_codes_gen")
    @SequenceGenerator(name = "post_codes_gen", sequenceName = "post_codes_seq")
    @Column(name = "id", nullable = false)
    @JdbcTypeCode(SqlTypes.INTEGER)
    private Long id;

    @Column(name = "post_code", nullable = false, unique = true)
    private String postCode;
    private Double latitude;
    private Double longitude;
    private boolean isSO;

}
