package pain;

public class game {

	public static void main(String[] args) {
		
//		hero mC = new hero(); //main character
//		//hero mV = new hero(); //main villain
		hero mC = new hero(1,2,3); //using overload constructor
		
//		mC.setname("Aurelion");
//		mC.setstr(15);
//		mC.setstr(20);
		
		System.out.println(mC.getname());
		System.out.println(mC.getstr());
		
		//Math.PI = ;
		
		//Hero.getname();
		//does not work because it is just an object
		//Math.random(); method is static so it has its own memory, exists without object
		
	}
	
}
