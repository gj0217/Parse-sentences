import java.util.*;

public class RHS {
		private ArrayList<String> rhs;
		private double prob;
		
		public RHS(ArrayList<String> _rhs, double _prob) {
			this.rhs = new ArrayList<String>();
			for (String s : _rhs) {
				this.rhs.add(s);
			}
			this.prob = _prob;
		}
		
		public double getProb() {
			return this.prob;
		}
		
		public void setProb(double _prob) {
			this.prob = _prob;
		}
		
		public String first() {
			return rhs.get(0);
		}
		
		public String second() {
			if (rhs.size() == 1) {
				return null;
			}
			return rhs.get(1);
		}
//		Map<String,String> fir_sec = new HashMap<>();
//
//		public String find_sec(String first_val){
//			if (rhs.size() == 1) {
//				return null;
//			}
//			else{
//				fir_sec.put(rhs.get(0),rhs.get(1));
//				String second_val=fir_sec.get(first_val);
//				return second_val;
//			}
//
//		}

		public void printProduction(String lhs) {
			System.out.print(lhs + " ->");
			for (String s : rhs) {
				System.out.print(" " + s);
			}
			System.out.println();
		}
	}