package com.danlu.util;


import java.io.IOException;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrQuery.ORDER;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrInputDocument;

public class SolrUtil {
	public static final String url="http://localhost:8983/solr/mySolr";
	public static HttpSolrServer solrServer = null;
    public static void initSolr(){
    	solrServer = new HttpSolrServer(url);
    	solrServer.setConnectionTimeout(3000);
	}
    public static SolrDocumentList Searchproduct(String keyword){
        initSolr();
        SolrQuery query=new SolrQuery();
        //�������
        query.addSort("id",ORDER.asc);
        //��ʲôid��ʼ
        query.setStart(0);
        //Ҫ�Զ�������¼
        query.setRows(100);
        //��ѯ�ؼ���
        query.set("q","cat:book");
        //�Ƿ����������̫���ã�
        query.setHighlight(true);  
        query.addHighlightField("title"); 
        query.setHighlightSimplePre("<font color='red'>"); 
        query.setHighlightSimplePost("</font>"); 
        SolrDocumentList solrDocumentList=null;
        try {
            QueryResponse response = solrServer.query(query);
             solrDocumentList = response.getResults();
             for (SolrDocument doc : solrDocumentList) {
                 System.out.println(doc.get("id"));
             }
        } catch (SolrServerException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } 
        return solrDocumentList;
    }

    public static void addDoc(){
    	initSolr();
    	SolrInputDocument sd = new SolrInputDocument();
    	sd.addField("id", 2);
    	sd.addField("_root_", url);
    	try {
    		solrServer.add(sd);
    		solrServer.commit();
		} catch (Exception e) {
			// TODO: handle exception
		    e.printStackTrace();
		}
    }
    public static void delete(String id){
    	initSolr();
    	try {
    		solrServer.deleteByQuery("id:"+id);
			solrServer.commit();
		} catch (SolrServerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
