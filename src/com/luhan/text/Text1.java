package com.luhan.text;

import java.util.ArrayList;
import java.util.List;

/** 
* @ClassName: Text2 
* @Description: (���ϵķ�ҳ�㷨) 
* @author Luhan 
* @date 2017��3��16�� ����17:18:06
*/
public class Text1 {
	private static List<Integer> date;
	private static Integer PaseSize = 6;//��ʾ������
	private static Integer mPageNum = 30;//������

	public static void main(String[] args) {
		//���������ʾ�ڼ�ҳ
		showList(2);
	}
	/**
	 * ��ʾ���ݣ���ҳ��ʾlist���������
	 * @param pageNum ҳ��
	 */
	public static void showList(int pageNum){
		date = new ArrayList<Integer>();
		for (int i = 0; i < mPageNum; i++) {
			date.add(i+1);
		}
		/**�����Ǿ���һҳֻ����ʾ6��
		 * 
		 * forѭ������� i���ڵ�ֵ
		 * ���ǵ�һҳ��ʱ�� 1  ��  0;����Ӧ�ô�0��ʼ
		 * ���ǵڶ�ҳ��ʱ�� 2  ��  6;����Ӧ�ô�6��ʼ
		 * ���ǵ���ҳ��ʱ�� 3  ��  12;����Ӧ�ô�12��ʼ
		 * ���ǵ���ҳ��ʱ�� 4  ��  18;����Ӧ�ô�18��ʼ
		 * 			  .
		 * 			  .
		 * 			  .
		 * 			�Դ�����
		 * ���ǵ�nҳ��ʱ��������Ӧ���Ǵ�(��ǰҳ��-1)*��ʾ����
		 * 
		 * 
		 * 
		 * forѭ�����ұ� iС�ڵ�ֵ,�������ֻ��20������
		 * ���ǵ�һҳ��ʱ�� 1  ��  0~6;�ұߵ���Ӧ��Ϊ6
		 * ���ǵ�һҳ��ʱ�� 2  ��  6~12;�ұߵ���Ӧ��Ϊ6
		 * ���ǵ�һҳ��ʱ�� 3  ��  12~18;�ұߵ���Ӧ��Ϊ6
		 * ���ǵ�һҳ��ʱ�� 4  ��  18~20;�ұߵ���Ӧ��Ϊ20,����Ϊʲô����20������24����Ϊ����ֻ��20������,
		 * ��Ȼi����С��24,��������21��22��23������û��ֵ,������Ӧ����20
		 * �� x = (��ǰҳ��-1)*��ʾ����;
		 * ���ó��ұߵ���ֵӦ��Ϊ:�ж�x�ǲ��Ǵ������ݵ�������,������ھ���ʾ������,���С�ھ���ʾx
		 * �����������ǿ���ʹ����Ԫ���������������·��ı��ʽ
		 * ((pageNum-1)*PaseSize)+PaseSize > mPageNum ? mPageNum:((pageNum-1)*PaseSize)+PaseSize)
		 * ���ж���(��ǰ�ǵڼ�ҳ-1������ʾ����)�ǲ��Ǵ���������,��������������ͷ���������,���С���������򷵻�(��ǰ�ǵڼ�ҳ-1������ʾ����)
		 */
		List<Integer> newDate = new ArrayList<Integer>();
		for (int i = (pageNum-1)*PaseSize; i < (
				((pageNum-1)*PaseSize)+PaseSize > mPageNum ? mPageNum:((pageNum-1)*PaseSize)+PaseSize); i++) {
			newDate.add(date.get(i));
		}
		System.out.println(">>>>>>>>>>��"+pageNum+"ҳ������>>>>>>>>>>>>");
		for (int i = 0; i < newDate.size(); i++) {
			System.out.println(newDate.get(i));
		}
	}	
}
