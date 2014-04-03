package cc.test.model;

public class CodeModel {
	public static final String CODE_NO="codeNo";
	public static final String CODE_KEY="codeKey";
	public static final String CODE_VALUE="codeValue";
	public static final String TYPE="type";
	public static final String DESCRIBE="describe";
	
	private String codeNo;	
	private String codeKey;	
	private String codeValue;
	private String type;
	private String describe;
	
	public String getCodeNo() {
		return codeNo;
	}
	public void setCodeNo(String codeNo) {
		this.codeNo = codeNo;
	}
	public String getDescribe() {
		return describe;
	}
	public void setDescribe(String describe) {
		this.describe = describe;
	}
	public String getCodeKey() {
		return codeKey;
	}
	public void setCodeKey(String codeKey) {
		this.codeKey = codeKey;
	}
	public String getCodeValue() {
		return codeValue;
	}
	public void setCodeValue(String codeValue) {
		this.codeValue = codeValue;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
}
