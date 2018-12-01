package pl.edu.wat.checkcar.checkcarweb.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.edu.wat.checkcar.checkcardomain.GearBoxEnum;

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
    private String carImage;
    private String engine;
    private String horsePower;
    private String fuel;
    private String gearBox;
    private boolean isInInteresting;
}
