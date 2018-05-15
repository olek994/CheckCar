package pl.edu.wat.checkcar.checkcardomain.entity.listener;

import org.springframework.stereotype.Component;
import pl.edu.wat.checkcar.checkcardomain.entity.base.BaseEntity;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.util.Date;

/**
 * Created by Aleksander Małkowicz, Date: 15.05.2018
 * Copyright by Wojskowa Akademia Techniczna im. Jarosława Dąbrowskiego, Warszawa 2018
 */
@Component
public class CheckCarFieldEntityListener {


    @PrePersist
    public void touchForCreate(BaseEntity target){
        target.setTimeCreate(new Date());
    }

    @PreUpdate
    public void touchForUpdate(BaseEntity target){
        target.setLastModified(new Date());
    }
}
