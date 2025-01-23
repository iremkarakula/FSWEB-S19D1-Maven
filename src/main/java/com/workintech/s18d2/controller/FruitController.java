package com.workintech.s18d2.controller;

import com.workintech.s18d2.dto.FruitResponse;
import com.workintech.s18d2.entity.Fruit;
import com.workintech.s18d2.services.FruitService;
import com.workintech.s18d2.services.FruitServiceImpl;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/fruit")
public class FruitController {
    private final FruitService fruitService;

    @GetMapping
    public List<Fruit> getByPriceAsc(){
        return fruitService.getByPriceAsc();
    }
    @GetMapping("/{id}")
    public FruitResponse getById(@Positive(message="id 0 dan küçük olamaz") @PathVariable("id") Long id){
        return new FruitResponse("success", fruitService.getById(id));
    }
    @GetMapping("/desc")
    public List<Fruit> getByPriceDesc(){
        return fruitService.getByPriceDesc();
    }

    @PostMapping
    public Fruit save(@Validated @RequestBody Fruit fruit){
        return fruitService.save(fruit);
    }

    @GetMapping("/name/{name}")
    public List<Fruit> searchByName(@Size(min=2, max=45, message="2 ile 45 arasında olmalıdır") @PathVariable String name){
        return fruitService.searchByName(name);
    }

    @DeleteMapping("/{id}")
    public Fruit delete(@NotNull @Positive @PathVariable("id") Long id){
        return fruitService.delete(id);
    }
}
