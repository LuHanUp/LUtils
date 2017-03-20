package com.luhan.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/** 
* @ClassName: DataUtils 
* @Description: (���ݹ�����) 
* @author Luhan 
* @date 2017��3��18�� ����5:14:48 
*  
*/
public class DataUtils {
	
	/**
	 * ���ݼ��ϵķ�ҳ���������ݴ����ܹ������ݸ�ҳ�룬����ҳ������Ҫ��ʾ������������
	 * <BR/>���÷��͵ķ�������Ϊ��list��Ϊʲô���͵����ݾͷ���ʲô���͵�����
	 * @param f ������Ҫ���з�ҳ�����ݼ���
	 * @param pageNo �ڼ�ҳ
	 * @param dataSize ��ʾ����������
	 * @return ������ҳ֮�󷵻ص�����
	 */
	public static <F> List<F> datepaging(List<F> f,int pageNo,int dataSize){
		/*
		 * �������Է��ֵ�pageNoΪ0����С��ʱ��Ҳ���ǵ�0ҳʱ������ᱨ��������Ҫ����һ��pageNo��ֵ
		 * 
		 * �Ƚ��п�ֵ���жϣ�����������null�쳣
		 * 
		 * ��pageNo��ֵС�ڵ���0ʱ������������ֵΪ1
		 */
		//������У��
		if(f == null){//�����������list����Ϊnullʱ���Ƚ���ʵ����
			f = new ArrayList<F>();
		}
		if((Object)pageNo == null){//�����������pageNoΪnullʱ���Ƚ��и�ֵ����
			pageNo = 1;
		}
		if((Object)dataSize == null){//�����������dataSizeΪnullʱ���Ƚ��и�ֵ����
			dataSize = 1;
		}
		if(pageNo <= 0){
			pageNo = 1;
		}
		//��¼һ������һ���ж�����
		int totalitems = f.size();
		//ʵ����һ�����ܷ�ҳ����֮�������
		List<F> afterList = new ArrayList<F>();
		/*
		 * ���з�ҳ����,����forѭ���ķ�ʽ�����д���
		 * 
		 * ����forѭ���У�iӦ�ô����￪ʼ:iӦ�ô� (��ǰ�ǵڼ�ҳ -1 ���� ����) ��ʼ Ҳ���ǿ�ʼ������
		 * 
		 * Ȼ��forѭ��Ӧ�õ����������Ҳ����iӦ��С��:�ж�(��ʼ������+��ʾ����)�ǲ��Ǵ�����������������ھ��������������С�ھ���(��ʼ������+��ʾ����)
		 * 
		 * Ȼ����i++
		 */
		for 
		( int i = (pageNo-1)*dataSize; 
		  i < (((pageNo -1)*dataSize) + dataSize > 
		  totalitems ? totalitems:((pageNo -1)*dataSize) +dataSize);
				i++) {
			//Ȼ�����ݴ���afterList��
			
			afterList.add(f.get(i));
		}
		
		//Ȼ�󽫴��������ݼ��Ͻ��з���
		return afterList;
	}
	
	/**
	 * ���һ���ж���ҳ
	 * @param dataSize ��Ҫ��ʾ����������
	 * @param totalTiems һ���ж���������
	 * @return һ���ж���ҳ,int����
	 */
	public static int getPageSize(int dataSize,int totalTiems){
		
		/*
		 * ʹ��������������ʾ����Ȼ������ȡ��������һ���ж���ҳ��
		 */
		double result = (double)totalTiems / (double)dataSize;
		//��������ȡ��
		result = Math.ceil(result);
		
		return (int)result;
	}
}
