package com.atguigu.springboot06.Sercvice;

import com.alibaba.fastjson.JSON;
import com.atguigu.springboot06.bean.City;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrInputDocument;
import org.noggit.JSONUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Classname CitySolrServiceImpl
 * @Description TODO
 * @Date 2020/3/2 0002 20:53
 * @Created by Administrator - liujinpeng
 */
@Service
public class CitySolrServiceImpl implements CitySolrService {

    @Autowired
    SolrClient solrClient;

    @Override
    public void add(City city) {
        SolrInputDocument document = new SolrInputDocument();
        document.setField("id",city.getId());
        document.setField("city",city.getCity());
        try {
            solrClient.add(document);
            solrClient.commit();
        } catch (SolrServerException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(String query) {

    }

    @Override
    public City update(City city) {
        return null;
    }

    @Override
    public List<City> query(String query) {
        List<City> cityList = new ArrayList<City>();
        SolrQuery solrQuery = new SolrQuery();
        //设置默认搜索的域
        solrQuery.set("df", "city");
        solrQuery.setQuery(query);
        //高亮显示
        solrQuery.setHighlight(true);
        //设置高亮显示的域
        solrQuery.addHighlightField("city");
        //高亮显示前缀
        solrQuery.setHighlightSimplePre("<font color='red'>");
        //后缀
        solrQuery.setHighlightSimplePost("</font>");
        try {
            QueryResponse queryResponse = solrClient.query(solrQuery);
            if (queryResponse == null){
                return null;
            }
            SolrDocumentList solrDocumentList = queryResponse.getResults();
            if (solrDocumentList.isEmpty()){
                return null;
            }
            //获取高亮
            Map<String, Map<String, List<String>>> map = queryResponse.getHighlighting();
            for (SolrDocument solrDocument : solrDocumentList){
                City city;
                List<String> list = map.get(solrDocument.get("id")).get("city");
                if (!CollectionUtils.isEmpty(list)){
                    solrDocument.setField("city",list.get(0));
                }
                String bookStr = JSONUtil.toJSON(solrDocument);
                city = JSON.parseObject(bookStr, City.class);
                cityList.add(city);
            }
        } catch (SolrServerException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return cityList;
    }

    @Override
    public List<City> queryAll() {
        List<City> cityList = new ArrayList<City>();
        SolrQuery solrQuery = new SolrQuery();
        solrQuery.setQuery("*:*");
        try {
            QueryResponse queryResponse = solrClient.query(solrQuery);
            if (queryResponse != null){
                cityList = queryResponse.getBeans(City.class);
            }
        } catch (SolrServerException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return cityList;
    }

    @Override
    public City queryById(String id) {
        return null;
    }
}
