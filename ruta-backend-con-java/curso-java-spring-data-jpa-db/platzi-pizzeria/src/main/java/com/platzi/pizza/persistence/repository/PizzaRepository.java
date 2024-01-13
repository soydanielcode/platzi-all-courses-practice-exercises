package com.platzi.pizza.persistence.repository;

import com.platzi.pizza.persistence.entity.PizzaEntity;
import com.platzi.pizza.service.dto.UpdatePizzaDto;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface PizzaRepository extends ListCrudRepository<PizzaEntity, Integer> {
    List<PizzaEntity> findAllByAvailableTrueOrderByPrice();
    Optional<PizzaEntity> findFirstByAvailableTrueAndNameIgnoreCase(String name);
    List<PizzaEntity> findAllByAvailableTrueAndDescriptionContainsIgnoreCase(String description);
    List<PizzaEntity> findAllByAvailableTrueAndDescriptionNotContainsIgnoreCase(String description);
    List<PizzaEntity> findTop4ByAvailableTrueAndPriceLessThanEqualOrderByPriceAsc(double price);

    @Query(value =
            "UPDATE PIZZA SET PRICE = :#{#pizzaDto.price} WHERE ID_PIZZA = :#{#pizzaDto.idPizza}", nativeQuery = true)
    @Modifying
    void updatePrice(@Param("pizzaDto")UpdatePizzaDto pizzaDto);
}
