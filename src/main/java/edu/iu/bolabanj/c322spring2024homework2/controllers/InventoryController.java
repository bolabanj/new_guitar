package edu.iu.bolabanj.c322spring2024homework2.controllers;

import edu.iu.bolabanj.c322spring2024homework2.model.Guitar;
import edu.iu.bolabanj.c322spring2024homework2.respository.InventoryRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/inventory")
public class InventoryController {
    private InventoryRepository inventoryRepository;
    @GetMapping("/search")
    public List<Guitar> search(@RequestParam String serialNumber,@RequestParam double price, @RequestParam String builder,@RequestParam String model, @RequestParam String type,@RequestParam String backWood,@RequestParam String topWood) throws Exception{
        try{
            Guitar searchGuitar = new Guitar(serialNumber, price, builder, model, type, backWood, topWood);
            return inventoryRepository.search(searchGuitar);
        }
        catch(Exception e){
            return null;
        }


    }

    @PostMapping("/add")
    public void add(@RequestBody String serialNumber,@RequestBody double price, @RequestBody String builder,@RequestBody String model,@RequestBody String type,@RequestBody String backWood,@RequestBody String topWood){
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
