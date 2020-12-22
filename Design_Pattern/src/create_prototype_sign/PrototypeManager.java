package create_prototype_sign;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * 原型管理器角色保持一个聚集，作为对所有原型对象的登记.
 * 
 * 这个角色提供必要的方法，供外界增加新的原型对象和取得已经登记过的原型对象。
 * 
 * @author ZK
 *
 */
public class PrototypeManager {
	/**
	 * 用来记录原型的编号和原型实例的对应关系
	 */
	private static Map<String, Prototype> map = new HashMap<String, Prototype>();
	
	/**
	 * 私有化构造方法， 避免外部创建实例
	 */
	private PrototypeManager() {}
	
	/**
	 * 向原型管理器中添加或修改某个注册原型
	 * 
	 * @param prototypeId 原型编号
	 * 
	 * @param prototype 原型实例
	 * 
	 */
	public synchronized static void setPrototype(String prototypeId, Prototype prototype) {
		map.put(prototypeId, prototype);
	}
	
	/**
	 * 从原型管理器中删除某个原型注册
	 * 
	 * @param prototypeId 原型编号
	 * 
	 */
	public synchronized static void removePrototype(String prototypeId) {
		map.remove(prototypeId);
	}
	
    /**
     * 获取某个原型编号对应的原型实例
     * @param prototypeId    原型编号
     * @return    原型编号对应的原型实例
     * @throws Exception    如果原型编号对应的实例不存在，则抛出异常
     */
	public synchronized static Prototype getPrototype(String prototypeId) throws Exception {
		Prototype prototype = map.get(prototypeId);
		if (prototype == null) {
			throw new Exception("原型未被注册或已被销毁");
		}
		return prototype;
	}
}
