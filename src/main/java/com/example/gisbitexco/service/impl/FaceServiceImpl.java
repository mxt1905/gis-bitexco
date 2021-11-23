package com.example.gisbitexco.service.impl;

import com.example.gisbitexco.dto.FaceDto;
import com.example.gisbitexco.entity.Face;
import com.example.gisbitexco.mapper.FaceMapper;
import com.example.gisbitexco.repository.FaceRepository;
import com.example.gisbitexco.service.FaceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

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
        Optional<Face> face = faceRepository.findById(id);
        if (face.isEmpty())
            return null;
        return faceMapper.toDto(face.get());
    }
}
