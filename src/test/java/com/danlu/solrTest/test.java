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
     * @description 得到第二天的日期
     * @return 返回第二天的时间 yyyy-MM-dd
     * @throws InterruptedException
     * @error 总管叫我重写,还叫我干脆改名成gotoNextDay得了.我检查了好几遍代码逻辑和代码规范都没错啊，命名也不会影响到逻辑啊
     *        ,我觉得总管是个技术白痴,竟然以为改命名可以解决问题,果然还是嫉妒我天赋.
     *         是不是可以换工作了？到腾讯还是阿里呢？工资是要20好还是30好？好激动啊！！
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
