package create_builder_email;

public class WelcomeBuilder extends Builder {

	public WelcomeBuilder() {
		msg = new WelcomeMessage();
	}
	
	@Override
	public void buildSubject() {
		msg.setBody("欢迎内容");
	}

	@Override
	public void buildBody() {
		msg.setSubject("欢迎标题");
	}

}
