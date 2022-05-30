/*
 * Copyright 2012-2018 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.samples.petclinic;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.samples.petclinic.adm.AdmUserRepository;
import org.springframework.samples.petclinic.login.model.AdmUser;
import org.springframework.samples.petclinic.vet.Vet;
import org.springframework.samples.petclinic.vet.VetRepository;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest
public class PetclinicIntegrationTests {

    @Autowired
    private VetRepository vets;

    @Autowired
    private AdmUserRepository admUserRepository;

    @Test
    public void testFindAll() throws Exception {
        vets.findAll();
        vets.findAll(); // served from cache
    }

    @Test
    public void testFindAdmUser() throws Exception {
        AdmUser a = admUserRepository.findByEmail("abc123@gmail.com");
        System.out.println(a.toString());
    }
}
