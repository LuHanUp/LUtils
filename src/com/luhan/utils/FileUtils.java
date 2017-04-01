/**
 * 
 */
package com.luhan.utils;

import java.io.File;
import java.io.FileFilter;

import com.luhan.costom.CustomException;

/**@effect {�ļ���صĹ�����}
 * @author luhan
 * @date   2017��4��1�� ����3:06:46
 */
public class FileUtils {

	//˽�еĹ��췽��
	private FileUtils(){};
	
	/**
	 * ͨ��ָ���ļ����µĵ�ָ����׺���Ƶ��ļ�
	 * @param filePath �ļ���·��
	 * @param suffixName ��׺����
	 * @return	����װ������������ļ�������
	 * @throws CustomException �׳������ļ��е��쳣
	 */
	public static File[] getFilesBySuffixName(String filePath,String suffixName) throws CustomException{
		//TODO ����У��
		
		//����һ���յ��ļ�����������װ���ҵ������������ļ�
		File[] files = new File[0];
		
		//ͨ���ļ�·����ȡ�ļ�
		File folder = new File(filePath);
		//�ж�����ļ��ǲ����ļ��У�������ļ��оͼ���������ֱ��return
		if(!folder.isDirectory()){
			throw new CustomException("�������ļ��е�·��");
		}else{
			files = folder.listFiles(new FileFilter() {
				@Override
				public boolean accept(File pathname) {
					//�ж��ǲ����ļ������Һ�׺�ǲ�������Ҫ��
					if(pathname.isFile() && pathname.getName().indexOf(suffixName) > -1){
						return true;
					}
					return false;
				}
			});
			return files;
		}
	}
}
