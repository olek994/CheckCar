package pl.edu.wat.checkcar.checkcarweb.Controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.edu.wat.checkcar.checkcardomain.dto.CarDto;
import pl.edu.wat.checkcar.checkcardomain.dto.PersonDto;
import pl.edu.wat.checkcar.checkcardomain.rest.CarRest;
import pl.edu.wat.checkcar.checkcarweb.BaseController;

import java.security.Principal;
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


    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String getMainPage(Model model, @RequestParam(name = "part", required = false, defaultValue = "false") String part){

        model.addAttribute("string","JAKIS TEKST");
        return geTemplatePath("dashboard",part);
    }

    @RequestMapping(value = "/carSearch",method = RequestMethod.GET)
    public String getCarSearchView(Model model, @RequestParam(name = "part", required = false, defaultValue = "false") String part){

        model.addAttribute("string","Car SEARCH");
        return geTemplatePath("carSearch",part);
    }

    @RequestMapping(value = "/myAccount",method = RequestMethod.GET)
    public String getMyAccountView(Model model, @RequestParam(name = "part", required = false, defaultValue = "false") String part){
        List<CarDto> cars = carRest.getCarOfOwner(getLoggedInPerson().getId());
        return geTemplatePath("myAccount",part);
    }
}
