package uz.mutalov.travellog.service.log;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import uz.mutalov.travellog.criteria.GenericCriteria;
import uz.mutalov.travellog.domain.Log;
import uz.mutalov.travellog.dto.log.DataSort;
import uz.mutalov.travellog.dto.log.LogCreateDto;
import uz.mutalov.travellog.dto.log.LogDto;
import uz.mutalov.travellog.dto.log.LogUpdateDto;
import uz.mutalov.travellog.dto.response.DataDto;
import uz.mutalov.travellog.mapper.LogMapper;
import uz.mutalov.travellog.repository.LogRepository;
import uz.mutalov.travellog.service.base.AbstrackService;
import uz.mutalov.travellog.service.base.GenericCrudService;
import uz.mutalov.travellog.service.base.GenericService;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class LogService extends AbstrackService<LogMapper, LogRepository>
        implements GenericService<LogDto, GenericCriteria>,
        GenericCrudService<LogCreateDto, LogUpdateDto> {

    @Autowired
    public LogService(LogMapper mapper, LogRepository repository) {
        super(mapper, repository);
    }

    @Override
    public ResponseEntity<DataDto<Boolean>> create(LogCreateDto createDto) {
        Log log = mapper.fromCreateDto(createDto);
        repository.save(log);
        return new ResponseEntity<>(new DataDto<>(true), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<DataDto<Boolean>> update(LogUpdateDto createDto) {
        Optional<Log> optionalLog = repository.findByIdAndDeletedFalse(createDto.getId());
        if (optionalLog.isPresent()) {
            Log newLog = mapper.fromUpdateDto(createDto, optionalLog.get());
            repository.save(newLog);
        }
        return new ResponseEntity<>(new DataDto<>(true), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<DataDto<Boolean>> delete(Long id) {
        Optional<Log> optionalLog = repository.findByIdAndDeletedFalse(id);
        if (optionalLog.isPresent()) {
            Log log = optionalLog.get();
            log.setDeleted(true);
            repository.save(log);
        }
        return new ResponseEntity<>(new DataDto<>(true), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<DataDto<LogDto>> get(Long id) {
        Optional<Log> byIdAndByDeleted = repository.findByIdAndDeletedFalse(id);
        if (byIdAndByDeleted.isPresent()) {
            Log log = byIdAndByDeleted.get();
            LogDto logDto = mapper.toDto(log);
            return new ResponseEntity<>(new DataDto<>(logDto), HttpStatus.OK);
        }
        return new ResponseEntity<>(new DataDto<>(false), HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity<DataDto<List<LogDto>>> getAll(GenericCriteria criteria) {
        PageRequest request = PageRequest.of(criteria.getPage(), criteria.getSize(), Sort.by("id"));
        List<Log> logs = repository.findAllByDeletedFalse(request).get().toList();
        if (!logs.isEmpty()) {
            List<LogDto> logDtos = mapper.toDto(logs);
            return new ResponseEntity<>(new DataDto<>(logDtos), HttpStatus.OK);
        } else
            return new ResponseEntity<>(new DataDto<>(false), HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<DataDto<List<LogDto>>> get(DataSort sort) {
        if (Objects.nonNull(sort.getFirstDate()) || Objects.nonNull(sort.getLastDate())) {
            List<Log> log = repository.findByDateAndDeletedFalse(sort.getFirstDate(), sort.getLastDate());
            if (!log.isEmpty()) {
                List<LogDto> logDto = mapper.toDto(log);
                return new ResponseEntity<>(new DataDto<>(logDto), HttpStatus.OK);
            }
        } else if (Objects.nonNull(sort.getNumOrName())) {
            List<Log> log = repository.findByRegistrationNumberOrOwnerNameAndDeletedFalse(sort.getNumOrName());
            if (!log.isEmpty()) {
                List<LogDto> logDto = mapper.toDto(log);
                return new ResponseEntity<>(new DataDto<>(logDto), HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(new DataDto<>(false), HttpStatus.NOT_FOUND);
    }

}
