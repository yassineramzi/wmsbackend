package com.wms.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.wms.domain.Utilisateur;
import com.wms.repository.UtilisateurRepository;
import com.wms.service.dto.security.UserDetailsImpl;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private UtilisateurRepository utilisateurRepository;

    @Autowired
    public UserDetailsServiceImpl(UtilisateurRepository utilisateurRepository) {
        this.utilisateurRepository = utilisateurRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        Utilisateur utilisateur = utilisateurRepository.findByLogin(login).orElseThrow(
                () -> new UsernameNotFoundException("Utilisateur non trouvé : "+login)
        );
        return UserDetailsImpl.build(utilisateur);
    }
}
