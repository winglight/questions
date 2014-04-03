package cc.test.model;

public class ResultModel {
	public static final String EMAIL="email";
	public static final String QUESTION_CODES="questionCodes";
	public static final String QUESTION_ANSWER_CODES="questionAnswerCodes";
	public static final String SUBMIT_TIME="submitTime";
	public static final String RITHT_PERCENT="rightPercent";
	
	private String email;
	private String questionCodes;
	private String questionAnswerCodes;
	private long submitTime;
	private double rightPercent;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getQuestionCodes() {
		return questionCodes;
	}
	public void setQuestionCodes(String questionCodes) {
		this.questionCodes = questionCodes;
	}
	public String getQuestionAnswerCodes() {
		return questionAnswerCodes;
	}
	public void setQuestionAnswerCodes(String questionAnswerCodes) {
		this.questionAnswerCodes = questionAnswerCodes;
	}
	public long getSubmitTime() {
		return submitTime;
	}
	public void setSubmitTime(long submitTime) {
		this.submitTime = submitTime;
	}
	public double getRightPercent() {
		return rightPercent;
	}
	public void setRightPercent(double rightPercent) {
		this.rightPercent = rightPercent;
	}
}
