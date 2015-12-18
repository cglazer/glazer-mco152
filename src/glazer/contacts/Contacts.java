package glazer.contacts;

public class Contacts implements Comparable<Contacts> {
	private String name;
	private String email;
	private Address address;
	private String phone;
	private String website;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	@Override
	public int compareTo(Contacts other) {
		String[] fullname = this.name.split(" ");
		String[] otherFullName = this.name.split(" ");
		return fullname[1].compareTo(otherFullName[1]);

	}
}
