import java.util.Scanner;
import java.io.*;
import java.util.PriorityQueue;
import java.util.HashSet;
import java.util.Set;
import java.util.ArrayList;
import java.io.Serializable;
import java.io.ObjectOutputStream;

public class Main{
  public static void main(String args[]) throws Exception{

		PriorityQueue<Patient> q = new PriorityQueue<>();

		Scanner patient = new Scanner(new File(args[0])).useDelimiter("\\n");
		Scanner cardiac = new Scanner(new File(args[1])).useDelimiter("\\n");
		Scanner cancer = new Scanner(new File(args[2])).useDelimiter("\\n");
		Scanner neuro = new Scanner(new File(args[3])).useDelimiter("\\n");

		Set<String> cd = new HashSet<>();
		Set<String> cc = new HashSet<>();
		Set<String> nr = new HashSet<>();

		while(cardiac.hasNext()){
			cd.add(cardiac.next());
		}
		while(cancer.hasNext()){
			cc.add(cancer.next());
		}
		while(neuro.hasNext()){
			nr.add(neuro.next());
		}

		int id = 1;
		//input prasing the files
		while(patient.hasNext()){
			String p = patient.next();
			String[] arr = p.split(" , | ,|, |,|/");
			String name = arr[0];
			int age = Integer.parseInt(arr[1]);
			String gender = arr[2];
			String complaint = arr[3];
			char alert = arr[4].charAt(0);
			int heart = Integer.parseInt(arr[5]);
			int systolic = Integer.parseInt(arr[6]);
			int diastolic = Integer.parseInt(arr[7]);
			int resp = Integer.parseInt(arr[8]);
			float temp = Float.parseFloat(arr[9]);
			int oxy = Integer.parseInt(arr[10].replaceAll("%",""));
			int painLevel = Integer.parseInt(arr[11].replaceAll("-","-1"));

			ArrayList<String> med = new ArrayList<>();
			for(int i = 12; i < arr.length; i++){
				med.add(arr[i]);
			}
			//create new Patient
			Patient pt = new Patient(name,age,gender,complaint,alert,heart,systolic,diastolic,resp,temp,oxy,painLevel,med);
			pt.setID(id);
			// System.out.println(pt.getAlert().getClass().getSimpleName());
			//assign Triage Level
			pt.assignTriageLevel();

			//assignDoctor
			for(int j = 0; j < med.size();j++){
				if(cd.contains(med.get(j))){
					pt.setDoctor("Cardiologist");
				}
				if(cc.contains(med.get(j))){
					pt.setDoctor("Oncologist");
				}
				if(nr.contains(med.get(j))){
					pt.setDoctor("Neurologist");
				}
				else {
					break;
				}
			}
			//add to the queue.
			pt.setStart(System.currentTimeMillis());
			q.add(pt);
			id++;
		}

		int count = 1;
		while(!q.isEmpty()){
			// System.out.println(count);
			q.peek().setEnd(System.currentTimeMillis());
			q.peek().setWaiting();
			q.peek().saveDataInFile(count);
			// System.out.println(q.poll());
			q.poll();
			count++;
		}
	}
}
