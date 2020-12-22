package create_singleton;

public class SingletonTest {

	public static void main(String[] args) {
		System.out.println(EagerSingleton.getInstance());
		System.out.println(LazySingleton.getInstance());
		System.out.println(Singleton.getInstance());
		System.out.println(AdvanceSingleton.getInstance());
		EnumSingleton.uniqueInstance.singletonOperation();
	}

}
