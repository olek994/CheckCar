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
 * Created by Aleksander on 09.12.2018.
 * Wojskowa Akademia Techniczna im. Jarosława Dąbrowskiego, Warszawa 2017r.
 */
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "T_Message")
@AllArgsConstructor
@NoArgsConstructor
@Data
@SequenceGenerator(name="sMessage", initialValue = 1000, allocationSize = 1, sequenceName = "SEQ_Message")
public class Message extends BaseEntity {
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sMessage")
    @Id
    Long id;

    @Column
    Long meetingId;

    @Column
    Long authorId;

    @Column(length = 1024)
    String content;

}
