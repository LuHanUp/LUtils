package com.luhan.test;
/** 
* @ClassName: IntegerAndIntTest 
* @Description: (���ڶԱ�int��Intger������) 
* @author Luhan 
* @date 2017��3��20�� ����11:12:56 
*  
*/
public class IntegerAndIntTest{

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		int i1 = 128;
		Integer i2 = 128;
		System.out.println(i1 == i2);//���true,ֻҪ��int��Integer���жԱȶ�Ϊtrue
		
		System.out.println(">>>>>>>>>>>����һ���ָ���>>>>>>>>>>>>");
		
		Integer i3 = 126;
		Integer i4 = new Integer(126);
		System.out.println(i3 == i4);//���false,��Ϊi4new��һ���µĶ��󣬶�i3�Ǵ浽��������,��i4�浽�ڴ��У�����������ַ��һ��
		
		System.out.println(">>>>>>>>>>>����һ���ָ���>>>>>>>>>>>>");
		
		
		//ʾ��һ:
		Integer i5 = 126;
		Integer i6 = 126;
		System.out.println(i5 == i6);//���true
		
		System.out.println(">>>>>>>>>>>����һ���ָ���>>>>>>>>>>>>");
		
		//ʾ����:
		Integer i7 = 128;
		Integer i8 = 128;
		System.out.println(i7 == i8);//���false
		//ʾ��һ��ʾ������Ϊʲô��ӡ�Ľ����ͬ,��Integer���ж��ڸ�ֵʱʹ�õ�����Integer.valueOf()����
		/**				Integer.valueOf()����Ϊ:
		 * public static Integer valueOf(int i) {//����low��ֵΪ-128,heightΪ127
        	if (i >= IntegerCache.low && i <= IntegerCache.high)
            	return IntegerCache.cache[i + (-IntegerCache.low)];
        	return new Integer(i);
           }
           	��������˼Ϊ:Integer��ֵΪ�����-128~127֮�䣬�ͻ�ӻ���֮��ȡ�����������ٷ�Χ֮��Ļ��������newһ��
		 */
		/**
		 * �ܽ�:int��integer������
		 * 1.integerΪint�İ�װ��
		 * 2.int��integer���бȶԵ�ʱ��Ϊtrue����Ȼ�Ǹ�ֵΪͬһ������ʱ
		 * 3.integerֱ�Ӹ�ֵ��new�������бȶ�Ϊfalse��ǰ�ߴ浽�Ѻ��ߴ浽�ڴ�
		 * 4.integer���бȶ���-128~127֮��Ϊtrue����Ϊfalse���ڷ�Χ��integer����л��棬���ڷ�Χ�ڲ�����л������ֱ��new
		 */
	}
}
