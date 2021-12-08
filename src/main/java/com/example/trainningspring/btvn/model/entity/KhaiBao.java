package com.example.trainningspring.btvn.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.naming.Name;
import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class KhaiBao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "sdt", nullable = false)
    private String sdt;

    @Column(name = "dichuyen", nullable = false)
    private String dichuyen;

    @Column(name = "trieuchung", nullable = false)
    private String trieuchung;

    @Column(name = "nghinhiem", nullable = false)
    private String nghinhiem;

    @Column(name = "nuocbenh", nullable = false)
    private String nuocbenh;

    @Column(name = "bieuhien", nullable = false)
    private String bieuhien;

    @Temporal(TemporalType.DATE)
    @Column(name = "ngaykhaibao")
    private Date ngaykhaibao = new Date();
}
