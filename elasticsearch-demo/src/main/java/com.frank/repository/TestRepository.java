package com.frank.repository;

import com.frank.entity.Test;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

/**
 * @ Author     ：杨晓波
 * @ Date       ：Created in 14:14 2019-01-03
 * @ Description：测试dao
 * @ Modified By：
 */
@Repository
public interface TestRepository extends ElasticsearchRepository<Test,Long> {
}