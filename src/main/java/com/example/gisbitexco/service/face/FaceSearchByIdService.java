package com.example.gisbitexco.service.face;

import com.example.gisbitexco.dto.FaceDto;
import com.example.gisbitexco.entity.Face;
import com.example.gisbitexco.mapper.FaceMapper;
import com.example.gisbitexco.repository.FaceRepository;
import com.example.gisbitexco.service.BaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * FaceSearchByIdService
 */
@Service
@RequiredArgsConstructor
public class FaceSearchByIdService extends BaseService<Integer, FaceDto> {

    private final FaceRepository faceRepository;
    private final FaceMapper faceMapper;

    @Override
    protected FaceDto setOutput() {
        Optional<Face> face = faceRepository.findById(input);
        if (face.isEmpty())
            return null;
        return faceMapper.toDto(face.get());
    }
}
