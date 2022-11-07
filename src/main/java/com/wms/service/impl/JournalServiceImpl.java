package com.wms.service.impl;

import com.wms.domain.Journal;
import com.wms.dto.JournalDTO;
import com.wms.exceptions.ResourceNotFoundException;
import com.wms.mapper.JournalMapper;
import com.wms.repository.JournalRepository;
import com.wms.service.JournalService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Slf4j
@Service
@Transactional
public class JournalServiceImpl implements JournalService {
    private final JournalRepository repository;
    private final JournalMapper journalMapper;

    public JournalServiceImpl(JournalRepository repository, JournalMapper journalMapper) {
        this.repository = repository;
        this.journalMapper = journalMapper;
    }

    public JournalDTO save(JournalDTO journalDto) {
        Journal entity = journalMapper.toEntity(journalDto);
        return journalMapper.toDto(repository.save(entity));
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    public JournalDTO findById(Long id) throws ResourceNotFoundException {
        return journalMapper.toDto(repository.findById(id).orElseThrow(ResourceNotFoundException::new));
    }

    public Page<JournalDTO> findByCondition(JournalDTO journalDto, Pageable pageable) {
        Page<Journal> entityPage = repository.findAll(pageable);
        List<Journal> entities = entityPage.getContent();
        return new PageImpl<>(journalMapper.toDto(entities), pageable, entityPage.getTotalElements());
    }

    public JournalDTO update(JournalDTO journalDto, Long id) throws ResourceNotFoundException {
        JournalDTO data = findById(id);
        Journal entity = journalMapper.toEntity(journalDto);
        BeanUtils.copyProperties(entity, data);
        return save(data);
    }

    public List<JournalDTO> findAll() {
        return journalMapper.toDto(repository.findAll());
    }
}
