package com.joaofit.joaofit.controller;

import com.joaofit.joaofit.dto.Activity;
import com.joaofit.joaofit.dto.DeviceInfo;
import com.joaofit.joaofit.dto.Session;
import com.joaofit.joaofit.service.FitService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/fit")
public class FitController {

    private final FitService fitService;

    public FitController(FitService fitService){
        this.fitService = fitService;
    }

    @PostMapping("/upload")
    public Activity uploadFit(@RequestParam("file")MultipartFile file){
        return fitService.getActivity(file);
    }

}
