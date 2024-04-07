package com.example.Asm.service;

import com.example.Asm.convert.ConvertEntity;
import com.example.Asm.entity.Shop;
import com.example.Asm.repository.ShopRepository;
import com.example.Asm.request.ShopRequest;
import com.example.Asm.response.ShopResponse;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public class ShopService {
    private final ShopRepository repository = new ShopRepository();
    private final ConvertEntity convert = new ConvertEntity();

    public List<ShopResponse> getAll() {
        List<ShopResponse> responses = new ArrayList<>();
        List<Shop> shops = repository.getAll();
        for (Shop shop : shops) {
            responses.add(convert.convertShopToShopResponse(shop));
        }
        return responses;
    }

    public ShopResponse getOne(int id) {
        System.out.println(repository.getOne(id) );
        return convert.convertShopToShopResponse(repository.getOne(id));
    }

    public void create(ShopRequest request) throws InvocationTargetException, IllegalAccessException {
        repository.create(convert.convertShopRequestToShop(request));
    }

    public void update(ShopRequest request) throws InvocationTargetException, IllegalAccessException {
        repository.update(convert.convertShopRequestToShop(request));
    }

    public void delete(int id) throws InvocationTargetException, IllegalAccessException {
        repository.delete(Shop.builder().id(id).build());
    }
}
