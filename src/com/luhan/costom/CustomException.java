package com.luhan.costom;

/** 
* @ClassName: CustomException 
* @Description: (�Զ����쳣�࣬����ʵ�ָ������ݵ��쳣) 
* @author Luhan 
* @date 2017��3��18�� ����4:58:48 
*  
*/
public class CustomException extends Exception{

	private static final long serialVersionUID = 5566052606355516997L;
	
	
	/**
	 * ������Ϊnull�쳣
	 */
	public static final String NULLPOINTEXCEPTION = "������Ϊ��";
	/**
	 * ������Ϊ""ֵ�쳣
	 */
	public static final String NULLVALUEEXCEPTION = "����Ϊ��ֵ";
	
	/**
	 * �쳣��Ĺ��췽����������ʲô�쳣��Ϣ
	 */
	public CustomException(String meg){
		super(meg);
	}

}
