package day02;
/**
 * 和谐用于
 * @author ZK
 *
 */
public class Hexie {

	public static void main(String[] args) {
		String reg = "(wqnmlgb|cnm|sb|2b|nc|tmd|cby|djd)";
		
		String mes = "wqnmlgb!你个sb, 你怎么这么nc, cnm！";
		
		mes = mes.replaceAll(reg, "***");
		System.out.println(mes);
	}

}
