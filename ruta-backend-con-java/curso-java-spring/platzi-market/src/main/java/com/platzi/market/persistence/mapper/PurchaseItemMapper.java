package com.platzi.market.persistence.mapper;

import com.platzi.market.domain.PurchaseItem;
import com.platzi.market.persistence.entity.ProductPurchaseEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {ProductMapper.class})
public interface PurchaseItemMapper {
    @Mappings({
            @Mapping(source = "id.idProduct", target = "productId"),
            @Mapping(source = "quantity", target = "quantity"),
            @Mapping(source = "total", target = "total"),
            @Mapping(source = "state", target = "state")
    })
    PurchaseItem toPurchaseItem(ProductPurchaseEntity purchaseEntity);
    List<PurchaseItem> toPurchaseItems(List<PurchaseItem> purchaseItems);

    @InheritInverseConfiguration()
    @Mappings({
            @Mapping(target = "purchaseEntity", ignore = true),
            @Mapping(target = "productEntity", ignore = true),
            @Mapping(target = "id.idPurchase", ignore = true),
    })
    ProductPurchaseEntity toProductPurchaseEntity(PurchaseItem purchaseItem);
}
