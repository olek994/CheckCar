package pl.edu.wat.checkcar.checkcarweb.Controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import pl.edu.wat.checkcar.checkcardomain.dto.CarDto;
import pl.edu.wat.checkcar.checkcardomain.dto.CarModelDto;
import pl.edu.wat.checkcar.checkcardomain.dto.CarTypeDto;
import pl.edu.wat.checkcar.checkcardomain.dto.PersonDto;
import pl.edu.wat.checkcar.checkcardomain.entity.CarModel;
import pl.edu.wat.checkcar.checkcardomain.rest.CarModelRest;
import pl.edu.wat.checkcar.checkcardomain.rest.CarRest;
import pl.edu.wat.checkcar.checkcardomain.rest.CarTypeRest;
import pl.edu.wat.checkcar.checkcarweb.BaseController;
import pl.edu.wat.checkcar.checkcarweb.Data.AddCarData;
import pl.edu.wat.checkcar.checkcarweb.Data.CarData;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Aleksander Małkowicz, Date: 03.09.2018
 * Copyright by Wojskowa Akademia Techniczna im. Jarosława Dąbrowskiego, Warszawa 2018
 */
@Controller
@Slf4j
public class MainController extends BaseController {

    @Autowired
    CarRest carRest;

    @Autowired
    CarModelRest carModelRest;

    @Autowired
    CarTypeRest carTypeRest;

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String getMainPage(Model model, @RequestParam(name = "part", required = false, defaultValue = "false") String part){

        model.addAttribute("string","JAKIS TEKST");
        return getTemplatePath("dashboard",part);
    }

    @RequestMapping(value = "/carSearch",method = RequestMethod.GET)
    public String getCarSearchView(Model model, @RequestParam(name = "part", required = false, defaultValue = "false") String part){

        model.addAttribute("string","Car SEARCH");
        return getTemplatePath("carSearch",part);
    }

    @RequestMapping(value = "/myAccount",method = RequestMethod.GET)
    public String getMyAccountView(Model model, @RequestParam(name = "part", required = false, defaultValue = "false") String part){
        List<CarDto> cars = carRest.getCarOfOwner(getLoggedInPerson().getId());
        List<CarData> newCars = null;

        if(cars != null){
            newCars = new ArrayList<>();
        }

        for(CarDto car: cars){
            CarData carData = new CarData();
            carData.setCourse(car.getCourse());
            carData.setProductionYear(car.getYearOfProduction());
            CarModelDto carModelDto = carModelRest.getCarModel(car.getCarModelId());
            if (carModelDto != null) {
                carData.setModel(carModelDto.getModel());
            }else{
                carData.setModel("");
            }
            CarTypeDto type = carTypeRest.getCarType(car.getCarTypeId());
            if(type != null){
                carData.setType(type.getType());
            }else{
                carData.setType("");
            }

            newCars.add(carData);
        }
        model.addAttribute("cars",newCars);
        return getTemplatePath("myAccount",part);
    }

    @RequestMapping(value = "/addCar",method = RequestMethod.GET)
    public String getAddCarView(Model model,  @RequestParam(name = "part", required = false, defaultValue = "false") String part){
        List<CarModelDto> carModels = getCarModels();
        model.addAttribute("carModels",carModels);
        return getTemplatePath("addCar",part);
    }

    @RequestMapping(value = "/carType/{carModelId}",method = RequestMethod.GET)
    @ResponseBody
    public List<CarTypeDto> getAddCarView(@PathVariable("carModelId") Long carModelId){
        List<CarTypeDto> carTypes = carTypeRest.getAllTypesByModelId(carModelId);
        if(carTypes == null){
            return new ArrayList<>();
        }
        return carTypes;
    }

    private List<CarModelDto> getCarModels(){
        List<CarModelDto> list = carModelRest.getAllCarModels();
        if(list == null){
            return new ArrayList<>();
        }
        return list;
    }


    @RequestMapping(value = "/car/add",method = RequestMethod.POST)
    @ResponseBody
    public boolean addCar(@RequestBody AddCarData addCarData){
        if (addCarData == null) {
            return false;
        }
        Long modelId = Long.parseLong(addCarData.getModelId());
        Long typeId = Long.parseLong(addCarData.getTypeId());
        Long course = Long.parseLong(addCarData.getCourse());
        Long productionYear = Long.parseLong(addCarData.getProductionYear());

        CarDto carDto = new CarDto();
        carDto.setCarTypeId(typeId);
        carDto.setOwnerId(getLoggedInPerson().getId());
        carDto.setCourse(course);
        carDto.setYearOfProduction(productionYear);
        carDto.setCarModelId(modelId);

        CarDto addedCar = carRest.createCar(carDto);

        if(addedCar == null){
            return false;
        }
        return true;

    }

}
