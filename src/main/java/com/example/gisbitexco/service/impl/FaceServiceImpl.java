package com.example.gisbitexco.service.impl;

import com.example.gisbitexco.dto.FaceDto;
import com.example.gisbitexco.mapper.FaceMapper;
import com.example.gisbitexco.repository.FaceRepository;
import com.example.gisbitexco.service.FaceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * FaceServiceImpl
 */
@Service
@RequiredArgsConstructor
public class FaceServiceImpl implements FaceService {

    private final FaceRepository faceRepository;
    private final FaceMapper faceMapper;

    @Override
    public FaceDto searchById(Integer id) {
        return faceMapper.toDto(faceRepository.findById(id).get());
    }
}
