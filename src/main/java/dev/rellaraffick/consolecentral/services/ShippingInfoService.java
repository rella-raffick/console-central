package dev.rellaraffick.consolecentral.services;

import dev.rellaraffick.consolecentral.records.ConsoleCentralShippingInfo;
import dev.rellaraffick.consolecentral.repositories.ShippingInfoRepository;

public class ShippingInfoService {
    private final ShippingInfoRepository shippingInfoRepository;

    public ShippingInfoService(ShippingInfoRepository shippingInfoRepository) {
        this.shippingInfoRepository = shippingInfoRepository;
    }

    public void getShippingInfo() {
        shippingInfoRepository.findAll();
    }

    //TODO: NEED CLARITY
//    public void getShippingInfoByOrderId(Integer orderId) {
//        shippingInfoRepository.findById(orderId);
//    }

    public void addShippingInfo(ConsoleCentralShippingInfo shippingInfo) {
        shippingInfoRepository.save(shippingInfo);
    }

    public void updateShippingInfo(Integer shippingInfoId, ConsoleCentralShippingInfo shippingInfoDetails) {
        ConsoleCentralShippingInfo existingShippingInfo = shippingInfoRepository.findById(shippingInfoId)
                .orElseThrow(() -> new RuntimeException("Shipping Info not found with id: " + shippingInfoId));
        existingShippingInfo.setOrder(shippingInfoDetails.getOrder());
        existingShippingInfo.setAddress(shippingInfoDetails.getAddress());
        existingShippingInfo.setCity(shippingInfoDetails.getCity());
        existingShippingInfo.setState(shippingInfoDetails.getState());
        existingShippingInfo.setCountry(shippingInfoDetails.getCountry());
        existingShippingInfo.setPostalCode(shippingInfoDetails.getPostalCode());
        shippingInfoRepository.save(existingShippingInfo);
    }
}
