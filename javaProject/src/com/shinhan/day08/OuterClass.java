package com.shinhan.day08;

//field!!! + constructor + method!!! + instance block + static block + inner class
public class OuterClass {
    String instanceVar = "OuterClass의 instanceVar";
    static String staticVar = "OuterClass의 staticVar";
 
    
    void instanceF() {
    	System.out.println("OuterClass의 instanceF():" + instanceVar);
    	System.out.println("OuterClass의 instanceF():" + staticVar);
    }
    static void staticF() {
    	//불가System.out.println("OuterClass의 staticF()" + instanceVar);
    	System.out.println("OuterClass의 staticF()" + staticVar);
    }
    int score = 100;
    class InnerClass{
    	String instanceVar2 = "InnerClass의 instanceVar";
        static String staticVar2 = "InnerClass의 staticVar";
        String score="이백점";
        void instanceF() {
        	System.out.println("OuterClass의 instanceF():" + instanceVar);
        	System.out.println("OuterClass의 instanceF():" + staticVar);
        	System.out.println("InnerClass의 instanceF():" + instanceVar2);
        	System.out.println("InnerClass의 instanceF():" + staticVar2);
        	System.out.println("InnerClass의 instanceF():" + score);
        	System.out.println("InnerClass의 instanceF():" + OuterClass.this.score);
        	
        }
        static void staticF() {
        	//instance생성없이 사용하므로 static만 가능 
        	//System.out.println("OuterClass의 instanceF():" + instanceVar);
        	System.out.println("OuterClass의 instanceF():" + staticVar);
        	//System.out.println("InnerClass의 instanceF():" + instanceVar2);
        	System.out.println("InnerClass의 instanceF():" + staticVar2);
        	//System.out.println("InnerClass의 instanceF():" + score);
        	//System.out.println("InnerClass의 instanceF():" + OuterClass.this.score);
        	
        }
        
        
    }
}




