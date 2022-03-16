package uz.mutalov.travellog.service.base;

import org.springframework.http.ResponseEntity;
import uz.mutalov.travellog.criteria.GenericCriteria;
import uz.mutalov.travellog.dto.BaseDto;
import uz.mutalov.travellog.dto.response.DataDto;

import java.util.List;

/**
 *
 * @param <D> dto for front
 * @param <C>criteria
 */
public interface GenericService<D extends BaseDto,C extends GenericCriteria> extends BaseService {

    ResponseEntity<DataDto<D>> get(Long id);

    ResponseEntity<DataDto<List<D>>> getAll(C criteria);
}
