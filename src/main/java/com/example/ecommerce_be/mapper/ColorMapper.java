package com.example.ecommerce_be.mapper;

import com.example.ecommerce_be.dto.ColorDTO;
import com.example.ecommerce_be.entity.Color;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel = "spring")
public interface ColorMapper {

    @Mapping(target = "productList",ignore = true)
    Color toColorDto(ColorDTO colorDTO);

    ColorDTO toEntityColor(Color color);
}
