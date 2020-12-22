package club.jasonkay.xmltest;

import java.io.FileInputStream;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class ParseXmlDemo {

	public static void main(String[] args) {
		/*
		 * 解析emplist.xml文档, 
		 * 将所有的员工信息读取出来并转换为若干Emp实例, 
		 * 存入一个List集合中
		 * 
		 * 解析XML的流程:
		 * 1: 创建SAXReader
		 * 2: 使用SAXReader 读取XML文档并返回Document对象,
		 *   这一步就是DOM解析耗时耗资源的体现
		 *   因为DOM会将XML文档全部读取并以一个Document对象形式存于内存.
		 *   Document对象用于描述解析的XML文档内容
		 * 3: 根据Document对象获取根元素
		 * 4: 按照xml的结构从根元素中开始, 逐级获取子元素以达到xml的目的
		 * 
		 */
		try {
			// 1.
			SAXReader reader = new SAXReader();
			// 2. 
			Document doc = reader.read(new FileInputStream("emplist.xml"));
			// 3.
			/*
			 * 获取根元素
			 * Element的每一个实例用于表示xml文档中的一个元素(一对标签)
			 * 这里获取的相当于是emplist.xml文档中的<list>标签
			 */
			Element root = doc.getRootElement();
			/* 
			 * Element提供了获取元素的相关方法:
			 * 
			 * String getName() 
			 * 获取当前标签的名字
			 * 
			 * List elements()
			 * 获取当前标签下的所有子标签
			 * 
			 * List elements(String name)
			 * 获取当前标签下所有同名子标签
			 * 
			 * Element element(String name)
			 * 获取指定名字的子标签
			 * 
			 * Attribute attribute(String name)
			 * 获取指定名字的属性
			 * 
			 */
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
