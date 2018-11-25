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
 * Created by Aleksander on 25.11.2018.
 * Wojskowa Akademia Techniczna im. Jarosława Dąbrowskiego, Warszawa 2017r.
 */
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "T_carModel")
@NoArgsConstructor
@AllArgsConstructor
@Data
@SequenceGenerator(name = "sCarModel",
                   allocationSize = 1,
                   initialValue = 1000,
                   sequenceName = "SEQ_CarModel")
public class CarModel extends BaseEntity {
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sCarModel")
    @Id
    Long id;

    @Column
    String model;
}
