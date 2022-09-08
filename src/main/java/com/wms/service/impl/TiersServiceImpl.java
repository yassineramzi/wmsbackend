package com.wms.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.wms.domain.Tiers;
import com.wms.repository.TiersRepository;
import com.wms.service.TiersService;
import com.wms.service.dto.TiersDTO;
import com.wms.service.mapper.TiersMapper;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class TiersServiceImpl implements TiersService {

    private TiersRepository tiersRepository;

    private TiersMapper tiersMapper;

    @Override
    public TiersDTO create(final TiersDTO tiersDto) {
        Tiers tiers = this.tiersMapper.toEntity(tiersDto);
        return this.tiersMapper.toDto(this.tiersRepository.save(tiers));
    }

    @Override
    public List<TiersDTO> findAll() {
        return this.tiersMapper.toDto(this.tiersRepository.findAll());
    }

    @Override
    public void delete(final Long id){
        this.tiersRepository.deleteById(id);
    }
}
