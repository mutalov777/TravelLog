package uz.mutalov.travellog.controller;

import lombok.RequiredArgsConstructor;
import uz.mutalov.travellog.service.base.BaseService;

@RequiredArgsConstructor
public abstract class AbstractController<S extends BaseService>{

    public final S service;

    protected final String API = "/api";

    protected final String VERSION = "/v1";
    
    protected final String PATH = API + VERSION;

}
