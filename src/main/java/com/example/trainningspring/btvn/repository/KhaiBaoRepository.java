package com.example.trainningspring.btvn.repository;

import com.example.trainningspring.btvn.model.entity.KhaiBao;
import com.example.trainningspring.btvn.model.entity.User;
import com.example.trainningspring.btvn.repository.database.KhaiBaoDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class KhaiBaoRepository {
    @Autowired
    KhaiBaoDB khaiBaoDB;

    public List<KhaiBao> findAll() {
        return khaiBaoDB.findAll();
    }

    public List<KhaiBao> findBySDT(String sdt){
        return khaiBaoDB.findBySDT(sdt);
    }
//    public int saveTK(KhaiBao khaiBao){
//        EntityManager entity = entityManager.getEntityManagerFactory().createEntityManager();
//        try {
//            entity.getTransaction().begin();
//
//            Query query = entity.createNativeQuery("insert into KhaiBao(sdt, dichuyen, trieuchung, nghinhiem, nuocbenh, bieuhien) values (:sdt, :dichuyen, :trieuchung, :nghinhiem, :nuocbenh, :biehien)");
//            query.setParameter("sdt", khaiBao.getSdt());
//            query.setParameter("dichuyen", khaiBao.getDichuyen());
//            query.setParameter("trieuchung", khaiBao.getTrieuchung());
//            query.setParameter("nghinhiem", khaiBao.getNghinhiem());
//            query.setParameter("nuocbenh", khaiBao.getNuocbenh());
//            query.setParameter("bieuhien", khaiBao.getBieuhien());
//            query.executeUpdate();
//
//            entity.getTransaction().commit();
//            return 1;
//        }catch (Exception e){
//            entity.getTransaction().rollback();
//        }
//        return -1;
//    }

    public KhaiBao save(KhaiBao khaiBao){

        return khaiBaoDB.save(khaiBao);
    }


}
