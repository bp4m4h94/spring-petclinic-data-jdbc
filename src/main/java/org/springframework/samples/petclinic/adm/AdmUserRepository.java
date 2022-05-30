package org.springframework.samples.petclinic.adm;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.samples.petclinic.login.model.AdmUser;
import org.springframework.samples.petclinic.vet.Vet;

import java.util.List;

@org.springframework.stereotype.Repository
public interface AdmUserRepository extends CrudRepository<AdmUser, Integer> {

    AdmUser findByEmail(String email);

    @Query("select * from adm_user")
    List<AdmUser> findAll();
}
