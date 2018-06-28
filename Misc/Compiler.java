import java.util.*;
import java.io.*;


public class Compiler{


	static class Widget{
		private String state;
		private String plant;
		private String dept;
		private int empId;
		private int count;
		private String name;

		public Widget(String state, String plant, String dept, int empId, int count, String name){
			this.state = state;
			this.plant = plant;
			this.dept = dept;
			this.empId = empId;
			this.count = count;
			this.name = name;
		}

		public  String getState(){
			return this.state;
		}
		public  String getPlant(){
			return this.plant;
		}
		public  String getDept(){
			return this.dept;
		}
		public  int getEmpId(){
			return this.empId;
		}
		public  int getCount(){
			return this.count;
		}
		public  String getName(){
			return this.name;
		}


	}

	public  static void printStats(ArrayList<Widget> widget){

		int deptCount = 0, plantCount = 0, stateCount = 0; 

	 	Widget lastMatch = widget.get(0);

	 	int size = widget.size();

		for(int i = 0; i < widget.size() - 1; i++){
			Widget current = widget.get(i);
			Widget nextMatch = widget.get(i+1);

			String currentName = current.getName();
			String nextName = nextMatch.getName();
			//String lastDept = lastMatch.getDept();
			String currentDept = current.getDept();
			String nextDept = nextMatch.getDept();

			//String lastPlant = lastMatch.getPlant();
			String currentPlant = current.getPlant();
			String nextPlant = nextMatch.getPlant();

			//String lastState = lastMatch.getState();
			String currentState = current.getState();
			String nextState = nextMatch.getState();

			//int lastCount = lastMatch.getCount();
			int currentCount = current.getCount();
			int nextCount = nextMatch.getCount();

			System.out.println(currentState + "  " + currentPlant + "  " + currentDept + "   " + currentDept + "  " + currentCount + "  "  + currentName);
			if(currentState.equals(nextState))
			{
				if(currentPlant.equals(nextPlant)){

					if(currentDept.equals(nextDept)){
						deptCount +=  currentCount ;
						plantCount +=   currentCount ;
						stateCount +=  currentCount;
					}
					else{
						deptCount +=  currentCount;
						plantCount +=   currentCount;
						stateCount +=  currentCount;
						System.out.println(deptCount + " TOTAL FOR DEPT " + currentDept);
						deptCount = 0;

					}
				}
				else{
					deptCount +=  currentCount;
					plantCount +=   currentCount;
					stateCount +=  currentCount;
					System.out.println(deptCount + " TOTAL FOR DEPT " + currentDept);
					System.out.println(plantCount + " TOTAL FOR PLANT " + currentPlant);
					plantCount = 0;
					deptCount = 0;
				}


			}
			else{
					deptCount +=  currentCount;
					plantCount +=   currentCount;
					stateCount +=  currentCount;
					System.out.println(deptCount + " TOTAL FOR DEPT " + currentDept);
					System.out.println(plantCount + " TOTAL FOR PLANT " + currentPlant);
					System.out.println(stateCount + " TOTAL FOR STATE " + currentState);
					plantCount = 0;
					deptCount = 0;
					stateCount = 0;
			}

			if(i + 1 == size - 1){
				deptCount +=  nextCount;
				plantCount +=   nextCount;
				stateCount +=  nextCount;
				System.out.println(deptCount + " TOTAL FOR DEPT " + currentDept);
				System.out.println(plantCount + " TOTAL FOR PLANT " + currentPlant);
				System.out.println(stateCount + " TOTAL FOR STATE " + currentState);
			}




		}
	}


	public static ArrayList<Widget> readCSV(String path) throws FileNotFoundException{

		ArrayList<Widget> list = new ArrayList<>();
		File file = new File(path);
		Scanner in  = new Scanner(file);

		in.nextLine();
		while(in.hasNextLine()){
			String[] line = in.nextLine().trim().split(",");
			Widget w = new Widget(line[0], line[1], line[2], Integer.parseInt(line[3]), Integer.parseInt(line[5]), line[4]);
			list.add(w);
		}

		return list;

	}


	public static void main(String[] args) throws FileNotFoundException {
		if(args.length < 1){
			System.out.println("Usage: java Compiler <path/to/file>");
			return;
		}	

		ArrayList<Widget> list = readCSV(args[0]);
		printStats(list);



	}
}