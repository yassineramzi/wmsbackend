package com.wms.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.wms.domain.Devise;
import com.wms.repository.DeviseRepository;
import com.wms.service.DeviseService;
import com.wms.service.dto.DeviseDTO;
import com.wms.service.mapper.DeviseMapper;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class DeviseServiceImpl  implements DeviseService {
    private DeviseRepository deviseRepository;

    private DeviseMapper deviseMapper;

    @Override
    public DeviseDTO create(final DeviseDTO deviseDto) {
        Devise devise = this.deviseMapper.toEntity(deviseDto);
        return this.deviseMapper.toDto(this.deviseRepository.save(devise));
    }

    @Override
    public List<DeviseDTO> findAll() {
        return this.deviseMapper.toDto(this.deviseRepository.findAll());
    }

    @Override
    public void delete(final Long id){
        this.deviseRepository.deleteById(id);
    } 
}
