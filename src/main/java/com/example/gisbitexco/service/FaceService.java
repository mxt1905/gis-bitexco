package com.example.gisbitexco.service;

import com.example.gisbitexco.dto.FaceDto;
import org.springframework.stereotype.Service;

/**
 * FaceService
 */
@Service
public interface FaceService {

    FaceDto searchById(Integer id);
}
