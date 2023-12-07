package pain;

public class human {

	private String name;
	private int age;
	private boolean healthy;
	
	public human() {
		age = 0;
		healthy = true;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		if(age > 30) {
			int number = (int)(Math.random() * 5 + 1);
			if(number == 5)
				return age-5;
			else
				return age;
		}
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public boolean isHealthy() {
		return healthy;
	}

	public void setHealthy(boolean healthy) {
		this.healthy = healthy;
	}
	
	public void add(int i, int j) {
		System.out.println(i + j);;	
	}
	
}
