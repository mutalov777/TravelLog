package uz.mutalov.travellog.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import uz.mutalov.travellog.criteria.GenericCriteria;
import uz.mutalov.travellog.dto.log.DataSort;
import uz.mutalov.travellog.dto.log.LogCreateDto;
import uz.mutalov.travellog.dto.log.LogDto;
import uz.mutalov.travellog.dto.log.LogUpdateDto;
import uz.mutalov.travellog.dto.response.DataDto;
import uz.mutalov.travellog.service.log.LogService;

import javax.validation.Valid;
import java.util.List;

@RestController
public class LogController extends AbstractController<LogService> {

    public LogController(LogService service) {
        super(service);
    }

    @PreAuthorize(value = "hasAnyAuthority('ADMIN','USER')")
    @RequestMapping(value = PATH+"/log/create", method = RequestMethod.POST)
    public ResponseEntity<DataDto<Boolean>> create(@Valid @RequestBody LogCreateDto dto){

        return service.create(dto);
    }

    @PreAuthorize(value = "hasAnyAuthority('ADMIN','USER')")
    @RequestMapping(value = PATH+"/log/update", method = RequestMethod.PUT)
    public ResponseEntity<DataDto<Boolean>> update(@RequestBody LogUpdateDto dto){

        return service.update(dto);
    }

    @PreAuthorize(value = "hasAuthority('ADMIN')")
    @RequestMapping(value = PATH+"/log/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<DataDto<Boolean>> delete(@PathVariable Long id) {

        return service.delete(id);
    }

    @PreAuthorize(value = "hasAuthority('ADMIN')")
    @RequestMapping(value = PATH+"/log/getAll", method = RequestMethod.GET)
    public ResponseEntity<DataDto<List<LogDto>>> getAll(GenericCriteria criteria) {
        return service.getAll(criteria);
    }

    @PreAuthorize(value = "hasAuthority('ADMIN')")
    @RequestMapping(value = PATH+"/log/get", method = RequestMethod.GET)
    public ResponseEntity<DataDto<List<LogDto>>> get(DataSort sort) {
        return service.get(sort);
    }
}
