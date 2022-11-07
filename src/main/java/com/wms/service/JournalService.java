package com.wms.service;

import com.wms.dto.JournalDTO;
import com.wms.exceptions.ResourceNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface JournalService {

    JournalDTO save(JournalDTO journalDto);

    void deleteById(Long id);

    JournalDTO findById(Long id) throws ResourceNotFoundException;

    Page<JournalDTO> findByCondition(JournalDTO journalDto, Pageable pageable);

    JournalDTO update(JournalDTO journalDto, Long id) throws ResourceNotFoundException;

    List<JournalDTO> findAll();
}
