package com.example.Asm.service;

import com.example.Asm.convert.ConvertEntity;
import com.example.Asm.entity.ProductDetail;
import com.example.Asm.repository.ProductDetailRepository;
import com.example.Asm.request.ProductDetailRequest;
import com.example.Asm.response.ProductDetailResponse;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public class ProductDetailService {

    private final ProductDetailRepository repository = new ProductDetailRepository();
    private final ConvertEntity convert = new ConvertEntity();

    public List<ProductDetailResponse> getAll() {
        List<ProductDetailResponse> result = new ArrayList<>();
        List<ProductDetail> response = repository.getAll();
        for (ProductDetail detail : response) {
            result.add(convert.convertProductDetailToProductResponse(detail));
        }
        return result;
    }

    public ProductDetailResponse getOne(int id) {
        return convert.convertProductDetailToProductResponse(repository.getOne(id));
    }

    public boolean create(ProductDetailRequest request) throws InvocationTargetException, IllegalAccessException {
        ProductDetail productDetail = convert.convertProductDetailRequestToProductDetail(request);
        return repository.create(productDetail);
    }

    public boolean update(ProductDetailRequest request) throws InvocationTargetException, IllegalAccessException {
        ProductDetail productDetail = convert.convertProductDetailRequestToProductDetail(request);
        return repository.update(productDetail);
    }

    public void updateQuantityById(int id, int status) {
        repository.updateQuantityById(id , status);
    }

    public boolean delete(int id) throws InvocationTargetException, IllegalAccessException {
        ProductDetail productDetail = ProductDetail.builder().id(id).build();
        return repository.delete(productDetail);
    }


    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        ProductDetailService service = new ProductDetailService();
       service.delete(7);
    }
}
