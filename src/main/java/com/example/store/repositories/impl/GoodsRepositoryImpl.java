package com.example.store.repositories.impl;

import com.example.store.domain.Goods;
import com.example.store.repositories.GoodsRepository;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Repository
public class GoodsRepositoryImpl implements GoodsRepository {

    private final RowMapper<Goods> goodsRowMapper;
    private final JdbcTemplate jdbcTemplate;

    public GoodsRepositoryImpl(JdbcTemplate jdbcTemplate, RowMapper<Goods> goodsRowMapper){
        this.jdbcTemplate = jdbcTemplate;
        this.goodsRowMapper = goodsRowMapper;
    }

    @Override
    public Optional<Goods> getById(Long id) {
        try{
            Goods goods = jdbcTemplate.queryForObject("select * from goods where id = ?",
                    goodsRowMapper, id);
            return Optional.ofNullable(goods);
        }catch (DataAccessException e){
            e.printStackTrace();
            return Optional.empty();
        }
    }

    @Override
    public Optional<Goods> createGoods(Goods goods) {
        try{
            jdbcTemplate.update("insert into goods(name, cost, manufacturer, date_of_manufacture, store_id)" +
                            " values(?,?,?,?,(select id from stores where name = 'Epicentr'))",
                    goods.getName(), goods.getCost(), goods.getManufacturer(),
                    goods.getDateOfManufacture());
            return Optional.ofNullable(goods);
        }catch (DataAccessException e){
            e.printStackTrace();
            return Optional.empty();
        }
    }

    @Override
    public void delete(Long id) {
        jdbcTemplate.update("delete from goods where id = ?", id);
    }

    @Override
    public Optional<Goods> update(Goods goods) {
        try{
            jdbcTemplate.update("update goods set cost = ? where id = ?",
                    goods.getCost(), goods.getId());
            return Optional.ofNullable(goods);
        }catch (DataAccessException e){
            e.printStackTrace();
            return Optional.empty();
        }
    }

    @Override
    public List<Goods> getAll() {
        List<Goods> goodsList = jdbcTemplate.query("select * from goods", goodsRowMapper);
        return goodsList;
    }

    @Override
    public Set<String> getNames() {
        List<Goods> goodsList = getAll();
        Set<String> result = goodsList.stream()
                .map(goods -> goods.getName()).collect(Collectors.toSet());
        return result;
    }


}
