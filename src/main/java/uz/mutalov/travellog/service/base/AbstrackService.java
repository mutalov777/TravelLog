package uz.mutalov.travellog.service.base;

import lombok.RequiredArgsConstructor;
import uz.mutalov.travellog.mapper.BaseMapper;
import uz.mutalov.travellog.repository.base.BaseRepository;

@RequiredArgsConstructor
public abstract class AbstrackService<M extends BaseMapper,R extends BaseRepository> {

    protected final M mapper;

    protected final R repository;

}
