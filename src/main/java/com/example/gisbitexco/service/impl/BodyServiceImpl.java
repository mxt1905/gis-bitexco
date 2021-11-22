package com.example.gisbitexco.service.impl;

import com.example.gisbitexco.dto.BodyDto;
import com.example.gisbitexco.mapper.BodyMapper;
import com.example.gisbitexco.repository.BodyRepository;
import com.example.gisbitexco.service.BodyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * BodyServiceImpl
 */
@Service
@RequiredArgsConstructor
public class BodyServiceImpl implements BodyService {

    private final BodyMapper bodyMapper;
    private final BodyRepository bodyRepository;

    @Override
    public BodyDto searchById(Integer id) {
        return bodyMapper.toDto(bodyRepository.findById(id).get());
    }
}
