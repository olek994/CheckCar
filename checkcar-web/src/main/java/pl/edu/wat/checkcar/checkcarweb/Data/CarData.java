package pl.edu.wat.checkcar.checkcarweb.Data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by Aleksander on 25.11.2018.
 * Wojskowa Akademia Techniczna im. Jarosława Dąbrowskiego, Warszawa 2017r.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CarData {
    private Long id;
    private String model;
    private String type;
    private Long course;
    private Long productionYear;
}
