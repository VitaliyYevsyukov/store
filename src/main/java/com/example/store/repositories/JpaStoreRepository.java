package com.example.store.repositories;

import com.example.store.domain.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaStoreRepository extends JpaRepository<Store, Long> {
}
