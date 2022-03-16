package uz.mutalov.travellog.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.springframework.stereotype.Component;
import uz.mutalov.travellog.domain.Log;
import uz.mutalov.travellog.dto.log.LogCreateDto;
import uz.mutalov.travellog.dto.log.LogDto;
import uz.mutalov.travellog.dto.log.LogUpdateDto;

import java.util.List;

@Component
@Mapper( componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE )
public interface LogMapper extends BaseMapper {

    LogDto toDto(Log log);

    List<LogDto> toDto(List<Log> logdto);

    Log fromCreateDto(LogCreateDto logCreateDto);

    Log fromUpdateDto(LogUpdateDto dto,@MappingTarget Log log);
}
