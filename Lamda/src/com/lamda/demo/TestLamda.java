package com.lamda.demo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.test.lamda.MyClass;

public class TestLamda {

	public void display (DemoLamdaInterface lamdaImpl) {
		String s = lamdaImpl.demo();
		 System.out.println("Test" +s);
	}

	public static void main(String[] args) {
		TestLamda t = new TestLamda();		
		//LamdaImpl lam = new LamdaImpl();
	
		
	 DemoLamdaInterface lamdavariable = () ->  "Hello World lamda";	 
	 t.display(lamdavariable);
	 System.out.println(lamdavariable.demo());
	 
	//with type declaration
     MathOperation addition =    ( a,  b) -> {
    		  int c = a*b+5;     
    		  	return c;
       };
		
     //with out type declaration
     MathOperation subtraction = (a, b) -> a - b;
     
   int sum =   t.operate(2, 5, addition);
     
   int sub =   t.operate(2, 5, subtraction);
   
   System.out.println("Sum ==="+ sum);
   System.out.println("difference ==="+ sub);
   
   MyClass myclass = new MyClass();
   int j = myclass.operate(5, 5, addition);
   
   System.out.println("Output from other class"+ j);
   
   
   List<String> names  = new ArrayList<String>();
	names.add("Ajay");
	names.add("Ben");
	names.add("Cathy");
	names.add("Dinesh");
	names.add("Tom");
	
	
	names.forEach(a-> System.out.println(a));
	List<String> newlist  = new ArrayList<String>();
	
	listcheck listofNames = ()->{
		names.forEach(b -> {
			
			if(b.equalsIgnoreCase("Ajay")) {
			newlist.add(b);
		}
			System.out.println("added value : " + b);
		});
		
		return newlist;
	};
	
	names.forEach(c->{
		String i = c + "added";
		 System.out.println("Updated list" + i);
	});
	
	
	
	 System.out.println("New list"+ listofNames.operation());
	   
	
	
	
	
	
	Map<String, Integer> prices = new HashMap<String, Integer>();
	prices.put("Apple", 50);
	prices.put("Orange", 20);
	prices.put("Banana", 10);
	prices.put("Grapes", 40);
	prices.put("Papaya", 50);
	
	/* Iterate without using Lambda
	   for (Map.Entry<String, Integer> entry : prices.entrySet()) {
	   System.out.println("Fruit: " + entry.getKey() + ", Price: " + entry.getValue());
	   }
	*/ 
	
	prices.forEach((k,v)->System.out.println("Fruit: " + k + ", Price: " + v));

	}
	 private int operate(int a, int b, MathOperation mathOperation) {
	      return mathOperation.operation(a, b);
	   }

}
