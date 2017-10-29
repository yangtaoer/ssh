package ssh.day01;

public class MsgAction {
	private String message;
	
	public void setMessage(String message) {
		this.message = message;
	}
	
	public String getMessage() {
		return message;
	}
	/**
	 * 将数据从控制器传递到jsp页面
	 * @return
	 */
	public String execute(){
		message="666";
		return "success";
	}
}
