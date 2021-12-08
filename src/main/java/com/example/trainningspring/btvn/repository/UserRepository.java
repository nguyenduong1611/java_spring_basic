package com.example.trainningspring.btvn.repository;

import com.example.trainningspring.btvn.model.entity.User;
import com.example.trainningspring.btvn.repository.database.UserDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class UserRepository {
    @Autowired
    UserDB userDB;
    @PersistenceContext
    private EntityManager entityManager;

    public List<User> findAllUser() {
        return userDB.findAll();
    }
    public int  save(User user){
        User userRep = userDB.save(user);
        if(userRep == null){
            return -1;
        }
        return userRep.getId();
    }

    public User findById(Integer id) {
        return userDB.findById(id).get();
    }

    public User findUser(String username, String password) {
        return userDB.findUser(username, password);
    }

    public User insertNewUser(String username, String password) {
        return userDB.insertNewUser(username, password);
    }
    public int saveUser(User user){
        EntityManager entity = entityManager.getEntityManagerFactory().createEntityManager();
        try {
            entity.getTransaction().begin();
            //query1
            Query query = entity.createNativeQuery("insert into user (username, password) values (:username, :password)");
            query.setParameter("username", user.getUsername());
            query.setParameter("password", user.getPassword());
            query.executeUpdate();

            //query2
            Query query2 = entity.createNativeQuery("select LAST_INSERT_ID()");
            int id = Integer.parseInt(query2.getSingleResult().toString());

            entity.getTransaction().commit();
            return id;
        }catch (Exception e){
            entity.getTransaction().rollback();
        }
        return -1;
    }
}
