package uz.mutalov.travellog.dto.log;

import lombok.Getter;
import lombok.Setter;
import uz.mutalov.travellog.dto.BaseDto;

@Getter
@Setter
public class LogUpdateDto implements BaseDto {

    private Long id;

    private Integer firstOdometrvalue;

    private Integer lastOdometrvalue;

    private String description;

    private String registrationNumber;

    private String ownerName;

    private String route;

    public LogUpdateDto(Long id, Integer firstOdometrvalue, Integer lastOdometrvalue, String description, String route) {
       this.id = id;
        this.firstOdometrvalue = firstOdometrvalue;
        this.lastOdometrvalue = lastOdometrvalue;
        this.description = description;
        this.route = route;
    }
}
