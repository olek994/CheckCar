package pl.edu.wat.checkcar.checkcarengine.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.wat.checkcar.checkcarengine.provider.TestProvider;
import pl.edu.wat.checkcar.checkcarengine.service.TestService;

/**
 * Created by Aleksander Małkowicz, Date: 16.05.2018
 * Copyright by Wojskowa Akademia Techniczna im. Jarosława Dąbrowskiego, Warszawa 2018
 */
@Service
public class TestServiceImpl implements TestService {

    @Autowired
    TestProvider testProvider;

    @Override
    public String getTestValue() {
        return testProvider.getTestValue();
    }
}
