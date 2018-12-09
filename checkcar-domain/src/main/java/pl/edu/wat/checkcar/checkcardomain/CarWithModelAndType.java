package pl.edu.wat.checkcar.checkcardomain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by Aleksander on 09.12.2018.
 * Wojskowa Akademia Techniczna im. Jarosława Dąbrowskiego, Warszawa 2017r.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CarWithModelAndType {
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
    private Long costForRide;
    private Long ownerId;
}
