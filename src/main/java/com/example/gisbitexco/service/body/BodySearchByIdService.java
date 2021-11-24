package com.example.gisbitexco.service.body;

import com.example.gisbitexco.dto.BodyDto;
import com.example.gisbitexco.entity.Body;
import com.example.gisbitexco.mapper.BodyMapper;
import com.example.gisbitexco.repository.BodyRepository;
import com.example.gisbitexco.service.BaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * BodySearchByIdService
 */
@Service
@RequiredArgsConstructor
public class BodySearchByIdService extends BaseService<Integer, BodyDto> {

    private final BodyMapper bodyMapper;
    private final BodyRepository bodyRepository;

    @Override
    protected BodyDto setOutput() {
        Optional<Body> body = bodyRepository.findById(input);
        if (body.isEmpty())
            return null;
        return bodyMapper.toDto(body.get());
    }
}
