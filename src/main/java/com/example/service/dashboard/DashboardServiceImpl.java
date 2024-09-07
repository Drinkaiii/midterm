package com.example.service.dashboard;

import com.example.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class DashboardServiceImpl implements DashboardService {

    private final ProductRepository productRepository;

    @Override
    public int getTotalIncome() {
        return productRepository.getTotalPrice();
    }

    @Override
    public List<Map> getQuantityByColor() {
        List rowDatas = productRepository.getAllQuantityByColorName();
        if (rowDatas == null || rowDatas.size() == 0)
            return new ArrayList<Map>();
        else {
            List<Map> mapDatas = new ArrayList<>();
            for (Object rowData : rowDatas) {
                String[] words = ((String) rowData).split(",");
                mapDatas.add(Map.of(words[0], Integer.valueOf(words[1])));
            }
            return mapDatas;
        }
    }

    @Override
    public List<Integer> getQuantityByPriceRange() {
        List<String> rowDatas = productRepository.getAllQuantityByPriceRange();
        if (rowDatas == null || rowDatas.size() == 0)
            return new ArrayList<Integer>();
        else {
            List<Integer> integerDatas = new ArrayList<>();
            for (Object rowData : rowDatas) {
                String[] words = ((String) rowData).split(",");
                integerDatas.add(Integer.valueOf(words[1]));
            }
            return integerDatas;
        }
    }

    @Override
    public List<Integer> getTop5() {
//        List rowDatas = productRepository.getAllQuantityByColorName();
//        if (rowDatas == null || rowDatas.size() == 0)
//            return new ArrayList<Integer>();
//        else{
//            List<Integer> mapDatas = new ArrayList<>();
//            for (Object rowData : rowDatas){
//                String[] words = ((String)rowData).split(",");
//                mapDatas.add(Map.of(words[0], Integer.valueOf(words[1])));
//            }
//            return mapDatas;
//        }
        return List.of();
    }
}
