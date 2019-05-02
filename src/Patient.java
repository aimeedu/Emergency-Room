import java.io.*;
import java.util.*;
import java.util.ArrayList;

public class Patient implements Comparable<Patient>{
	private String name, gender, complaint, alert, doctor;
	private int age, heart, systolic, diastolic, resp, oxy, painLevel, triageLevel,id;
	private float temp;

	private long start, end, waiting;
	private ArrayList<String> med;

	public Patient(){
	}

	public Patient(String name, int age, String gender, String complaint, String alert, int heart, int systolic, int diastolic, int resp, float temp, int oxy, int painLevel, ArrayList<String> med){
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
		this.doctor = "N/A";
		this.start = System.currentTimeMillis();

	}

	// getter
	public String getName(){
		return this.name;
	}
	public String getAlert(){
		return this.alert;
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
	public int getSO2(){
		return this.oxy;
	}
	public float getTemp(){
		return this.temp;
	}

	public String getDoctor(){
		return this.doctor;
	}
	public long getStart(){
		return this.start;
	}

	//setter
	public void setDoctor(String d){
		this.doctor = d;
	}
	public void setStart(long st){
		this.start = st;
	}
	public void setEnd(long end){
		this.end = end;
	}
	public void setWaiting(){
		this.waiting = this.end - this.start;
	}
	public void setID(int id){
		this.id = id;
	}
	public void setTriage(int t){
		this.triageLevel = t;
	}

	// classify
	public String readHR(int h){
		if(h>150 || h<30) return "Cardiac Arrest";
		else if(h<60) return "Bradycardia";
		else if(h>100) return "Tachycardia";
		else return "Normal";
	}

	public String readBP(int s, int d){
		if(s>140 || d>90) return "Hypertension";
		else if(s<90 || d<60) return "Hypotension";
		else return "Normal";
	}

	public String readRR(int r){
		if(r<16) return "Bradypnea";
		else if(r>20) return "Tachypnea";
		else return "Normal";
	}

	public String readTemp(float t){
		if(t>99) return "Fever";
		else if(t<95.5) return "Temperture too low.";
		else return "No";
	}

	public String readSO2(int o){
		if(o >= 95 && o <= 100 ) return "Normal";
		else if(o<95) return "Low";
		else return "High";
	}

	//compare
	public int compareTo(Patient other){
		if(this.triageLevel == other.triageLevel){
			// return Math.toIntExact(this.start-other.start);
			return this.id-other.id;
		}
		return this.triageLevel - other.triageLevel;
	}

	public void assignTriageLevel(){
		if(this.alert == "V"){
			this.triageLevel = 1000;
		}else{
			this.triageLevel = 9;
		}

		// else if(this.heart>150 || this.heart<30 ||this.systolic<90 || this.diastolic<60|| this.temp>105 || this.oxy<90 || this.resp<6 || this.alert == "U"){
		// 	this.triageLevel = 1;
		// }
		// else if(this.heart>100 || this.heart<60 ||this.systolic>140 || this.diastolic>90 || (this.oxy>90 && this.oxy<95) || this.resp<16 || this.resp>20 || this.alert == "V" || this.alert == "P"){
		// 	this.triageLevel = 2;
		// }else{
		// 	this.triageLevel = 3;
		// }
	}

	public String toString(){
		return this.name + "\n"
			+ this.age +  ", " + this.gender + ", " + this.complaint + "\n"
			+ this.doctor + "\n"
			+ this.triageLevel + "\n"
			// + this.start + "\n"
			// + this.end + "\n"
			+ this.waiting + "ms" + "\n"

			+ getHR() + " " + readHR(this.heart) +  "\n"
			+ getSystolic() + "/" + getDiastolic() + " " +readBP(this.systolic, this.diastolic)+ "\n"
			+ getResp() + " " + readRR(this.resp) + "\n"
			+ getTemp()  + " " + readTemp(this.temp) + "\n"
			+ getSO2() + "% " + readSO2(this.oxy)+ "\n"
			+ this.alert + "\n"
			+ this.med.toString() + "\n";
	}
}
