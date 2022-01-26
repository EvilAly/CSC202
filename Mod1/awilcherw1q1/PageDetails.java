package awilcherw1q1;

public class PageDetails {
	private String name;
	private String desc;
	private String sent;
	private String color;

	public PageDetails(String n, String s, String c) {
		this.sent = s;
		this.name = n;
		this.desc = n + "'s Web Page";
		this.color = c;

	}

	public PageDetails() {

	}
	
	
	public String header() {
		return "<html> \n<title>\n" + this.desc + "\n</title> \n<head>  \n</head>";
	}

	public String css() {
		return "\n<style type=\"text/css\"> \nbody { \n\ttext-align: center; \n\tpadding: 150px 0px;"
				+ "\n\tcolor: " + color + " } \n</style>";
	}
	
	public String body() {
		return "\n<body> \n<h1> \n<b><i> " + this.name + "</b></i> \n</h1> \n" + this.sent 
				+ " \n</body> \n</html>";
	}

	// getters & setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getSent() {
		return sent;
	}

	public void setSent(String sent) {
		this.sent = sent;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	
	

}
