package create_prototype_clone;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;


public class DeepCloneDemo implements Serializable {
	private static final long serialVersionUID = 1L;

	private String name;
	
	public static void main(String[] args) throws ClassNotFoundException, IOException {
		DeepCloneDemo deepCloneTest = new DeepCloneDemo();
		deepCloneTest.setName("test");
		DeepCloneDemo deepCloned = (DeepCloneDemo) deepClone(deepCloneTest);
		System.out.println(deepCloneTest == deepCloned);
		System.out.println(deepCloneTest.equals(deepCloned));
		System.out.println(deepCloneTest.getClass().equals(deepCloned.getClass()));
	}

	/**
	 * 　　把对象写到流里的过程是序列化(Serialization)过程；而把对象从流中读出来的过程则叫反序列化(Deserialization)过程。应当指出的是，写到流里的是对象的一个拷贝，而原对象仍然存在于JVM里面。

　　		在Java语言里深度克隆一个对象，常常可以先使对象实现Serializable接口，然后把对象（实际上只是对象的拷贝）写到一个流里（序列化），再从流里读回来（反序列化），便可以重建对象。


	 *
	 *　　这样做的前提就是对象以及对象内部所有引用到的对象都是可序列化的，否则，就需要仔细考察那些不可序列化的对象可否设成transient，从而将之排除在复制过程之外。

　　		浅度克隆显然比深度克隆更容易实现，因为Java语言的所有类都会继承一个clone()方法，而这个clone()方法所做的正式浅度克隆。

　　		有一些对象，比如线程(Thread)对象或Socket对象，是不能简单复制或共享的。不管是使用浅度克隆还是深度克隆，只要涉及这样的间接对象，就必须把间接对象设成transient而不予复制；或者由程序自行创建出相当的同种对象，权且当做复制件使用。
	 *
	 *
	 */
	public static Object deepClone(Object obj) throws IOException, ClassNotFoundException {
		// 写入对象到流中
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		ObjectOutputStream oos = new ObjectOutputStream(bos);
		oos.writeObject(obj);
		
		// 从流中读出对象
		ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
		ObjectInputStream ois = new ObjectInputStream(bis);
		return ois.readObject();
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		} else if (obj instanceof DeepCloneDemo) {
			String string = ((DeepCloneDemo)obj).getName();
			return (string.equals(this.name));
		}
		return false;
	}
}
