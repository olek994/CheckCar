package pl.edu.wat.checkcar.checkcarweb.Controller;

import com.sun.org.apache.xpath.internal.operations.Bool;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.edu.wat.checkcar.checkcardomain.GearBoxEnum;
import pl.edu.wat.checkcar.checkcardomain.dto.CarDto;
import pl.edu.wat.checkcar.checkcardomain.dto.CarModelDto;
import pl.edu.wat.checkcar.checkcardomain.dto.CarTypeDto;
import pl.edu.wat.checkcar.checkcardomain.dto.PersonDto;
import pl.edu.wat.checkcar.checkcardomain.rest.CarModelRest;
import pl.edu.wat.checkcar.checkcardomain.rest.CarRest;
import pl.edu.wat.checkcar.checkcardomain.rest.CarTypeRest;
import pl.edu.wat.checkcar.checkcardomain.rest.PersonRest;
import pl.edu.wat.checkcar.checkcarweb.BaseController;
import pl.edu.wat.checkcar.checkcarweb.data.AddCarData;
import pl.edu.wat.checkcar.checkcarweb.data.CarData;
import pl.edu.wat.checkcar.checkcarweb.utils.EnumUtils;

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

    @Autowired
    PersonRest personRest;

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String getMainPage(Model model, @RequestParam(name = "part", required = false, defaultValue = "false") String part){

        return getTemplatePath("dashboard",part);
    }

    @RequestMapping(value = "/carSearch",method = RequestMethod.GET)
    public String getCarSearchView(Model model, @RequestParam(name = "part", required = false, defaultValue = "false") String part){
        List<CarModelDto> carModels = getCarModels();

        model.addAttribute("carModels",carModels);
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
            if(car.getCarImage() != null){
                carData.setCarImage(new String(car.getCarImage()));
            }
            if(car.getEngine() != null){
                carData.setEngine(car.getEngine());
            }
            if(car.getFuel() != null){
                carData.setFuel(car.getFuel());
            }
            if(car.getGearBox() != null){
                carData.setGearBox(EnumUtils.getGearBoxEnumString(car.getGearBox()));
            }
            if(car.getHorsePower() != null){
                carData.setHorsePower(car.getHorsePower());
            }


            carData.setId(car.getId());
            newCars.add(carData);
        }
        model.addAttribute("cars",newCars);
        model.addAttribute("user",getLoggedInPerson());
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
        carDto.setEngine(addCarData.getEngine());
        carDto.setFuel(addCarData.getFuel());
        carDto.setHorsePower(addCarData.getHorsePower());
        if(addCarData.getGearBox().equals("MANUAL")){
            carDto.setGearBox(GearBoxEnum.MANUAL);
        }else if (addCarData.getGearBox().equals("AUTOMATIC")){
            carDto.setGearBox(GearBoxEnum.AUTOMATIC);

        }
        byte[] image = addCarData.getCarImage().getBytes();

        carDto.setCarImage(image);
        CarDto addedCar = carRest.createCar(carDto);

        if(addedCar == null){
            return false;
        }
        return true;

    }

    @RequestMapping(value = "/carDetails/{carId}",method = RequestMethod.GET)
    public String getCarDetailsView(Model model,  @RequestParam(name = "part", required = false, defaultValue = "false") String part, @PathVariable("carId") Long carId){
        CarDto car = carRest.getCar(carId);
        if (car != null) {
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
            if(car.getCarImage() != null){
                carData.setCarImage(new String(car.getCarImage()));
            }
            if(car.getCarImage() != null){
                carData.setCarImage(new String(car.getCarImage()));
            }
            if(car.getEngine() != null){
                carData.setEngine(car.getEngine());
            }
            if(car.getFuel() != null){
                carData.setFuel(car.getFuel());
            }
            if(car.getGearBox() != null){
                carData.setGearBox(EnumUtils.getGearBoxEnumString(car.getGearBox()));
            }
            if(car.getHorsePower() != null){
                carData.setHorsePower(car.getHorsePower());
            }
            carData.setId(car.getId());
            PersonDto owner = personRest.getPerson(car.getOwnerId());
            model.addAttribute("owner",owner);
            model.addAttribute("car",carData);
        }
        return getTemplatePath("carDetails",part);
    }

    @RequestMapping(value = "/cars/{modelId}/{typeId}",method = RequestMethod.GET)
    @ResponseBody
    public List<CarData> getCarsByModelIdAndTypeId(@PathVariable("modelId") Long modelId,@PathVariable("typeId") Long typeId){
        List<CarDto> cars = carRest.getCarsByModelIdAndTypeId(modelId,typeId);
        List<CarData> newCars = new ArrayList<>();

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
            if(car.getCarImage() != null){
                carData.setCarImage(new String(car.getCarImage()));
            }
            if(car.getEngine() != null){
                carData.setEngine(car.getEngine());
            }
            if(car.getFuel() != null){
                carData.setFuel(car.getFuel());
            }
            if(car.getGearBox() != null){
                carData.setGearBox(EnumUtils.getGearBoxEnumString(car.getGearBox()));
            }
            if(car.getHorsePower() != null){
                carData.setHorsePower(car.getHorsePower());
            }


            carData.setId(car.getId());
            newCars.add(carData);
        }
        return newCars;
    }

    @RequestMapping(value = "/delete/car/{carId}",method = RequestMethod.GET)
    @ResponseBody
    public boolean deleteCar(@PathVariable("carId") Long carId){
        carRest.deleteCar(carId);
        return true;
    }

}
