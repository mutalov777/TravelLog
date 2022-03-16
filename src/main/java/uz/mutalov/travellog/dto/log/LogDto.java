package uz.mutalov.travellog.dto.log;

import lombok.AllArgsConstructor;
import lombok.Data;
import uz.mutalov.travellog.dto.BaseDto;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class LogDto implements BaseDto {

    private Long id;

    private LocalDate date;

    private String ownerName;

    private String registrationNumber;

    private Integer firstOdometrvalue;

    private Integer lastOdometrvalue;

    private String description;

    private String route;

}
