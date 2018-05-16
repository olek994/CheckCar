package pl.edu.wat.checkcar.checkcarengine.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.edu.wat.checkcar.checkcardomain.dto.TestDto;

/**
 * Created by Aleksander Małkowicz, Date: 16.05.2018
 * Copyright by Wojskowa Akademia Techniczna im. Jarosława Dąbrowskiego, Warszawa 2018
 */

public interface TestService {

    TestDto createTest(TestDto dto);

    TestDto getTest(Long id);
}
