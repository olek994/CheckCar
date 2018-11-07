package pl.edu.wat.checkcar.checkcarweb;

/**
 * Created by Aleksander Małkowicz, Date: 07.11.2018
 * Copyright by Wojskowa Akademia Techniczna im. Jarosława Dąbrowskiego, Warszawa 2018
 */
public class BaseController {


    protected String geTemplatePath(String templatePath,String part){
        return geTemplatePath(templatePath, Boolean.parseBoolean(part));
    }
    protected String geTemplatePath(String templatePath,boolean part){
        return templatePath + (part ? "::part":"");
    }
}
