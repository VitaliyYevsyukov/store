package com.example.store.controllers;

import com.example.store.dtos.StoreDto;
import com.example.store.services.StoreService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/v1/stores")
@AllArgsConstructor
public class StoreController {

    private final StoreService storeService;

    @GetMapping(value = "/{id}")
    //@RequestMapping(method = RequestMethod.GET, value = "/{id}")    // equals
    private StoreDto get(@PathVariable Long id){
        return storeService.getById(id);
    }

    @GetMapping
    public List<StoreDto> getAll(){
        return storeService.getAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public StoreDto post(@RequestBody StoreDto storeDto){
        return storeService.create(storeDto);
    }

    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public StoreDto put(
            @PathVariable Long id,
            @RequestBody StoreDto storeDto){
        return storeService.update(storeDto, id);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){
        storeService.delete(id);
    }

}
