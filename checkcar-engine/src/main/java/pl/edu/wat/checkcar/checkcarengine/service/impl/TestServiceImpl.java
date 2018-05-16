package pl.edu.wat.checkcar.checkcarengine.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.wat.checkcar.checkcardomain.dto.TestDto;
import pl.edu.wat.checkcar.checkcarengine.provider.TestProvider;
import pl.edu.wat.checkcar.checkcarengine.service.TestService;

/**
 * Created by Aleksander Małkowicz, Date: 16.05.2018
 * Copyright by Wojskowa Akademia Techniczna im. Jarosława Dąbrowskiego, Warszawa 2018
 */
@Service
@Slf4j
public class TestServiceImpl implements TestService {

    @Autowired
    TestProvider testProvider;

    @Override
    public TestDto createTest(TestDto dto) {
        return testProvider.createTest(dto);
    }

    @Override
    public TestDto getTest(Long id) {
        return testProvider.getById(id);
    }
}
