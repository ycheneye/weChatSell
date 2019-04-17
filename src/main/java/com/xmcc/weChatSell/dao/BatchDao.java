package com.xmcc.weChatSell.dao;

import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * @作者 chenyi
 * @date 2019/4/17 15:34
 */
public class BatchDao<T> {

    @PersistenceContext
    EntityManager entityManager;

    @Transactional
    public void batchInsert(List<T> list){
        for (int i = 0; i < list.size(); i++) {
            entityManager.persist(list.get(i));
            if (i%100 == 0 || i == list.size()-1){
                entityManager.flush();
                entityManager.clear();
            }
        }
    }
}
