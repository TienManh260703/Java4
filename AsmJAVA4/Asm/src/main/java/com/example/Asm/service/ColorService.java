package com.example.Asm.service;

import com.example.Asm.convert.ConvertEntity;
import com.example.Asm.entity.Color;
import com.example.Asm.repository.ColorRepository;
import com.example.Asm.request.ColorRequest;
import com.example.Asm.response.ColorResponse;
import org.apache.commons.beanutils.BeanUtils;

import java.awt.*;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public class ColorService {
    private final ColorRepository repository = new ColorRepository();
    private final ConvertEntity convert = new ConvertEntity();

    public List<ColorResponse> getAll() throws InvocationTargetException, IllegalAccessException {
        List<ColorResponse> responses = new ArrayList<>();
        List<Color> result = repository.getAll();
        for (Color color : result) {
            ColorResponse c = new ColorResponse();
            BeanUtils.copyProperties(c, color);
            responses.add(c);
            System.out.println(c);
        }
        return responses;
    }

    public ColorResponse getOne(int id) throws InvocationTargetException, IllegalAccessException {
        ColorResponse response = new ColorResponse();
        Color color = repository.getOne(id);
        BeanUtils.copyProperties(response, color);
        return response;
    }

    public boolean create(ColorRequest request) throws InvocationTargetException, IllegalAccessException {
        Color color = new Color();
        BeanUtils.copyProperties(color, request);
        return repository.create(color);
    }

    public boolean update(ColorRequest request) throws InvocationTargetException, IllegalAccessException {
        Color color = new Color();
        BeanUtils.copyProperties(color, request);
        return repository.update(color);
    }

    public void updateColorStatusById(int id, int status) {
        repository.updateColorStatusById(id, status);
    }

    public boolean delete(int id) {
        Color color = Color.builder().id(id).build();
        return repository.delete(color);
    }
}
