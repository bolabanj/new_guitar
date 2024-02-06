package edu.iu.bolabanj.c322spring2024homework2.controllers;

import edu.iu.bolabanj.c322spring2024homework2.enums.Builder;
import edu.iu.bolabanj.c322spring2024homework2.enums.Type;
import edu.iu.bolabanj.c322spring2024homework2.enums.Wood;
import edu.iu.bolabanj.c322spring2024homework2.model.Guitar;
import edu.iu.bolabanj.c322spring2024homework2.respository.InventoryRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class InventoryController {
    private InventoryRepository inventoryRepository;
    @GetMapping("/search")
    public List<Guitar> search(String serialNumber, double price, Builder builder, String model, Type type, Wood backWood, Wood topWood) throws Exception{
        try{
            Guitar searchGuitar = new Guitar(serialNumber, price, builder, model, type, backWood, topWood);
            return inventoryRepository.search(searchGuitar);
        }
        catch(Exception e){
            return null;
        }


    }

    @PostMapping("/add")
    public void add(String serialNumber, double price,  Builder builder, String model, Type type, Wood backWood, Wood topWood){
        try{
            Guitar newGuitar = new Guitar(serialNumber, price, builder, model, type, backWood, topWood);
            inventoryRepository.addGuitar(newGuitar);
        }
        catch(Exception e){
            return;
        }

    }
    @GetMapping("/find/{serialNumber}")
    public Guitar find (@PathVariable String serialNumber){
        try{
            return inventoryRepository.getGuitar(serialNumber);
        }
        catch(Exception e ){
            return null;
        }
    }


}
