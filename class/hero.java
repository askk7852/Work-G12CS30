package pain;

public class hero {

	//Class vars (attributes)
	private int str;
	private int dex;
	private int luk;
	protected int hp;
	private double gold;
	private String name;
	private String[] inv = new String[20];
	
	//accessors + modifiers aka getters + setters
	
	//constructor
	//constructor is NOT a method, can be though of as a
	//special type of method and behaves in a similar way
	//cannot be called from any program
	//instead gets run automatically when object is instantiated
	public hero() {
		System.out.println("Run constructor 1");
//		mC.setname("Aurelion");
//		mC.setstr(15);
//		mC.setstr(20);
		name = "Aurelion";
		str = 15;
		System.out.println("End constructor 1");
	}
	
	//overload constructor
	public hero(int str, int dex, int luk) {
		System.out.println("Run constructor 2");
		name = "bozo";
		this.str = str;
		this.dex = dex;
		this.luk = luk;
		System.out.println("End constructor 2");
	}
	
	//static
//	public student() {
//		int grade;
//		String name;
//		//static String name; //all instances would share the variable
	//non static entity needs to be created before it can do anything
	//non static entity needs to be assigned RAM
//		boolean passing;
//	}
	
	//getters
	//generate getters + setters -> source -> generate getters and setters
	public int getstr() {
		return str;
	}
	public int getdex() {
		return dex;
	}
	public int getluk() {
		return luk;
	}
	public int gethp() {
		return hp;
	}
	public double getgold() {
		return gold;
	}
	public String getname() {
		return name;
	}
	public String[] getinv() {
		return inv;
	}
	//if using bool, not get[bool name] -> is[bool name]
	
	//setters
	public void setstr(int str) {
		if(str > 0)
			this.str = str;
	}
	public void setdex(int dex) {
		this.dex = dex;
	}
	public void setluk(int luk) {
		this.luk = luk;
	}
	public void sethp(int hp) {
		this.hp = hp;
	}
	public void setgold(int gold) {
		this.gold = gold;
	}
	public  void setname(String name) {
		this.name = name;
	}
	public void setinv(String[] inv) {
		this.inv = inv;
	}
}
