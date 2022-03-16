package uz.mutalov.travellog.service.base;

import org.springframework.http.ResponseEntity;
import uz.mutalov.travellog.dto.BaseDto;
import uz.mutalov.travellog.dto.response.DataDto;

/**
 *
 * @param <CD> create dto
 * @param <UD>update dto
 */
public interface GenericCrudService<CD extends BaseDto,UD extends BaseDto>{

    ResponseEntity<DataDto<Boolean>> create(CD createDto);

    ResponseEntity<DataDto<Boolean>> update(UD createDto);

    ResponseEntity<DataDto<Boolean>> delete(Long id);

}
