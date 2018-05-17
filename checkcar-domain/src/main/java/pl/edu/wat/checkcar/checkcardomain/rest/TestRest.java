package pl.edu.wat.checkcar.checkcardomain.rest;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.edu.wat.checkcar.checkcardomain.dto.TestDto;

/**
 * Created by Aleksander Małkowicz, Date: 17.05.2018
 * Copyright by Wojskowa Akademia Techniczna im. Jarosława Dąbrowskiego, Warszawa 2018
 */
public interface TestRest {

    @RequestMapping(value = "/test/", method = RequestMethod.POST)
    TestDto createTest(@RequestBody TestDto testDto);


    @RequestMapping(value = "/test/{testId}",method = RequestMethod.GET)
    TestDto getTest(@PathVariable("testId") Long testId);
}
