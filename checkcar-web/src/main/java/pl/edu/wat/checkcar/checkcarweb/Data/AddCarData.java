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
public class AddCarData {
    private String modelId;
    private String typeId;
    private String course;
    private String productionYear;
    private String carImage;

}
