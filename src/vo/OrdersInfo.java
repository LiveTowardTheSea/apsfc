package vo;

public class OrdersInfo {
	
	private int id;
	private String userid;
	private String realname;
	private String phone;
	private String address;
	private String menuname;
	private String menusum;
	private String price;
	private String totalprice;
	private String times;
	private String delivery;

	

	public OrdersInfo() {
		super();
	}

	public OrdersInfo(int id, String userid, String realname, String phone, String address, String menuname,
			String menusum, String price, String totalprice, String times, String delivery) {
		super();
		this.id = id;
		this.userid = userid;
		this.realname = realname;
		this.phone = phone;
		this.address = address;
		this.menuname = menuname;
		this.menusum = menusum;
		this.price = price;
		this.totalprice = totalprice;
		this.times = times;
		this.delivery = delivery;
	}
	
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getRealname() {
		return realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMenuname() {
		return menuname;
	}

	public void setMenuname(String menuname) {
		this.menuname = menuname;
	}

	public String getMenusum() {
		return menusum;
	}

	public void setMenusum(String menusum) {
		this.menusum = menusum;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getTotalprice() {
		return totalprice;
	}

	public void setTotalprice(String totalprice) {
		this.totalprice = totalprice;
	}

	public String getTimes() {
		return times;
	}

	public void setTimes(String times) {
		this.times = times;
	}

	public String getDelivery() {
		return delivery;
	}

	public void setDelivery(String delivery) {
		this.delivery = delivery;
	}

	@Override
	public String toString() {
		return "OrdersInfo [id=" + id + ", userid=" + userid + ", realname=" + realname + ", phone=" + phone
				+ ", address=" + address + ", menuname=" + menuname + ", menusum=" + menusum + ", price=" + price
				+ ", totalprice=" + totalprice + ", times=" + times + ", delivery=" + delivery + "]";
	}

}
