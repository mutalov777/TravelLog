package uz.mutalov.travellog.dto.log;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.mutalov.travellog.dto.BaseDto;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LogCreateDto implements BaseDto {

    @NotNull
    private Integer firstOdometrvalue;

    @NotNull
    private String registrationNumber;

    @NotNull
    private String ownerName;

    @NotNull
    private Integer lastOdometrvalue;

    @NotNull
    private String description;

    @NotNull
    private String route;
}
