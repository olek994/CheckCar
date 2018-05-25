package pl.edu.wat.checkcar.checkcardomain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.util.List;

/**
 * Created by Aleksander Małkowicz, Date: 25.05.2018
 * Copyright by Wojskowa Akademia Techniczna im. Jarosława Dąbrowskiego, Warszawa 2018
 */

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name="T_User")
@AllArgsConstructor
@NoArgsConstructor
@Data
@SequenceGenerator(name = "sUser",
        sequenceName = "SEQ_User",
        initialValue = 1000,
        allocationSize = 1)
public class User extends Person {

    @Column
    String email;

    @Column
    String password;

    @OneToMany(mappedBy = "ownerId",cascade = CascadeType.REMOVE)
    List<Car> carList;




}
