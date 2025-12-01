package com.ssafy.bomb.add.mapper;

import com.ssafy.bomb.add.dto.AddDTO;
import com.ssafy.bomb.add.entity.Add;

public class AddMapper {
    public static Add PostToEntity(AddDTO.Post post) {
        return Add.builder()
                .title(post.getTitle())
                .href(post.getHref())
                .imageUrl(post.getImageUrl())
                .startDate(post.getStartDate())
                .endDate(post.getEndDate())
                .build();
    }

    public static AddDTO.Get EntityToGet(Add add) {
        return null;
    }
}
