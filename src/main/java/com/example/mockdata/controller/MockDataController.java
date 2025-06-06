package com.example.mockdata.controller;

import com.example.mockdata.domain.EDataType;
import com.example.mockdata.domain.payload.request.ColumnAttribute;
import com.example.mockdata.domain.payload.request.GenerateMockDataRequest;
import com.example.mockdata.domain.payload.response.MockDataGenerateResponse;
import com.example.mockdata.service.MockDataService;
import com.example.mockdata.service.impl.MockDataGenerateService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/mock-data")
@RequiredArgsConstructor
@CrossOrigin(origins = "*", maxAge = 3600)
public class MockDataController{

    private final MockDataGenerateService service;
    private final MockDataService mockDataService;

    @GetMapping("/generate")
    ResponseEntity<?> generate(@RequestBody GenerateMockDataRequest request){
        return ResponseEntity.ok(new MockDataGenerateResponse(
                request.getNumRows(),
                service.generate(request)
        ));
    }

    @PostMapping("/generate/v2")
    public void generateV2(@RequestBody GenerateMockDataRequest request, HttpServletResponse response){
        MockDataGenerateResponse response1 = new MockDataGenerateResponse(
                request.getNumRows(),
                service.generate(request)
        );
        response.setContentType("application/x-www-form-urlencoded; charset=utf-8");
        try {
            response.getWriter().print(response1.getData());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/all-types")
    ResponseEntity<?> getAllTypes(){
        return ResponseEntity.ok(mockDataService.getAllExampleTypes());
    }
}
