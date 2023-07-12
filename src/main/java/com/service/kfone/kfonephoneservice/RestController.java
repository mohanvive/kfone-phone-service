package com.service.kfone.kfonephoneservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@org.springframework.web.bind.annotation.RestController
public class RestController {

    List<Mobile> mobileList = new ArrayList<>();

    private RestController() {
        mobileList.add(new Mobile("Apple", "iPhone 14 Pro Max", 53.00, 2000.00));
        mobileList.add(new Mobile("Samsung", "Samsung Galaxy Z Fold4", 67.50, 3000));
        mobileList.add(new Mobile("Google", "Google Pixel 7 Pro", 36.00, 1800));
        mobileList.add(new Mobile("Oppo", "OPPO Reno8 5G", 26.50, 1500));
        mobileList.add(new Mobile("Apple", "iPhone SE (3rd gen)", 20.00, 1200));
        mobileList.add(new Mobile("Motorola", "Motorola moto g62 5G", 12.50, 900));
        mobileList.add(new Mobile("Motorola", "Motorola edge 30 5G", 14.00, 1100));
        mobileList.add(new Mobile("Samsung", "Samsung Galaxy A13 4G", 11.00, 1000));
    }

    @GetMapping(value = "/mobiles")
    public List<Mobile> getMobilesList(@RequestParam(name = "price", required = false) Double price) {
        if (price == null) {
            return mobileList;
        }

        List<Mobile> mobiles = new ArrayList<>();
        for (Mobile mobile : mobileList) {
            if (mobile.getPrice() <= price) {
                mobiles.add(mobile);
            }
        }
        return mobiles;
    }

    @GetMapping(value = "/mobiles/{brand}")
    public List<Mobile> findMobiles(@PathVariable String brand) {
        List<Mobile> mobiles = new ArrayList<>();
        for (Mobile mobile : mobileList) {
            if (mobile.getBrand().equalsIgnoreCase(brand)) {
                mobiles.add(mobile);
            }
        }
        return mobiles;
    }

    @GetMapping(value = "/mobiles/price")
    public Map<String, Double> findPrice(@RequestParam String brand, @RequestParam String name) {
        Map<String, Double> priceMap = new HashMap<>();
        for (Mobile mobile : mobileList) {
            if (mobile.getBrand().equalsIgnoreCase(brand) && mobile.getName().equalsIgnoreCase(name)) {
                priceMap.put("price", mobile.getPrice());
                break;
            }
        }
        return priceMap;
    }
}
