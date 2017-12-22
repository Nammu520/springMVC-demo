package com.danlu.solrTest;


import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.Test;

import com.danlu.util.SolrUtil;


public class test {
	
    @Test
    public void addDocTest(){
    	SolrUtil.addDoc();
    }
    
    @Test
    public void queryTest(){
    	try {
    		SolrUtil.Searchproduct("localhost");
    		System.out.println("success");
		} catch (Exception e) {
			// TODO: handle exception
		}
    	
    }
    
    @Test
    public void jisuanqi(){
    	int a=(188-30)/4;
    	String now=new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        System.out.println(now);
    	System.out.println(a*28);
    }
    
    
    /***************
     * @author liliangwei
     * @create 2017-12-3
     * @description �õ��ڶ��������
     * @return ���صڶ����ʱ�� yyyy-MM-dd
     * @throws InterruptedException
     * @error �ܹܽ�����д,�����Ҹɴ������gotoNextDay����.�Ҽ���˺ü�������߼��ʹ���淶��û��������Ҳ����Ӱ�쵽�߼���
     *        ,�Ҿ����ܹ��Ǹ������׳�,��Ȼ��Ϊ���������Խ������,��Ȼ���Ǽ������츳.
     *         �ǲ��ǿ��Ի������ˣ�����Ѷ���ǰ����أ�������Ҫ20�û���30�ã��ü���������
     ***************/
    public Date getNextDay() throws InterruptedException{
        try {
        	Thread.sleep(1000*60*60*24);
        	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
            String now=sdf.format(new Date());
			return sdf.parse(now);
		} catch (ParseException e) {
			e.printStackTrace();
			System.out.println("Sorry,Server is error, Please try again!");
		}
        return null;
    }
}
