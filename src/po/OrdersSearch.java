package po;

/*表示订单搜索条件的实体类*/
public class OrdersSearch {
	private String userid;
	private String menuname;
	private String date;
	private String delivery;

	public OrdersSearch() {
		super();
	}

	public OrdersSearch(String userid, String menuname, String date, String delivery) {
		super();
		this.userid = userid;
		this.menuname = menuname;
		this.date = date;
		this.delivery = delivery;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getMenuname() {
		return menuname;
	}

	public void setMenuname(String menuname) {
		this.menuname = menuname;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getDelivery() {
		return delivery;
	}

	public void setDelivery(String delivery) {
		this.delivery = delivery;
	}

	@Override
	public String toString() {
		return "OrdersSearch [userid=" + userid + ", menuname=" + menuname + ", date=" + date + ", delivery=" + delivery
				+ "]";
	}

}
