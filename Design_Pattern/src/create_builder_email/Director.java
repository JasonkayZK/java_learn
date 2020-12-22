package create_builder_email;

/**
 * 导演者Director，这个类提供一个construct()方法，此方法调用建造者的建造方法，包括buildTo()、buildFrom()、buildSubject()、buildBody()、buildSendDate()等，从而一部分一部分地建造出产品对象，既AutoMessage对象。
 * 
 * @author Jasonkay
 *
 */
public class Director {
	Builder builder;
    /**
     * 构造子
     */
    public Director(Builder builder){
        this.builder = builder;
    }
    /**
     * 产品构造方法，负责调用各零件的建造方法
     */
    public void construct(String toAddress , String fromAddress){
        this.builder.buildTo(toAddress);
        this.builder.buildFrom(fromAddress);
        this.builder.buildSubject();
        this.builder.buildBody();
        this.builder.buildSendDate();
        this.builder.sendMessage();
    }
}
