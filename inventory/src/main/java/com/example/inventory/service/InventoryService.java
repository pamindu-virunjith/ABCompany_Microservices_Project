package com.example.inventory.service;


import com.example.inventory.DTO.InventoryDTO;
import com.example.inventory.model.Inventory;
import com.example.inventory.repo.InventoryRepo;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional

public class InventoryService {
    @Autowired
    private InventoryRepo inventoryRepo;

    @Autowired
    private ModelMapper modelmapper;

    public List<InventoryDTO> getAllItems(){
        List<Inventory>itemList = inventoryRepo.findAll();
        return modelmapper.map(itemList, new TypeToken<List<InventoryDTO>>(){}.getType());
    }

    public InventoryDTO saveItem(InventoryDTO inventoryDTO){
        inventoryRepo.save(modelmapper.map(inventoryDTO, Inventory.class));
        return inventoryDTO;
    }

    public InventoryDTO updateItem(InventoryDTO inventoryDTO){
        inventoryRepo.save(modelmapper.map(inventoryDTO, Inventory.class));
        return inventoryDTO;
    }

    public String deleteItem(Integer itemId){
        inventoryRepo.deleteById(itemId);
        return "Item Deleted";
    }

    public InventoryDTO getItemById(Integer itemId){
        Inventory item = inventoryRepo.getItemById(itemId);
        return modelmapper.map(item, InventoryDTO.class);
    }
}
