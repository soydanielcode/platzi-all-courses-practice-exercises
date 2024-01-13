package com.platzi.pizza.web.controller;

import com.platzi.pizza.persistence.entity.PizzaEntity;
import com.platzi.pizza.service.PizzaService;
import com.platzi.pizza.service.dto.UpdatePizzaDto;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pizzas")
public class PizzaController {
    private final PizzaService service;

    @Autowired
    public PizzaController(PizzaService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<Page<PizzaEntity>> getAll(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "8") int elements){
        return ResponseEntity.ok(service.getAll(page, elements));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PizzaEntity> get(@PathVariable int id){
        return ResponseEntity.ok(service.get(id).orElse(null));
    }

    @GetMapping("/available")
    public ResponseEntity<List<PizzaEntity>> getAvailable(){
        return ResponseEntity.ok(service.getAvailable());
    }

    @GetMapping("/availablePageSort")
    public ResponseEntity<Page<PizzaEntity>> getAvailablePageSort(@RequestParam(defaultValue = "0") int page,
                                                                  @RequestParam(defaultValue = "7") int elements,
                                                                  @RequestParam(defaultValue = "price") String properties,
                                                                  @RequestParam(defaultValue = "DESC") String direction){
        return ResponseEntity.ok(service.getAvailablePageSort(page, elements, properties, direction));
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<PizzaEntity> getName(@PathVariable String name){
        return ResponseEntity.ok(service.getName(name));
    }

    @GetMapping("/with/{ingredient}")
    public ResponseEntity<List<PizzaEntity>> getWith(@PathVariable String ingredient){
        return ResponseEntity.ok(service.getWith(ingredient));
    }

    @GetMapping("/without/{ingredient}")
    public ResponseEntity<List<PizzaEntity>> getWithout(@PathVariable String ingredient){
        return ResponseEntity.ok(service.getWithout(ingredient));
    }

    @GetMapping("/cheap/{price}")
    public ResponseEntity<List<PizzaEntity>> getCheapest(@PathVariable double price){
        return ResponseEntity.ok(service.getCheapest(price));
    }

    @PostMapping
    public ResponseEntity<PizzaEntity> add(@RequestBody PizzaEntity pizzaEntity){
        if(pizzaEntity.getIdPizza() == null || !service.existId(pizzaEntity.getIdPizza())){
            return ResponseEntity.ok(service.save(pizzaEntity));
        }
        return ResponseEntity.badRequest().build();
    }

    @PutMapping
    public ResponseEntity<PizzaEntity> update(@RequestBody PizzaEntity  pizzaEntity){
        if (pizzaEntity.getIdPizza() != null && service.existId(pizzaEntity.getIdPizza()) ) {
            return ResponseEntity.ok(service.save(pizzaEntity));
        }
        return ResponseEntity.badRequest().build();
    }

    @PutMapping("/price")
    public ResponseEntity<Void> updatePrice(@RequestBody UpdatePizzaDto pizzaDto){
        if (service.existId(pizzaDto.getIdPizza()) ) {
            service.updatePrice(pizzaDto);
            ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id){
        if (service.existId(id)) {
            service.delete(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().build();
    }

}
