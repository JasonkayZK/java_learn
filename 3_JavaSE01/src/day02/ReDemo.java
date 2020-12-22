package day02;

public class ReDemo {

	public static void main(String[] args) {
		String reg = "[\\w_\\\\:]+@[\\w_]+(\\.[\\w]+)+";
		String mail = "http:\\271226192_zk@qq.com.cn";
	
		System.out.println(mail.matches(reg));
		
		
		String str = "abc123def456ghi789jkl";
		reg = "[a-zA-Z]+";
		String[] result = str.split(reg);
		System.out.println(result.length);
		for (String s : result) {
			System.out.println(s);
		}
		
		
		reg = "[\\d]+";
		str = str.replaceAll(reg, "#NUMBER#");
		System.out.println(str);
		
	}

}
