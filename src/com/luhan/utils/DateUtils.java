package com.luhan.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.luhan.costom.CustomException;

/** 
* @ClassName: Utils 
* @Description: (���ڹ�����) 
* @author Luhan 
* @date 2017��3��18�� ����4:39:44 
*  
*/
public class DateUtils {
	//���þ�̬��SimpleDateFormat����
	private static SimpleDateFormat format;
	//�������ڸ�ʽ�ĳ���
	private static final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
	
	
	/**
	 * Ĭ��ת�����ڵķ�������������������Ҫת���ĸ�ʽΪ"yyyy-MM-dd HH:mm:ss";
	 * @return ת����ɺ�����ڸ�ʽ���ַ������͵�
	 */
	public static String formDate(){
		//���ϵͳ��ǰʱ��
		Date date = new Date(System.currentTimeMillis());
		//��ȡformat���󣬲�����format����Ҫת�����ڵĸ�ʽ
		format = new SimpleDateFormat(DATE_FORMAT);
		
		return format.format(date);
	}
	
	/**
	 * ͨ��������Ҫת����ʲô�������ڸ�ʽ�ķ���
	 * @param dateFormat ��Ҫת����ʲô���ĸ�ʽ
	 * @param tolerant Ĭ�ϵĸ�ʽ
	 * @return ����ת���ɹ�֮����ַ���
	 * @throws CustomException ���׳�null��""�쳣
	 */
	public static String formDate(String dateFormat,String tolerant) throws CustomException{
		if(dateFormat == null || dateFormat.equalsIgnoreCase("")){
			dateFormat = tolerant;
		}
		
		if(tolerant == null){
			throw new CustomException(CustomException.NULLPOINTEXCEPTION);
		}
		if(tolerant.equals("")){
			throw new CustomException(CustomException.NULLVALUEEXCEPTION);
		}
		
		//���ϵͳ��ǰʱ��
		Date date = new Date(System.currentTimeMillis());
		//��ȡformat���󣬲�����format����Ҫת�����ڵĸ�ʽ
		format = new SimpleDateFormat(dateFormat);
		
		return format.format(date);
	}
}
