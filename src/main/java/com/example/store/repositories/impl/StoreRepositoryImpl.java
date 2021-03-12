package com.example.store.repositories.impl;

import com.example.store.domain.Store;
import com.example.store.repositories.StoreRepository;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Repository
public class StoreRepositoryImpl implements StoreRepository {

    private final RowMapper<Store> storeRowMapper;
    private final JdbcTemplate jdbcTemplate;

    public StoreRepositoryImpl(JdbcTemplate jdbcTemplate, RowMapper<Store> storeRowMapper) {
        this.jdbcTemplate = jdbcTemplate;
        this.storeRowMapper = storeRowMapper;
    }

    @Override
    public Optional<Store> getById(Long id) {
        try{
            Store store = jdbcTemplate.queryForObject("select * from stores where id = ?",
                    storeRowMapper, id);
            return Optional.ofNullable(store);
        }catch (DataAccessException e){
            e.printStackTrace();
            return Optional.empty();
        }
    }

    @Override
    public Optional<Store> create(Store store){

        try{
            jdbcTemplate.update("insert into stores(name, phone, type, cashbox_count, delivery)" +
                            " values(?,?,?,?,?)", store.getName(), store.getPhone(), store.getType(),
                    store.getCashboxCount(), store.isDelivery());
            return Optional.ofNullable(store);
        }catch (DataAccessException e){
            e.printStackTrace();
            return Optional.empty();
        }
    }

    @Override
    public void delete(Long id) {
        jdbcTemplate.update("delete from stores where id = ?", id);
    }

    @Override
    public Optional<Store> update(Store store) {
        try{
            jdbcTemplate.update("update stores set cashbox_count = ? where id = ?",
                    store.getCashboxCount(), store.getId());
            return Optional.ofNullable(store);
        }catch (DataAccessException e){
            e.printStackTrace();
            return Optional.empty();
        }
    }

    @Override
    public List<Store> getAll() {
        List<Store> storeList = jdbcTemplate.query("select * from stores", storeRowMapper);
        return storeList;
    }

    @Override
    public Set<String> getNames() {
        List<Store> storeList = getAll();
        Set<String> result = storeList
                .stream().map(store -> store.getName()).collect(Collectors.toSet());
        return result;
    }

}
