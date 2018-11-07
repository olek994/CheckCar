package pl.edu.wat.checkcar.checkcarweb.Controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Aleksander Małkowicz, Date: 03.09.2018
 * Copyright by Wojskowa Akademia Techniczna im. Jarosława Dąbrowskiego, Warszawa 2018
 */
@RestController
@Slf4j
public class MainController {

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String getMainPage(Model model){
        return "dashboard";
    }
}
