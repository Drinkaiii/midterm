package com.example.service.dashboard;

import java.util.List;
import java.util.Map;

public interface DashboardService {

    int getTotalIncome();

    List<Map> getQuantityByColor();

    List<Integer> getQuantityByPriceRange();

    List<Integer> getTop5();

}
