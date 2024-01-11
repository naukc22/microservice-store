package ru.naukc.inventoryservice.service;


import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.naukc.inventoryservice.dto.InventoryResponse;
import ru.naukc.inventoryservice.repository.InventoryRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class InventoryService {

    private final InventoryRepository inventoryRepository;

    @Transactional(readOnly = true)
    @SneakyThrows
    public List<InventoryResponse> isInStock(List<String> skuCode) {
        return inventoryRepository.findBySkuCodeIn(skuCode).stream()
                .map(inventory ->
                        InventoryResponse.builder()
                                .skuCode(inventory.getSkuCode())
                                .isInStock(inventory.getQuantity() > 0)    // здесь сделать проверку не на больше нуля а на количество требуемого товара
                                .build()                                   // и сделать уменьшение количество товара на складе если все позиции в наличии
                ).toList();
    }
}
