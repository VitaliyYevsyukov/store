package com.example.store.controllers;

import com.example.store.dtos.GoodsDto;
import com.example.store.dtos.StoreDto;
import com.example.store.services.GoodsService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/v1/goods")
@AllArgsConstructor
public class GoodsController {

    private final GoodsService goodsService;

    @GetMapping(value = "/{id}")
    public GoodsDto get(@PathVariable Long id){
        return goodsService.getById(id);
    }

    @GetMapping
    public List<GoodsDto> getAll(){
        return goodsService.getAll();
    }

    @PostMapping(value = "/{id}/goods")
    @ResponseStatus(HttpStatus.CREATED)
    public GoodsDto post(@RequestBody GoodsDto goodsDto, @PathVariable Long id){
        return goodsService.create(goodsDto, id);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){
        goodsService.delete(id);
    }

    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public GoodsDto put(@PathVariable Long id,
                        @RequestBody GoodsDto goodsDto){
        return goodsService.update(goodsDto, id);
    }

}
