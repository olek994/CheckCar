package pl.edu.wat.checkcar.checkcarweb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import pl.edu.wat.checkcar.checkcardomain.dto.PersonDto;
import pl.edu.wat.checkcar.checkcardomain.rest.PersonRest;

/**
 * Created by Aleksander Małkowicz, Date: 07.11.2018
 * Copyright by Wojskowa Akademia Techniczna im. Jarosława Dąbrowskiego, Warszawa 2018
 */
public class BaseController {


    @Autowired
    PersonRest personRest;

    protected String getTemplatePath(String templatePath,String part){
        return getTemplatePath(templatePath, Boolean.parseBoolean(part));
    }
    protected String getTemplatePath(String templatePath,boolean part){
        return templatePath + (part ? "::part":"");
    }


    protected PersonDto getLoggedInPerson(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String userName = (String) auth.getPrincipal();
        if(userName == null){
             return null;
        }
        PersonDto personDto = personRest.getPersonByUserName(userName);
        return personDto;
    }
}
