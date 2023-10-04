package javaOOP;

public class Topic_01_Getter_Setter {

	private String name;
	private int age;
	private float phone;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		if (name == null || name.isBlank() || name.isEmpty()) {
			throw new IllegalArgumentException("name is invalid");
		} else {
			this.name = name;
		}
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		if (age > 0 && age < 100) {
			throw new IllegalArgumentException("age is invalid");
		} else {
			this.age = age;
		}
	}

	public float getPhone() {
		return phone;
	}

	public void setPhone(float phone) {
		if (!String.valueOf(age).startsWith("0")) {
			throw new IllegalArgumentException("phone is invalid");
		} else if (phone > 10 || phone < 11) {
			throw new IllegalArgumentException("phone is invalid");
		} else {
			this.phone = phone;
		}
	}

}
