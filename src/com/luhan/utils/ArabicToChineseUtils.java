/**
 * 
 */
package com.luhan.utils;

/**@effect {����������ת��Ϊ���ֵĹ�����}
 * @author luhan
 * @date   2017��3��23�� ����6:09:58
 */
public class ArabicToChineseUtils {
	static String[] units = { "", "ʮ", "��", "ǧ", "��", "ʮ��", "����", d"ǧ��", "��", "ʮ��", "����", "ǧ��", "����" };
    static char[] numArray = { '��', 'һ', '��', '��', '��', '��', '��', '��', '��', '��' };
//    public static void main(String[] args) {
//        int num = 245000006;
//        String numStr = foematInteger(1);
//        System.out.println("num= " + num + ", convert result: " + numStr);
//        double decimal = 245006.234206;
//        System.out.println("============================================================");
//        String decStr = formatDecimal(decimal);
//        System.out.println("decimal= " + decimal + ", decStr: " + decStr);
//    }
    /**
     * ������������ת��Ϊ����
     * @param num ��Ҫת���İ���������
     * @return ���ؾ���ת��֮���Ӧ�ĺ���
     */
    private static String foematInteger(int num) {
        char[] val = String.valueOf(num).toCharArray();
        int len = val.length;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            String m = val[i] + "";
            int n = Integer.valueOf(m);
            boolean isZero = n == 0;
            String unit = units[(len - 1) - i];
            if (isZero) {
                if ('0' == val[i - 1]) {
                    // not need process if the last digital bits is 0
                    continue;
                } else {
                    // no unit for 0
                    sb.append(numArray[n]);
                }
            } else {
                sb.append(numArray[n]);
                sb.append(unit);
            }
        }
        return sb.toString();
    }
    @SuppressWarnings("unused")
    private static String formatDecimal(double decimal) {
        String decimals = String.valueOf(decimal);
        int decIndex = decimals.indexOf(".");
        int integ = Integer.valueOf(decimals.substring(0, decIndex));
        int dec = Integer.valueOf(decimals.substring(decIndex + 1));
        String result = foematInteger(integ) + "." + formatFractionalPart(dec);
        return result;
    }
    private static String formatFractionalPart(int decimal) {
        char[] val = String.valueOf(decimal).toCharArray();
        int len = val.length;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            int n = Integer.valueOf(val[i] + "");
            sb.append(numArray[n]);
        }
        return sb.toString();
    }
}
