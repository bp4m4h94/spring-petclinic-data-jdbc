package org.springframework.samples.petclinic.adm;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.samples.petclinic.login.model.AdmUser;

import java.util.List;

@org.springframework.stereotype.Repository
public interface AdmUserRepository extends CrudRepository<AdmUser, Integer> {

    AdmUser findByEmailAndPassword(String email, String psw);

    AdmUser findByUserNameAndPassword(String userName, String psw);

    @Query("select * from adm_user")
    List<AdmUser> findAll();
}
