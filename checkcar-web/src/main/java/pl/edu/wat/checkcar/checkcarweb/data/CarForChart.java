package pl.edu.wat.checkcar.checkcarweb.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by Aleksander on 10.12.2018.
 * Wojskowa Akademia Techniczna im. Jarosława Dąbrowskiego, Warszawa 2017r.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CarForChart {
    private Long amount;
    private String model;
}
