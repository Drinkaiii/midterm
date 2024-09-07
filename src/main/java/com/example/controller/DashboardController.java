package com.example.controller;

import com.example.service.dashboard.DashboardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/1.0")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://**")
public class DashboardController {

    private final DashboardService dashboardService;

    @GetMapping("/total")
    public ResponseEntity<?> getTotal(){
        return new ResponseEntity<>(Map.of("total",dashboardService.getTotalIncome()), HttpStatus.OK);
    }

    @GetMapping("/percent")
    public ResponseEntity<?> getQuantityByColor(){
        List<Map> response = dashboardService.getQuantityByColor();
        if (response.size()>0)
            return new ResponseEntity<>(response, HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/quantity")
    public ResponseEntity<?> getQuantityByPriceRange(){
        List<Integer> response = dashboardService.getQuantityByPriceRange();
        if (response.size()>0)
            return new ResponseEntity<>(response, HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/top5")
    public ResponseEntity<?> getTop5(){
        List<Integer> response = dashboardService.getTop5();
        if (response.size()>0)
            return new ResponseEntity<>(response, HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
