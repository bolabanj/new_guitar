package edu.iu.bolabanj.c322spring2024homework2.controllers;

import edu.iu.bolabanj.c322spring2024homework2.enums.Builder;
import edu.iu.bolabanj.c322spring2024homework2.enums.Type;
import edu.iu.bolabanj.c322spring2024homework2.enums.Wood;
import edu.iu.bolabanj.c322spring2024homework2.model.Guitar;
import edu.iu.bolabanj.c322spring2024homework2.repository.InventoryRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/inventory")
public class InventoryController {
    private InventoryRepository inventoryRepository = new InventoryRepository();
    @GetMapping("/search")
    public List<Guitar> search(@RequestParam Builder builder,@RequestParam String model,@RequestParam Type type,@RequestParam Wood backWood,@RequestParam Wood topWood) throws Exception{

        try{
            Guitar searchGuitar = new Guitar("00", 0, builder, model, type, backWood, topWood);
            return inventoryRepository.search(searchGuitar);
        }
        catch(Exception e){
            return null;
        }


    }

    @PostMapping("/add")



    public boolean add(@RequestBody Guitar guitar){

        try{
            Guitar newGuitar = new Guitar(guitar.getSerialNumber(), guitar.getPrice(), guitar.getBuilder(), guitar.getModel(), guitar.getType(), guitar.getBackWood(), guitar.getTopWood());
            inventoryRepository.addGuitar(newGuitar);
            return true;
        }
        catch(Exception e){
            return false;
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
