package com.example.gisbitexco.service.impl;

import com.example.gisbitexco.dto.BodyDto;
import com.example.gisbitexco.entity.Body;
import com.example.gisbitexco.mapper.BodyMapper;
import com.example.gisbitexco.repository.BodyRepository;
import com.example.gisbitexco.service.BodyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

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
        Optional<Body> body = bodyRepository.findById(id);
        if (body.isEmpty())
            return null;
        return bodyMapper.toDto(body.get());
    }
}
