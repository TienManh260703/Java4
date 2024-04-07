package com.example.Asm.service;

import com.example.Asm.convert.ConvertEntity;
import com.example.Asm.entity.Product;
import com.example.Asm.repository.ProductRepository;
import com.example.Asm.request.ProducerRequest;
import com.example.Asm.request.ProductRequet;
import com.example.Asm.response.ProductResponse;
import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public class ProductService {
    private final ProductRepository repository = new ProductRepository();
    private final ConvertEntity convert = new ConvertEntity();

    public List<ProductResponse> getAll() throws InvocationTargetException, IllegalAccessException {
        List<ProductResponse> responses = new ArrayList<>();
        List<Product> result = repository.getAll();
        for (Product product : result) {
            ProductResponse p = new ProductResponse();
            responses.add(convert.convertProductToProductResponse(product));
        }
        return responses;
    }

    public ProductResponse getOne(int id) throws InvocationTargetException, IllegalAccessException {
        ProductResponse response = new ProductResponse();
        Product product = repository.getOne(id);
//        BeanUtils.copyProperties(response, color);
        return convert.convertProductToProductResponse(product);
    }

    public boolean create(ProductRequet request) throws InvocationTargetException, IllegalAccessException {
        Product product = new Product();
        BeanUtils.copyProperties(product, request);
        return repository.create(product);
    }

    public boolean update(ProductRequet request) throws InvocationTargetException, IllegalAccessException {
        Product product = new Product();
        BeanUtils.copyProperties(product, request);
        return repository.update(product);
    }

    public void updateColorStatusById(int id, int status) {
        repository.updateColorStatusById(id, status);
    }

    public boolean delete(int id) {
        Product product = Product.builder().id(id).build();
        return repository.delete(product);
    }
}
