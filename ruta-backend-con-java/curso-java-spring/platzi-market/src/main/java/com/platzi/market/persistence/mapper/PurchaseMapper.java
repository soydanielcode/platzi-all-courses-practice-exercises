package com.platzi.market.persistence.mapper;

import com.platzi.market.domain.Purchase;
import com.platzi.market.persistence.entity.PurchaseEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PurchaseMapper {
    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "idClient", target = "clientId"),
            @Mapping(source = "date", target = "date"),
            @Mapping(source = "paymentMeans", target = "paymentMethod"),
            @Mapping(source = "comment", target = "comment"),
            @Mapping(source = "state", target = "state"),
            @Mapping(source = "products", target = "items"),
    })
    Purchase toPurchase(PurchaseEntity purchaseEntity);
    List<Purchase> toPurchases(List<PurchaseEntity> purchaseEntities);

    @InheritInverseConfiguration
    @Mapping(target = "clientEntity", ignore = true)
    PurchaseEntity toPurchaseEntity(Purchase purchase);
}
