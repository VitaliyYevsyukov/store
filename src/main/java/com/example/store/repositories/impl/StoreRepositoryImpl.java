package com.example.store.repositories.impl;

import com.example.store.domain.Store;
import com.example.store.repositories.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StoreRepositoryImpl implements StoreRepository {

    private final RowMapper<Store> storeRowMapper;

    private final JdbcTemplate jdbcTemplate;

    public StoreRepositoryImpl(JdbcTemplate jdbcTemplate, RowMapper<Store> storeRowMapper) {
        this.jdbcTemplate = jdbcTemplate;
        this.storeRowMapper = storeRowMapper;
    }

    @Override
    public Store getById(Long id) {
        return jdbcTemplate.queryForObject("select * from stores where id = ?",
                storeRowMapper, id);
    }

    @Override
    public List<Store> getAll() {
        List<Store> storeList = jdbcTemplate.query("select * from stores", storeRowMapper);
        return storeList;
    }

    @Override
    public Store saveStore(Store store){
        jdbcTemplate.update("insert into stores(name, phone, type, cashbox_count, delivery)" +
                        " values(?,?,?,?,?)", store.getName(), store.getPhone(), store.getType(),
                        store.getCashboxCount(), store.isDelivery());
        return store;
    }

    @Override
    public void delete(Long id) {
        jdbcTemplate.update("delete from stores where id = ?", id);
    }

    @Override
    public Store update(Store store) {
        jdbcTemplate.update("update stores set cashbox_count = ? where id = ?",
                store.getCashboxCount(), store.getId());
        return store;
    }
}
