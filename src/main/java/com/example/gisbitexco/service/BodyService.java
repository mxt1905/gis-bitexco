package com.example.gisbitexco.service;

import com.example.gisbitexco.dto.BodyDto;
import org.springframework.stereotype.Service;

/**
 * BodyService
 */
@Service
public interface BodyService {

    BodyDto searchById(Integer id);
}
