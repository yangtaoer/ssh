package ssh.day02;

public class JsonResultAction {
	private String name;
	private int age;
	private JsonResult jsonResult;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public JsonResult getJsonResult() {
		return jsonResult;
	}
	public void setJsonResult(JsonResult jsonResult) {
		this.jsonResult = jsonResult;
	}
	
	public String execute(){
		name = "Tom";
		String []names = new String[]{"a","b","c"};
		age = 20;
		jsonResult = new JsonResult(names);
		return "success";
	}
}
