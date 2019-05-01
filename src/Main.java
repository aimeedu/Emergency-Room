import java.util.Scanner;
import java.io.*;
import java.util.PriorityQueue;
import java.util.HashSet;
import java.util.Set;

public class Main{
  public static void main(String args[]) throws Exception{

		PriorityQueue<Patient> q = new PriorityQueue<>();

		Scanner patient = new Scanner(new File(args[0])).useDelimiter("\\n");
		Scanner cardiac = new Scanner(new File(args[1])).useDelimiter("\\n");
		Scanner cancer = new Scanner(new File(args[2])).useDelimiter("\\n");
		Scanner neuro = new Scanner(new File(args[3])).useDelimiter("\\n");

		Set<String> cd = new HashSet<>();
		while(cardiac.hasNext()){
			cd.add(cardiac.next());
		}
		System.out.println(cd.size());

		Set<String> cc = new HashSet<>();
		while(cancer.hasNext()){
			cc.add(cancer.next());
		}

		Set<String> nr = new HashSet<>();
		while(neuro.hasNext()){
			nr.add(neuro.next());
		}


		//input prasing the files
		while(patient.hasNext()){
			String p = patient.next();
			String[] arr = p.split(" , | ,|, |,|/");
			String name = arr[0];
			int age = Integer.parseInt(arr[1]);
			String gender = arr[2];
			String complaint = arr[3];
			String alert = arr[4];
			int heart = Integer.parseInt(arr[5]);
			int systolic = Integer.parseInt(arr[6]);
			int diastolic = Integer.parseInt(arr[7]);
			int resp = Integer.parseInt(arr[8]);
			float temp = Float.parseFloat(arr[9]);
			int oxy = Integer.parseInt(arr[10].replaceAll("%",""));
			int painLevel = Integer.parseInt(arr[11].replaceAll("-","-1"));

			String[] med = new String[7];
			for(int i = 12; i < arr.length; i++){
				med[i-12] = arr[i];
			}
			//create new Patient
			Patient pt = new Patient(name,age,gender,complaint,alert,heart,systolic,diastolic,resp,temp,oxy,painLevel,med);
			for(int j = 0; j < med.length;j++){
				if(cd.contains(med[j])){
					pt.setDoctor("Cardiologist");
				}
				if(cc.contains(med[j])){
					pt.setDoctor("Oncologist");
				}
				if(nr.contains(med[j])){
					pt.setDoctor("Neurologist");
				}
				else {
					break;
				}
			}
			// pt.assignDoctor();
			//add to the queue.
			q.add(pt);

			// System.out.println("------");
			// System.out.println(name + " : " + painLevel );

		}

		int count = 0;

		while(!q.isEmpty()){
			System.out.println(q.remove());
			// q.remove();
			count++;

		}


		//output the file;
	}

}
