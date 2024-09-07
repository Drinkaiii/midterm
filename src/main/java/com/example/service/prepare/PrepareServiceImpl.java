package com.example.service.prepare;

import com.example.model.CheckOrder;
import com.example.model.CheckoutProduct;
import com.example.repository.OrderRepositiry;
import com.example.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
@Transactional
@Log4j2
public class PrepareServiceImpl implements PrepareService {

    @Value("${order.data.url}")
    private String url;

    private final OrderRepositiry orderRepositiry;
    private final ProductRepository productRepository;

    @Override
    public boolean fetchDataFromApi() {

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List> response = restTemplate.exchange(url, HttpMethod.GET, null, List.class);
        List orderList = response.getBody();
        System.out.println(orderList);
        List<CheckOrder> checkOrderList = new ArrayList<>();
        List<CheckoutProduct> checkoutProductList = new ArrayList<>();
        for (Object order : orderList) {
            CheckOrder checkOrder = new CheckOrder();
            checkOrder.setTotal((Integer) ((Map) order).get("total"));
            checkOrderList.add(checkOrder);
            System.out.println(checkOrder);
            List<Map> products = (List<Map>) ((Map) order).get("list");
            for (Map product : products) {
                CheckoutProduct checkoutProduct = new CheckoutProduct();
                checkoutProduct.setOrderId(Long.valueOf(checkOrderList.size()));
                checkoutProduct.setProductId(Long.valueOf((Integer) product.get("id")));
                checkoutProduct.setPrice((Integer) product.get("price"));
                checkoutProduct.setSize((String) product.get("size"));
                checkoutProduct.setQty((Integer) product.get("qty"));
                checkoutProduct.setColorCode((String) ((Map) product.get("color")).get("code"));
                checkoutProduct.setColorName((String) ((Map) product.get("color")).get("name"));
                checkoutProductList.add(checkoutProduct);
            }

//            Map<String,Object> product = (Map) ((Map<String, Object>) order).get("list");


        }
        orderRepositiry.saveAll(checkOrderList);
        productRepository.saveAll(checkoutProductList);


        return true;
    }

}
