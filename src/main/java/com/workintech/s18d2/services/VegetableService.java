package com.workintech.s18d2.services;

import com.workintech.s18d2.entity.Vegetable;

import java.util.List;

public interface VegetableService {


    List<Vegetable> getByPriceDesc();


    List<Vegetable> getByPriceAsc();


    List<Vegetable> searchByName(String name);

    Vegetable getById(Long id);

    Vegetable delete(Long id);

    Vegetable save(Vegetable vegetable);

}
