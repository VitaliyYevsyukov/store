package com.example.store.repositories.impl;

import com.example.store.domain.Goods;
import com.example.store.domain.Store;
import com.example.store.repositories.GoodsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class GoodsRepositoryImpl implements GoodsRepository {

    private final RowMapper<Goods> goodsRowMapper;

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public GoodsRepositoryImpl(JdbcTemplate jdbcTemplate, RowMapper<Goods> goodsRowMapper){
        this.jdbcTemplate = jdbcTemplate;
        this.goodsRowMapper = goodsRowMapper;
    }


    @Override
    public Goods getById(Long id) {
        return jdbcTemplate.queryForObject("select * from goods where id = ?",
                goodsRowMapper, id);
    }

    @Override
    public List<Goods> getAll() {
        List<Goods> goodsList = jdbcTemplate.query("select * from goods", goodsRowMapper);
        return goodsList;
    }

    @Override
    public void saveGoods(Goods goods) {
        jdbcTemplate.update("insert into goods(name, cost, manufacturer, date_of_manufacture, store_id)" +
                        " values(?,?,?,?,(select id from stores where name = 'Epicentr'))",
                        goods.getName(), goods.getCost(), goods.getManufacturer(),
                        goods.getDateOfManufacture());
    }

    @Override
    public void delete(Long id) {
        jdbcTemplate.update("delete from goods where id = ?", id);
    }

    @Override
    public void update(Goods goods) {
        jdbcTemplate.update("update goods set cost = ? where id = ?",
                goods.getCost(), goods.getId());
    }
}
