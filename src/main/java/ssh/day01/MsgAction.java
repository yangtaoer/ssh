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
	 * �����ݴӿ��������ݵ�jspҳ��
	 * @return
	 */
	public String execute(){
		message="666";
		return "success";
	}
}
