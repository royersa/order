package com.javaacademy.amauryroyers.api.item;

import com.javaacademy.amauryroyers.service.item.ItemService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(path = {"/item"})
public class ItemController {
    private ItemService itemService;
    private ItemMapper itemMapper;

    @Inject
    public ItemController(ItemService itemService, ItemMapper itemMapper) {
        this.itemService = itemService;
        this.itemMapper = itemMapper;
    }

    @PostMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public ItemDTO registerItem(@RequestBody ItemDTO itemDTO){
        return itemMapper.toDTO(itemService.registerItem(itemMapper.toDomain(itemDTO)));
    }

    @PutMapping(path = "/{id}", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ItemDTO updateItem(@PathVariable String id, @RequestBody ItemDTO itemDTO){
        return itemMapper.toDTO(itemService.updateItem(id, itemMapper.toDomain(itemDTO)));
    }
}
