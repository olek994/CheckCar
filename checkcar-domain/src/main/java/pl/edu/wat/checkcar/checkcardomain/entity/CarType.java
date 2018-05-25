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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * Created by Aleksander Małkowicz, Date: 25.05.2018
 * Copyright by Wojskowa Akademia Techniczna im. Jarosława Dąbrowskiego, Warszawa 2018
 */
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "T_carType")
@NoArgsConstructor
@AllArgsConstructor
@Data
@SequenceGenerator(name = "sCarType",
                    allocationSize = 1,
                    initialValue = 1000,
                    sequenceName = "SEQ_CarType")
public class CarType extends BaseEntity {

    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sCarType")
    @Id
    Long id;

    @Column
    String type;
}
