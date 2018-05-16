package pl.edu.wat.checkcar.checkcardomain.base;

import lombok.extern.slf4j.Slf4j;
import ma.glasnost.orika.MapperFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Aleksander Małkowicz, Date: 16.05.2018
 * Copyright by Wojskowa Akademia Techniczna im. Jarosława Dąbrowskiego, Warszawa 2018
 */
@Slf4j
public abstract class BaseCrudProvider<E extends Serializable, T extends BaseDto<?>> {

    @Autowired
    protected MapperFacade mapper;

    private Class<T> dtoClazz;

    protected <D> D convert(E entity, Class<D> returnClazz){
        return mapper.map(entity, returnClazz);
    }
    protected T convert(E entity) {
        return convert(entity, getDtoClass());
    }

    protected abstract E convertToEntity(T dto, E entity);

    protected <L> List<L> convert(Collection<E> entities, Class<L> returnClass) {
        return entities.stream().map(entity -> convert(entity, returnClass)).collect(Collectors.toCollection(ArrayList::new));
    }

    public Class<T> getDtoClass() {
        if (dtoClazz == null) {
            try {
                String className = ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[1].getTypeName();
                dtoClazz = (Class<T>) Class.forName(className);
            } catch (ClassNotFoundException e) {
                log.error("DTO CLASS NOT FOUND", e);
            }
        }
        return dtoClazz;
    }

    protected List<T> convert(Collection<E> entities) {
        return convert(entities, getDtoClass());
    }

    protected Page<T> convert(Page<E> entities) {
        return entities.map(entity -> convert(entity, getDtoClass()));
    }

}
