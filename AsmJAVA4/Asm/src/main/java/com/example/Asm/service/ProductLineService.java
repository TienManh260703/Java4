package com.example.Asm.service;

import com.example.Asm.convert.ConvertEntity;
import com.example.Asm.entity.Product;
import com.example.Asm.entity.ProductLine;
import com.example.Asm.repository.ProductLineRepository;
import com.example.Asm.repository.ProductRepository;
import com.example.Asm.request.ProducerRequest;
import com.example.Asm.request.ProductLineRequest;
import com.example.Asm.response.ProductLineResponse;
import com.example.Asm.response.ProductResponse;
import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public class ProductLineService {
    private final ProductLineRepository repository = new ProductLineRepository();
    private final ConvertEntity convert = new ConvertEntity();

    public List<ProductLineResponse> getAll() throws InvocationTargetException, IllegalAccessException {
        List<ProductLineResponse> responses = new ArrayList<>();
        List<ProductLine> result = repository.getAll();
        for (ProductLine productLine : result) {
            ProductResponse p = new ProductResponse();
            responses.add(convert.convertProductLineToProductLineResponse(productLine));
        }
        return responses;
    }

    public ProductLineResponse getOne(int id) throws InvocationTargetException, IllegalAccessException {
        ProductLineResponse response = new ProductLineResponse();
        ProductLine productLine = repository.getOne(id);
//        BeanUtils.copyProperties(response, color);
        return convert.convertProductLineToProductLineResponse(productLine);
    }

    public boolean create(ProductLineRequest request) throws InvocationTargetException, IllegalAccessException {
        ProductLine productLine = new ProductLine();
        BeanUtils.copyProperties(productLine, request);
        return repository.create(productLine);
    }

    public boolean update(ProductLineRequest request) throws InvocationTargetException, IllegalAccessException {
        ProductLine productLine = new ProductLine();
        BeanUtils.copyProperties(productLine, request);
        return repository.update(productLine);
    }

    public void updateColorStatusById(int id, int status) {
        repository.updateColorStatusById(id, status);
    }

    public boolean delete(int id) {
        ProductLine productLine = ProductLine.builder().id(id).build();
        return repository.delete(productLine);
    }
}
