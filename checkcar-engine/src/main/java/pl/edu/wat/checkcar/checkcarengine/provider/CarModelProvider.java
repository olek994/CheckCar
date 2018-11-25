package pl.edu.wat.checkcar.checkcarengine.provider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Component;
import pl.edu.wat.checkcar.checkcardomain.base.BaseCrudProvider;
import pl.edu.wat.checkcar.checkcardomain.dto.CarModelDto;
import pl.edu.wat.checkcar.checkcardomain.entity.CarModel;
import pl.edu.wat.checkcar.checkcarengine.repository.CarModelRepository;

import java.util.List;

/**
 * Created by Aleksander on 25.11.2018.
 * Wojskowa Akademia Techniczna im. Jarosława Dąbrowskiego, Warszawa 2017r.
 */
@Component
public class CarModelProvider extends BaseCrudProvider<CarModel, CarModelDto> {

    @Autowired
    CarModelRepository repo;

    public CarModelDto createCarModel(CarModelDto carModelDto)

    {
        return convert(repo.save(convertToEntity(carModelDto,null)));
    }

    public CarModelDto getCarModel(Long carModelId) {
        return convert(repo.getOne(carModelId));
    }

    public void updateCarModel(Long carModelId, CarModelDto carModelDto) {
        repo.save(convertToEntity(carModelDto,repo.getOne(carModelId)));
    }

    public void deleteCarModel(Long carModelId) {
        repo.delete(carModelId);
    }

    public List<CarModelDto> getAllCarModels(){
        return convert(repo.findAll());
    }

    @Override
    protected CarModel convertToEntity(CarModelDto dto, CarModel entity)
    {
        if(entity == null){
            entity = new CarModel();
        }

        entity.setModel(dto.getModel());

        return entity;
    }
}
