package com.atguigu.springboot06.bean;

import lombok.Data;
import org.apache.solr.client.solrj.beans.Field;
import org.springframework.data.annotation.Id;
import org.springframework.data.solr.core.mapping.SolrDocument;

/**
 * @Classname City
 * @Description TODO
 * @Date 2020/3/2 0002 20:51
 * @Created by Administrator - liujinpeng
 */

@SolrDocument(solrCoreName = "test_core")
@Data
public class City {

    @Id
    @Field
    private String id;

    @Field
    private String city;
}
