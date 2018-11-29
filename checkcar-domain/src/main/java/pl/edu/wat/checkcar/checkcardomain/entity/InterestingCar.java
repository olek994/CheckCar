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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * Created by Aleksander on 29.11.2018.
 * Wojskowa Akademia Techniczna im. Jarosława Dąbrowskiego, Warszawa 2017r.
 */
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name="T_INTERESTING_CAR")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Inheritance(strategy = InheritanceType.JOINED)
@SequenceGenerator(name = "sInterestingCar",
                   sequenceName = "SEQ_Interesting_car",
                   initialValue = 1000,
                   allocationSize = 1)
public class InterestingCar extends BaseEntity {
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sInterestingCar")
    @Id
    Long id;

    Long interestedId;

    @Column
    Long carId;

}
