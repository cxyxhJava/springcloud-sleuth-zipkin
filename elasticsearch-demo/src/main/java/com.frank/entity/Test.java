package com.frank.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;

import java.io.Serializable;

/**
 * @ Author     ：杨晓波
 * @ Date       ：Created in 14:15 2019-01-03
 * @ Description：
 * @ Modified By：
 */
@AllArgsConstructor
@NoArgsConstructor
@Data

@Document(indexName = "company",type = "employee", shards = 1,replicas = 0, refreshInterval = "-1")
public class Test implements Serializable {

    @Id
    private Long id;

    @Field
    private String name;

    @Field
    private String value;

    public  Test(String name,String value){
        this.name = name;
        this.value = value;
    }

}
