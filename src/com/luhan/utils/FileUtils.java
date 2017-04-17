/**
 * 
 */
package com.luhan.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;

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
	/**
	 * ��ȡtxt�ļ����������
	 * @param filePath �ļ���ַ
	 * @return ���ض�ȡ�������
	 * @throws CustomException �׳������ļ��쳣
	 * @throws IOException 
	 */
	public static String readFile(String filePath) throws CustomException, IOException{
		File file = new File(filePath);
		if(!file.exists()){
			throw new CustomException("û������ļ�");
		}
		//�����洢�ļ������ȡ������
		StringBuffer content = new StringBuffer();
		//���������ļ���ȡ��һ������
		String tempstr = "";
		//�ļ���ȡ��
		FileInputStream inputStream = new FileInputStream(file);
		//�ļ���ȡ����������,���ö�ȡ�ı����ʽΪGBK
		BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream,"GBK"));
		//ѭ����ȡ���������ȡ��������Ϊnull�Ǿ�ֹͣ��ȡ
		while((tempstr=reader.readLine()) != null){
			content.append(tempstr);
		}
		
		//�رն�ȡ��
		reader.close();
		inputStream.close();
		
		//��󷵻ض�ȡ������
		return content.toString();
	}
	/**
	 * д�ļ��ķ���
	 * @param filePath ��Ҫд���Ǹ��ļ���
	 * @param content д��������ʲô
	 * @param isReplace �Ƿ�׷�ӵ��Ѿ��е����ݺ��棬Ĭ���ǵ�
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 */
	public static void writeFile(String filePath,String content,boolean isReplace) throws UnsupportedEncodingException, IOException{
		//ͨ��������ļ�·�����½�һ���ļ�
		File file = new File(filePath);
		//�ж���û������ļ���û�����򴴽�
		if(!file.exists()){
			file.createNewFile();
		}
		//��ȡ�ļ�д��
		FileOutputStream outputStream = new FileOutputStream(file,isReplace);
		//��ȡ�ļ�д�Ĳ�������
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream));
		//д�ļ�����
		writer.write(content);

		//�ر���
		writer.flush();
		writer.close();
	}
	/**
	 * �ļ�д����
	 * @param filePath ��Ҫд���Ǹ��ļ���
	 * @param content д��������ʲô
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 */
	public static void writeFile(String filePath,String content) throws UnsupportedEncodingException, IOException{
		writeFile(filePath,content,true);
	}
}
