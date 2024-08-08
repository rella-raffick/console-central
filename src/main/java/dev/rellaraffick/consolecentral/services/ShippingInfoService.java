package dev.rellaraffick.consolecentral.services;

import dev.rellaraffick.consolecentral.repositories.ShippingInfoRepository;

public class ShippingInfoService {
    private final ShippingInfoRepository shippingInfoRepository;

    public ShippingInfoService(ShippingInfoRepository shippingInfoRepository) {
        this.shippingInfoRepository = shippingInfoRepository;
    }
}
