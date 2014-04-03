package cc.test.model;

public class QuestionModel {
	public static final String CODE="code";
	public static final String QUESTION="question";
	public static final String IMAGE="image";
	public static final String OPTIONS="options";
	public static final String RIGHT_ANSWER="rightAnswer";
	public static final String TIPS="tips";
	public static final String TYPE_NAME="typeName";
	public static final String TYPE_CODE="typeCode";
	public static final String LEVEL="level";
	public static final String SUBJECT="SUBJECT";
	
	private long code;
	private String question;
	private String image;
	private String options;
	private int rightAnswer;
	private String tips;
	private String typeName;
	private String typeCode;
	private String level;
	private String subject;
	
	public long getCode() {
		return code;
	}
	public void setCode(long code) {
		this.code = code;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getOptions() {
		return options;
	}
	public void setOptions(String options) {
		this.options = options;
	}
	public int getRightAnswer() {
		return rightAnswer;
	}
	public void setRightAnswer(int rightAnswer) {
		this.rightAnswer = rightAnswer;
	}
	public String getTips() {
		return tips;
	}
	public void setTips(String tips) {
		this.tips = tips;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	public String getTypeCode() {
		return typeCode;
	}
	public void setTypeCode(String typeCode) {
		this.typeCode = typeCode;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
}
