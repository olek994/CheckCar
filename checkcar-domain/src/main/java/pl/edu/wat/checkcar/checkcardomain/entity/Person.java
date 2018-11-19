package pl.edu.wat.checkcar.checkcardomain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import pl.edu.wat.checkcar.checkcardomain.base.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created by Aleksander Małkowicz, Date: 25.05.2018
 * Copyright by Wojskowa Akademia Techniczna im. Jarosława Dąbrowskiego, Warszawa 2018
 */
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name="T_PERSON")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Inheritance(strategy = InheritanceType.JOINED)
@SequenceGenerator(name = "sPerson",
        sequenceName = "SEQ_Person",
        initialValue = 1000,
        allocationSize = 1)
public class Person extends BaseEntity {

    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "sPerson")
    @Id
    Long id;

    @Column
    String name;

    @Column
    String surname;

    @Column
    String userName;

    @Column(nullable = false,unique = true)
    String password;

    @Column(nullable = false, unique = true)
    String email;

    @Column
    Date birthday;


}
