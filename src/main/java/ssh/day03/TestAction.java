package ssh.day03;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Controller
@Scope("prototype")//���ÿ���������ģʽ
public class TestAction {
	private String name;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String save() throws Exception{
		Thread.sleep(10000);
		String tname = Thread.currentThread().getName();
		System.out.println("tname:"+tname+"----��"+name);
		return "success";
	}
}
