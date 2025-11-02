package com.example.inventory.controller;

import com.example.inventory.DTO.InventoryDTO;
import com.example.inventory.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value="api/v1")

public class UserController {
    @Autowired
    private InventoryService inventoryService;

    @GetMapping("/getItems")
    public List<InventoryDTO> getItems() {
        return inventoryService.getAllItems();
    }

    @GetMapping("getItem/{itemId}")
    public  InventoryDTO getItemById(@PathVariable Integer itemId){
        return inventoryService.getItemById(itemId);
    }

    @PostMapping("/saveItem")
    public  InventoryDTO saveItem(@RequestBody InventoryDTO inventoryDTO){
        return inventoryService.saveItem(inventoryDTO);
    }

    @PutMapping("/updateItem")
    public InventoryDTO updateItem(@RequestBody InventoryDTO inventoryDTO){
        return  inventoryService.updateItem(inventoryDTO);
    }

    @DeleteMapping("/deleteItem/{itemId}")
    public String deleteItem(@PathVariable Integer itemId){
        return inventoryService.deleteItem(itemId);
    }
}
