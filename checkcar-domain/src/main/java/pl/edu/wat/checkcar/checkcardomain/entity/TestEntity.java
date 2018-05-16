package pl.edu.wat.checkcar.checkcardomain.entity;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import pl.edu.wat.checkcar.checkcardomain.base.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * Created by Aleksander Małkowicz, Date: 15.05.2018
 * Copyright by Wojskowa Akademia Techniczna im. Jarosława Dąbrowskiego, Warszawa 2018
 */
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name="T_TEST_ENTITY")
@AllArgsConstructor
@NoArgsConstructor
@SequenceGenerator(name = "sTestEntity",
                    sequenceName = "SEQ_TEST_ENTITY",
                    initialValue = 1000,
                    allocationSize = 1)
public class TestEntity extends BaseEntity {

    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "sTestEntity")
    @Id
    Long id;

    @Column
    String testString;
}
