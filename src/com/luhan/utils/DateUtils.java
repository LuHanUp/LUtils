package com.luhan.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.luhan.Constant;
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
	
	
	
	/**
	 * Ĭ��ת�����ڵķ�������������������Ҫת���ĸ�ʽΪ"yyyy-MM-dd HH:mm:ss";
	 * @return ת����ɺ�����ڸ�ʽ���ַ������͵�
	 */
	public static String formDate(){
		//���ϵͳ��ǰʱ��
		Date date = new Date(System.currentTimeMillis());
		//��ȡformat���󣬲�����format����Ҫת�����ڵĸ�ʽ
		format = new SimpleDateFormat(Constant.DATE_FORMAT);
		
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
	
	/**
	 * ��ʱ���ת��Ϊ����
	 * @param timesStamp
	 * @return ת��֮������ڣ���ʽΪString
	 */
	public static String timesStampToDate(Long timesStamp){
		//��Ҫת��Ϊʲô����
		format = new SimpleDateFormat(Constant.DATE_FORMAT);
		//������ʱ�������ת��
		String time = format.format(timesStamp);
		return time;
	}
	
	/**
	 * ��ָ��������ת��Ϊʱ���
	 * @param date ָ��������
	 * @return ת��֮��Ľ��
	 * @throws ParseException ���ܻ��׳�����Ĳ�����ȷ��ʽ������
	 */
	public static Long dateToTimestamp(String date) throws ParseException{
		format = new SimpleDateFormat(Constant.DATE_FORMAT);
		Date d = format.parse(date);
		return d.getTime()/1000;
	}
}
