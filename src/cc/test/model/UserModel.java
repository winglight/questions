package cc.test.model;

public class UserModel {
	public static final String EMAIL="email";
	public static final String RUT="rut";
	public static final String REGION="region";
	public static final String CIUDAD="ciudad";
	public static final String COLEGIO="colegio";
	public static final String ANDROID_SID="androidSid";
	
	private String email;	
	private String rut;	
	private String region;
	private String ciudad;
	private String colegio;
	private String android_sid;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getRut() {
		return rut;
	}
	public void setRut(String rut) {
		this.rut = rut;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public String getCiudad() {
		return ciudad;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	public String getColegio() {
		return colegio;
	}
	public void setColegio(String colegio) {
		this.colegio = colegio;
	}
	public String getAndroid_sid() {
		return android_sid;
	}
	public void setAndroid_sid(String android_sid) {
		this.android_sid = android_sid;
	}	
	
}
