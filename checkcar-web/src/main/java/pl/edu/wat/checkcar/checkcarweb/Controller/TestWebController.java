package pl.edu.wat.checkcar.checkcarweb.Controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.edu.wat.checkcar.checkcardomain.dto.TestDto;
import pl.edu.wat.checkcar.checkcardomain.rest.TestRest;

/**
 * Created by Aleksander Małkowicz, Date: 16.05.2018
 * Copyright by Wojskowa Akademia Techniczna im. Jarosława Dąbrowskiego, Warszawa 2018
 */
@Controller
@RequestMapping(value = "/test")
@Slf4j
public class TestWebController {

    @Autowired
    TestRest testRest;

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String getTestPage(Model model){
        TestDto testDto = testRest.getTest(1L);

        if (testDto != null) {
            model.addAttribute("testString",testDto.getTestString());
        }

        return "helloWorld";
    }
}
