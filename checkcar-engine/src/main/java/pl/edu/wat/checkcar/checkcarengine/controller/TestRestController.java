package pl.edu.wat.checkcar.checkcarengine.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pl.edu.wat.checkcar.checkcardomain.dto.TestDto;
import pl.edu.wat.checkcar.checkcardomain.rest.TestRest;
import pl.edu.wat.checkcar.checkcarengine.service.TestService;

/**
 * Created by Aleksander Małkowicz, Date: 16.05.2018
 * Copyright by Wojskowa Akademia Techniczna im. Jarosława Dąbrowskiego, Warszawa 2018
 */
@RestController
public class TestRestController implements TestRest {

    @Autowired
    TestService testService;


    @Override
    public TestDto createTest(@RequestBody TestDto testDto) {
        return testService.createTest(testDto);
    }

    @Override
    public TestDto getTest(@PathVariable("testId") Long testId) {
        return testService.getTest(testId);
    }
}
