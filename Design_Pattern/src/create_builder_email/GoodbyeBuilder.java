package create_builder_email;

public class GoodbyeBuilder extends Builder {
	
	public GoodbyeBuilder() {
		msg = new GoodbyeMessage();
	}

	@Override
	public void buildSubject() {
		msg.setBody("欢送内容");
	}

	@Override
	public void buildBody() {
		msg.setSubject("欢送标题");
	}
	
}
