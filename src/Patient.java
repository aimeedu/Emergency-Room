public class Patient implements Comparable<Patient>{
	private String name;
	private int age;
	private String gender;
	private String complaint;
	private String alert;
	private int heart;
	private int systolic;
	private int diastolic;
	private int resp;
	private float temp;
	private int oxy;
	private int painLevel;
	private int waiting;
	private String[] med;
	private String doctor;

	// public Patient(String name, int age, String gender){
	// 	this.name = name;
	// 	this.age = age;
	// 	this.gender = gender;
	// }

	public Patient(String name, int age, String gender, String complaint, String alert, int heart, int systolic, int diastolic, int resp, float temp, int oxy, int painLevel, String[] med){
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.complaint = complaint;
		this.alert = alert;
		this.heart= heart;
		this.systolic = systolic;
		this.diastolic = diastolic;
		this.resp = resp;
		this.temp = temp;
		this.oxy = oxy;
		this.painLevel = painLevel;
		this.med = med;
		this.doctor = null;
	}

	public int compareTo(Patient other){
		return other.age - this.age;
	}

	// getter
	public String getName(){
		return this.name;
	}
	public int getAge(){
		return this.age;
	}
	public String getGender(){
		return this.gender;
	}
	public String getComplaint(){
		return this.complaint;
	}
	public int getHR(){
		return this.heart;
	}
	public int getSystolic(){
		return this.systolic;
	}
	public int getDiastolic(){
		return this.diastolic;
	}
	public int getResp(){
		return this.resp;
	}
	public int getOxy(){
		return this.oxy;
	}
	public float getTemp(){
		return this.temp;
	}
	public String getDoctor(){
		return this.doctor;
	}

	public void setDoctor(String d){
		this.doctor = d;
	}


	public String toString(){
		return "Patient: " + getName() + "\n" + getAge() +  ", " + getGender() + ", "
			+ getComplaint() + "\n" + "Assigned Doctor: " + getDoctor()+ "\n"
			+ getHR() +  "\n" + getSystolic() + "/" + getDiastolic() + "\n"
			+ getResp() +  "\n" + getTemp()  +  "\n" + getOxy()+ "\n";
	}
}
