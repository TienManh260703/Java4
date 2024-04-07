package com.example.Asm.service;

import com.example.Asm.convert.ConvertEntity;
import com.example.Asm.entity.Color;
import com.example.Asm.entity.Position;
import com.example.Asm.repository.ColorRepository;
import com.example.Asm.repository.PositionRepository;
import com.example.Asm.request.ColorRequest;
import com.example.Asm.request.PositionRequest;
import com.example.Asm.response.ColorResponse;
import com.example.Asm.response.PositionResponse;
import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public class PositionService {
    private final PositionRepository repository = new PositionRepository();
    private final ConvertEntity convert = new ConvertEntity();

    public List<PositionResponse> getAll() throws InvocationTargetException, IllegalAccessException {
        List<PositionResponse> responses = new ArrayList<>();
        List<Position> result = repository.getAll();
        for (Position position : result) {
            PositionResponse p = new PositionResponse();
            BeanUtils.copyProperties(p, position);
            responses.add(p);
        }
        return responses;
    }

    public PositionResponse getOne(int id) throws InvocationTargetException, IllegalAccessException {
        PositionResponse response = new PositionResponse();
        Position position = repository.getOne(id);
        BeanUtils.copyProperties(response, position);
        return response;
    }

    public boolean create(PositionRequest request) throws InvocationTargetException, IllegalAccessException {
        Position position = new Position();
        BeanUtils.copyProperties(position, request);
        return repository.create(position);
    }

    public boolean update(PositionRequest request) throws InvocationTargetException, IllegalAccessException {
        Position position = new Position();
        BeanUtils.copyProperties(position, request);
        return repository.update(position);
    }

    public void updatePositionStatusById(int id, int status) {
        repository.updatePositionStatusById(id, status);
    }

    public boolean delete(int id) {
        Position position = Position.builder().id(id).build();
        return repository.delete(position);
    }
}
