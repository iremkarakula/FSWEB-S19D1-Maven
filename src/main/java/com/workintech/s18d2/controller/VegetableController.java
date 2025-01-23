package com.workintech.s18d2.controller;


import com.workintech.s18d2.dto.VegetableResponse;
import com.workintech.s18d2.entity.Vegetable;
import com.workintech.s18d2.services.VegetableService;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vegetable")
public class VegetableController {
    private VegetableService vegetableService;

    public VegetableController(VegetableService vegetableService) {
        this.vegetableService = vegetableService;
    }

    @GetMapping
    public List<Vegetable> getByPriceAsc(){
        return vegetableService.getByPriceAsc();
    }
    @GetMapping("/{id}")
    public VegetableResponse getById(@Positive(message="id 0 dan küçük olamaz") @PathVariable("id") Long id){
        return new VegetableResponse("success", vegetableService.getById(id));
    }
    @GetMapping("/desc")
    public List<Vegetable> getByPriceDesc(){
        return vegetableService.getByPriceDesc();
    }

    @PostMapping
    public Vegetable save(@Validated @RequestBody Vegetable vegetable){
        return vegetableService.save(vegetable);
    }
    @GetMapping("/name/{name}")
    public List<Vegetable> searchByName(@Size(min=2, max=45, message="2 ile 45 arasında olmalıdır") @PathVariable String name){
        return vegetableService.searchByName(name);
    }

    @DeleteMapping("/{id}")
    public Vegetable delete(@NotNull @Positive @PathVariable("id") Long id){
        return vegetableService.delete(id);
    }
}
