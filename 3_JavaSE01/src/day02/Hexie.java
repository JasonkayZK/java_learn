package day02;
/**
 * ��г����
 * @author ZK
 *
 */
public class Hexie {

	public static void main(String[] args) {
		String reg = "(wqnmlgb|cnm|sb|2b|nc|tmd|cby|djd)";
		
		String mes = "wqnmlgb!���sb, ����ô��ônc, cnm��";
		
		mes = mes.replaceAll(reg, "***");
		System.out.println(mes);
	}

}
