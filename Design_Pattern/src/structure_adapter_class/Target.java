package structure_adapter_class;

/**
 * 目标(Target)角色：这就是所期待得到的接口。
 * 
 * 注意：由于这里讨论的是类适配器模式，因此目标不可以是类。
 * 
 * @author Jasonkay
 *
 */
public interface Target {
    /**
     * 这是源类Adaptee也有的方法
     */
    public void sampleOperation1(); 
    /**
     * 这是源类Adapteee没有的方法
     */
    public void sampleOperation2(); 
}
