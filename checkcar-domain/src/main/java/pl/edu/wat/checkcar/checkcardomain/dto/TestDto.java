package pl.edu.wat.checkcar.checkcardomain.dto;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import pl.edu.wat.checkcar.checkcardomain.base.BaseDto;

/**
 * Created by Aleksander Małkowicz, Date: 16.05.2018
 * Copyright by Wojskowa Akademia Techniczna im. Jarosława Dąbrowskiego, Warszawa 2018
 */
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
public class TestDto extends BaseDto<Long> {

    private Long id;
    private String testString;

    @Builder
    public TestDto(Long id, String testString){
        super(id);
        this.testString = testString;
    }
}
