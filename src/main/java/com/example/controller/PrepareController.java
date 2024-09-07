package com.example.controller;

import com.example.service.prepare.PrepareService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class PrepareController {

    private final PrepareService systemService;

    @GetMapping("system_get_data")
    public ResponseEntity<?> getDataFromApi() {
        if (systemService.fetchDataFromApi())
            return ResponseEntity.ok("done");
        else
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

}
