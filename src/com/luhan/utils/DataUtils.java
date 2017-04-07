package com.luhan.utils;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import com.luhan.costom.CustomException;

/** 
* @ClassName: DataUtils 
* @Description: (���ݹ�����) 
* @author Luhan 
* @date 2017��3��18�� ����5:14:48 
*/
public class DataUtils {
	
	//�����췽����Ϊ˽�е�
	private DataUtils(){
	}
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
		//�ж��´��������ҳ����С�ڵ���0��ʱ�򣬾ͽ�ҳ����Ϊ��һҳ
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
		for( int i = (pageNo-1)*dataSize; 
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
	/**
	 * ��������İٷֱ�ֵ��Ĭ�Ͼ�ȷ���ٷֱȵĺ���λ
	 * @param num1 ��Ҫ�����ֵ1
	 * @param num2 ��Ҫ�����ֵ2
	 * @return ���������İٷֱ� ����%���ŵģ�ΪString����
	 */
	public static String countPercentReturnString(double num1,double num2){
		String result = "";//���������������ٷֱȵĽ��
		//TODO ����null�ж�
		
		//����һ:
//		DecimalFormat format = new DecimalFormat("##%");
		
		//������:
		NumberFormat format = NumberFormat.getInstance();
		//���ñ���С�����λ
		format.setMaximumFractionDigits(2);
		result = format.format((num1 / num2) * 100);
		return result + "%";
	}
	/**
	 * ��������İٷֱ�ֵ
	 * @param num1 ��Ҫ�����ֵ1
	 * @param num2 ��Ҫ�����ֵ2
	 * @param digits ��ȷ������λ
	 * @return ���������İٷֱ� ����%���ŵģ�ΪString����
	 * @throws CustomException ���ܻ��׳�null�쳣
	 */
	public static String countPercentReturnString(double num1,double num2,int digits) throws CustomException{
		String result = "";//���������������ٷֱȵĽ��
		//����null�ж�
		if((Object)num1 == null || (Object)num2 == null || (Object)digits == null){
			throw new CustomException(CustomException.NULLVALUEEXCEPTION);
		}
		if(digits < 0){
			digits = 0;
		}
		//����һ:
//		DecimalFormat format = new DecimalFormat("##%");
		//������:
		NumberFormat format = NumberFormat.getInstance();
		//���ñ���С�����λ
		format.setMaximumFractionDigits(digits);
		result = format.format((num1 / num2) * 100);
		return result + "%";
	}
	/**
	 * ��������İٷֱ�ֵ
	 * @param num1 ��Ҫ�����ֵ1
	 * @param num2 ��Ҫ�����ֵ2
	 * @return ���������İٷֱȲ�����%���ŵģ�ΪInt����
	 */
	public static int countPercentReturnInt(double num1,double num2){
		String result = "";//���������������ٷֱȵĽ��
		//TODO ����null�ж�
		
		DecimalFormat format = new DecimalFormat("##%");
		result = format.format(num1 / num2);
		
		//���н�ȡ�ַ�����ȥ������%��Ȼ�����ת����int����
		result = result.substring(0, result.length()-1);
		
		return Integer.parseInt(result);
	}
	
	/**�ж�cardID�ǲ������֤
	 * ���֤��Ϊ�����Ψһ��ʶ���ںܶ�ϵͳ����Ҫ�û��������֤����Ϣ���������Ǿ�����дһ��������֤���֤�ŵĺϷ��ԡ�
	 * �����������������֤�ŵı������ 
	 * ǰ1-2λ���ֱ�ʾ������ʡ��ֱϽ�С����������Ĵ��룻 
	 * ��3-4λ���ֱ�ʾ�����ڵؼ��У������ݣ��Ĵ��룻 
	 * ��5-6λ���ֱ�ʾ�����������ء������ء��ؼ��У��Ĵ��룻 
	 * ��7-14λ���ֱ�ʾ�������ꡢ�¡��գ� 
	 * ��15-16λ���ֱ�ʾ�����ڵص��ɳ����Ĵ��룻 
	 * ��17λ���ֱ�ʾ�Ա�������ʾ���ԣ�ż����ʾŮ�ԣ� 
	 * ��18λ������У���룺Ҳ�е�˵�Ǹ�����Ϣ�룬������������������������� �����������֤����ȷ�ԡ�У���������0-9�����֣���ʱҲ��X��ʾ��

	 * ֪���˹���֮���������������㷨�� 
	 * ��һ��: �����֤����ĵ�1λ������7��ˣ�
	                        �����֤����ĵ�2λ������9��ˣ�
	                        �����֤����ĵ�3λ������10��ˣ�
	                        �����֤����ĵ�4λ������5��ˣ�
	                        �����֤����ĵ�5λ������8��ˣ�
	                        �����֤����ĵ�6λ������4��ˣ�
	                        �����֤����ĵ�7λ������2��ˣ�
	                        �����֤����ĵ�8λ������1��ˣ�
	                        �����֤����ĵ�9λ������6��ˣ�
	                        �����֤����ĵ�10λ������3��ˣ�
	                        �����֤����ĵ�11λ������7��ˣ�
	                        �����֤����ĵ�12λ������9��ˣ�
	                        �����֤����ĵ�13λ������10��ˣ�
	                        �����֤����ĵ�14λ������5��ˣ�
	                        �����֤����ĵ�15λ������8��ˣ�
	                        �����֤����ĵ�16λ������4��ˣ�
	                        �����֤����ĵ�17λ������2��ˡ� 
	 * �ڶ���: ����һ�����֤����1~17λ��˵Ľ����ͣ�ȫ���������� 
	 * ������: �õڶ�����������Ľ������11�������ͻ��������Ϊ0������Ϊ1������Ϊ2������Ϊ3������Ϊ4������Ϊ5������Ϊ6������Ϊ7������Ϊ8������Ϊ9������Ϊ10��11�ֿ����ԡ� 
	 * ���Ĳ�: �������Ϊ0���Ƕ�Ӧ�����һλ���֤�ĺ���Ϊ1��
                                  �������Ϊ1���Ƕ�Ӧ�����һλ���֤�ĺ���Ϊ0��
                                  �������Ϊ2���Ƕ�Ӧ�����һλ���֤�ĺ���ΪX��
                                  �������Ϊ3���Ƕ�Ӧ�����һλ���֤�ĺ���Ϊ9��
                                  �������Ϊ4���Ƕ�Ӧ�����һλ���֤�ĺ���Ϊ8��
                                  �������Ϊ5���Ƕ�Ӧ�����һλ���֤�ĺ���Ϊ7��
                                  �������Ϊ6���Ƕ�Ӧ�����һλ���֤�ĺ���Ϊ6��
                                  �������Ϊ7���Ƕ�Ӧ�����һλ���֤�ĺ���Ϊ5��
                                  �������Ϊ8���Ƕ�Ӧ�����һλ���֤�ĺ���Ϊ4��
                                  �������Ϊ9���Ƕ�Ӧ�����һλ���֤�ĺ���Ϊ3��
                                  �������Ϊ10���Ƕ�Ӧ�����һλ���֤�ĺ���Ϊ2��

	 * �˽������֤�ŵĹ���֮�����ǾͿ��Զ������У�飺
	 * @author luhan
	 * @param cardID ���֤�ַ���
	 * @return trueΪ�����֤��falseΪ�������֤
	 */
	public static boolean isCordID(String cardID){
	      // �����֤�Ž��г��ȵȼ��ж�
	      if (cardID == null || cardID.length() != 18 || !cardID.matches("\\d{17}[0-9X]")){
	         return false;
	      }
	      // 1-17λ�����������
	      int[] factor = { 7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2 };
	      // 18λ���������
	      char[] random = "10X98765432".toCharArray();
	      // ����1-17λ����Ӧ���ӳ˻�֮��
	      int total = 0;
	      for (int i = 0; i < 17; i++){
	         total += Character.getNumericValue(cardID.charAt(i)) * factor[i];
	      }
	      // �ж�������Ƿ����
	      return random[total % 11] == cardID.charAt(17);
	}
}
