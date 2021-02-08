/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.dwj.springboot.jpa.repository;

import com.dwj.jdbc.entity.Address;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class AddressRepository  {

    @PersistenceContext
    private EntityManager entityManager;

    public void createTableIfNotExists() {
        throw new UnsupportedOperationException("createTableIfNotExists for JPA");
    }

    public void dropTable() {
        throw new UnsupportedOperationException("dropTable for JPA");
    }

    public void truncateTable() {
        throw new UnsupportedOperationException("truncateTable for JPA");
    }

    public Long insert(final Address entity) {
        entityManager.persist(entity);
        return entity.getAddressId();
    }

    public void delete(final Long addressCode) {
        Query query = entityManager.createQuery("DELETE FROM AddressEntity i WHERE i.addressCode = ?1");
        query.setParameter(1, addressCode);
        query.executeUpdate();
    }

    @SuppressWarnings("unchecked")
    public List<Address> selectAll() {
        return (List<Address>) entityManager.createQuery("SELECT i FROM AddressEntity i").getResultList();
    }
}
