package com.ssafy.bomb.add.service;

import com.ssafy.bomb.add.dto.AddDTO;
import com.ssafy.bomb.add.entity.Add;
import com.ssafy.bomb.add.mapper.AddMapper;
import com.ssafy.bomb.add.repository.AddRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AddService {

    private final AddMapper addMapper;
    private final AddRepository addRepository;

    @Transactional
    public AddDTO.Get save(AddDTO.Post post, String imageUrl) {
        Add add = addMapper.PostToEntity(post);

        return addMapper.EntityToGet(addRepository.save(add));
    }
}
