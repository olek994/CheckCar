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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created by Aleksander Małkowicz, Date: 25.05.2018
 * Copyright by Wojskowa Akademia Techniczna im. Jarosława Dąbrowskiego, Warszawa 2018
 */
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "T_Meeting")
@AllArgsConstructor
@NoArgsConstructor
@Data
@SequenceGenerator(name="sMeeting",initialValue = 1000,allocationSize = 1,sequenceName = "SEQ_Meeting")
public class Meeting extends BaseEntity {
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "sMeeting")
    @Id
    Long id;

    @JoinColumn(name = "carId")
    Car carId;

    @JoinColumn(name = "ownerId")
    Person ownerId;

    @JoinColumn(name = "interestedId")
    Person interestedId;

    @Column
    Date meetingDate;

    @Column
    Double cost;


}
