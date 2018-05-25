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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created by Aleksander Małkowicz, Date: 25.05.2018
 * Copyright by Wojskowa Akademia Techniczna im. Jarosława Dąbrowskiego, Warszawa 2018
 */
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "T_CAR")
@AllArgsConstructor
@NoArgsConstructor
@Data
@SequenceGenerator(name = "sCar",
        sequenceName = "SEQ_Car",
        initialValue = 1000,
        allocationSize = 1)
public class Car extends BaseEntity {

    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sCar")
    @Id
    Long id;

    @JoinColumn(name = "carTypeId")
    CarType carTypeId;

    @Column
    Date yearOfProduction;

    @Column
    Long course;

    @ManyToOne
    @JoinColumn(name = "ownerId")
    User ownerId;
}
