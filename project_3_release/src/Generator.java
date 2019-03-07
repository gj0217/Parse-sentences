/**
 * Generate sentences from a CFG
 * 
 * @author sihong
 *
 */

import javax.xml.crypto.dom.DOMCryptoContext;
import java.nio.file.WatchService;
import java.util.*;
import java.io.*;

public class Generator {
	
	private Grammar grammar;

	/**
	 * Constructor: read the grammar.
	 */
	public Generator(String grammar_filename) {
		grammar = new Grammar(grammar_filename);
	}

	public static Object getKey(Map map, Object value){
		Object res_key = new String();
		for(Object key: map.keySet()){
			if(map.get(key).equals(value)){
				res_key=key;
			}
		}
		return res_key;
	}

	/**
	 * Generate a number of sentences.
	 */
	public ArrayList<String> generate(int numSentences) {
		int i,k,m;
		int j=0;


		ArrayList<String> final_result =  new ArrayList<String>();
		//ArrayList<Double> probability =  new ArrayList<Double>();

		for(i=0;i<numSentences;i++){
			String each_result="";
			Stack<String> nodeStack = new Stack<String>();
			String node="ROOT";
			nodeStack.add(node);

			while (!nodeStack.isEmpty()) {
				node = nodeStack.pop();
				if(grammar.findProductions(node)==null){
					each_result+=node;
				}else{
					each_result+=" ("+node;
					double d = Math.random();
					int index = (int)(d*grammar.findProductions(node).size());
					RHS rhs;
//					for(i=0;i<grammar.findProductions(node).size())
//					if(grammar.findProductions(node).size()==1){
//						rhs = grammar.findProductions(node).get(0);
//					}

					rhs=grammar.findProductions(node).get(index);
					nodeStack.push(")");
					if(rhs.second()!=null){
						nodeStack.push(rhs.second());
						if(grammar.symbolType(rhs.second())==0){
							nodeStack.push(" ");
						}
					}
					nodeStack.push(rhs.first());
					if(grammar.symbolType(rhs.first())==0){
						nodeStack.push(" ");
					}
				}
			}
			final_result.add(each_result);
		}
//		try {
//			FileWriter writer=new FileWriter("results/sentences.txt");
//			for(j=0;j<final_result.size();j++){
//				writer.write(final_result.get(j)+"\n");
//			}
//			writer.close();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
			return final_result;
	}

	public static void main(String[] args) {
		// the first argument is the path to the grammar file.
		Generator g = new Generator("data/grammar.gr");
		ArrayList<String> res = g.generate(1);
		for (String s : res) {
			System.out.println(s);
		}
	}
}
