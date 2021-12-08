package com.example.trainningspring.btvn.service;

import com.example.trainningspring.btvn.model.dto.user.khaibao.KhaiBaoCreateRequest;
import com.example.trainningspring.btvn.model.entity.KhaiBao;
import com.example.trainningspring.btvn.model.entity.User;
import com.example.trainningspring.btvn.repository.KhaiBaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KhaiBaoService {
    @Autowired
    KhaiBaoRepository khaiBaoRepository;

    public List<KhaiBao> findAll(){
        return khaiBaoRepository.findAll();
    }

    public KhaiBao save(KhaiBao khaibao) {
        return khaiBaoRepository.save(khaibao);
    }

    public List<KhaiBao> findBySDT(String sdt){
        return khaiBaoRepository.findBySDT(sdt);
    }

//    public int saveTK(KhaiBaoCreateRequest khaiBaoCreateRequest){
//        return khaiBaoRepository.save(KhaiBao.builder()
//                .sdt(khaiBaoCreateRequest.getSdt())
//                .dichuyen(khaiBaoCreateRequest.getDichuyen())
//                .trieuchung(khaiBaoCreateRequest.getTrieuchung())
//                .nghinhiem(khaiBaoCreateRequest.getNghinhiem())
//                .nuocbenh(khaiBaoCreateRequest.getNuocbenh())
//                .bieuhien(khaiBaoCreateRequest.getBieuhien())
//                .build());
//
//    }
}
