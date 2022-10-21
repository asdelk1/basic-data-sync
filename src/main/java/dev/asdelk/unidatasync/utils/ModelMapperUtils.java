package dev.asdelk.unidatasync.utils;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ModelMapperUtils {

    private final ModelMapper mapper;

    public ModelMapperUtils(ModelMapper mapper) {
        this.mapper = mapper;
    }

    public <T, K> T map(K obj, Class<T> clazz) {
        return this.mapper.map(obj, clazz);
    }

    public <T, K> List<T> mapList(List<K> list, Class<T> clazz) {
        return list.stream().map(o -> this.mapper.map(o, clazz)).collect(Collectors.toList());
    }
}
