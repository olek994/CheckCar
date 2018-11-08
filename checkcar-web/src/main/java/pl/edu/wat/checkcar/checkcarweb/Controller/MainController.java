package pl.edu.wat.checkcar.checkcarweb.Controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.edu.wat.checkcar.checkcarweb.BaseController;

/**
 * Created by Aleksander Małkowicz, Date: 03.09.2018
 * Copyright by Wojskowa Akademia Techniczna im. Jarosława Dąbrowskiego, Warszawa 2018
 */
@Controller
@Slf4j
public class MainController extends BaseController {

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
}
