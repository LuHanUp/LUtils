/**
 * 
 */
package com.luhan.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import com.luhan.entity.HttpParam;

/**@Description {���繤����}
 * @author luhan
 * @date   2017��4��9�� ����10:33:54
 */
public class NetWorkUtils {
	
	private static URL httpUrl = null;
	private static URLConnection connection = null;
	//ƴ���������
	private static StringBuffer wBuffer = new StringBuffer();
	//���շ��ؽ��
	private static StringBuffer result = new StringBuffer();
	//������ȡ����
	private static BufferedReader reader = null;
	
	
	
	/**
	 * ��ʼ������������
	 * @author luhan
	 * @param url ����ĵ�ַ
	 * @return ���ؽ������ӵ�connection
	 * @throws IOException
	 */
	private static URLConnection init(String url) throws IOException{
		if(httpUrl == null){
			httpUrl = new URL(url);
		}
		if(connection == null && httpUrl != null){
			connection = httpUrl.openConnection();
			connection.setRequestProperty("accept", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
	        connection.setRequestProperty("connection", "keep-alive");
	        connection.setRequestProperty("user-agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:34.0) Gecko/20100101 Firefox/34.0");
	        connection.setDoOutput(true);
	        connection.setDoInput(true);
		}
		
		return connection;
	}
	
	public static String getJsonByURL(String url,List<HttpParam> params) throws IOException{
		//���ó�ʼ������������Ӷ���
		connection = init(url);
		//��������д����,ͨ�����Ӷ������������
		PrintWriter printWriter = new PrintWriter(connection.getOutputStream());
		if(params == null){
			params = new ArrayList<>();
		}
		//��������post��ʽд�����Ӷ�����
		if(params.size() > 0){
			for (int i = 0; i < params.size(); i++) {
				wBuffer.append(params.get(i).getKey())
				.append("=")
				.append(URLEncoder.encode(params.get(i).getValue(),"utf-8"));
				//����������һ��������ƴ��һ��&
				if((i+1) < params.size()){
					wBuffer.append("&");
				}
			}
		}
		printWriter.println(wBuffer.toString());
		printWriter.flush();
		connection.connect();
		//���շ��������صĽ��
		reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
		//��ȡ������
		String line;
		while((line = reader.readLine())!= null){
			result.append(line);
		}
		reader.close();
		
		
		
		
		
		
		return result.toString();
		
	}
}