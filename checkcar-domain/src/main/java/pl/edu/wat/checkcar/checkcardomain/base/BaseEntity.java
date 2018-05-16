package pl.edu.wat.checkcar.checkcardomain.base;

import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;
import pl.edu.wat.checkcar.checkcardomain.entity.listener.CheckCarFieldEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by Aleksander Małkowicz, Date: 15.05.2018
 * Copyright by Wojskowa Akademia Techniczna im. Jarosława Dąbrowskiego, Warszawa 2018
 */

@Data
@MappedSuperclass
@EntityListeners(CheckCarFieldEntityListener.class)
public class BaseEntity implements Serializable {

    @CreatedBy
    @Column(name="Time_create")
    private Date timeCreate;

    @LastModifiedBy
    @Column(name="lastTimeModified")
    private Date lastModified;

    @Column(name="Active",length = 1)
    private Boolean active = true;
}
