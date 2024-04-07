package com.example.Asm.service;

import com.example.Asm.convert.ConvertEntity;
import com.example.Asm.entity.Producer;
import com.example.Asm.repository.ProducerRepository;
import com.example.Asm.request.ProducerRequest;
import com.example.Asm.response.ProducerResponse;
import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public class ProducerService {

    private final ProducerRepository repository = new ProducerRepository();
    private final ConvertEntity convert = new ConvertEntity();

    public List<ProducerResponse> getAll() throws InvocationTargetException, IllegalAccessException {
        List<ProducerResponse> responses = new ArrayList<>();
        List<Producer> result = repository.getAll();
        for (Producer producer : result) {
            ProducerResponse p = new ProducerResponse();
            responses.add(convert.convertProductToProductResponse(producer));
        }
        return responses;
    }

    public ProducerResponse getOne(int id) throws InvocationTargetException, IllegalAccessException {
        ProducerResponse response = new ProducerResponse();
        Producer producer = repository.getOne(id);
//        BeanUtils.copyProperties(response, color);
        return convert.convertProductToProductResponse(producer);
    }

    public boolean create(ProducerRequest request) throws InvocationTargetException, IllegalAccessException {
        Producer producer = new Producer();
        BeanUtils.copyProperties(producer, request);
        return repository.create(producer);
    }

    public boolean update(ProducerRequest request) throws InvocationTargetException, IllegalAccessException {
        Producer producer = new Producer();
        BeanUtils.copyProperties(producer, request);
        return repository.update(producer);
    }

    public void updateColorStatusById(int id, int status) {
        repository.updateColorStatusById(id, status);
    }

    public boolean delete(int id) {
        Producer product = Producer.builder().id(id).build();
        return repository.delete(product);
    }
}
