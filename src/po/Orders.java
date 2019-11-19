package po;

public class Orders {
	private int id;
	private String userid;
	private String menuid;
	private String menusum;
	private String times;
	private String delivery;

	public Orders() {
		super();
	}

	public Orders(int id, String userid, String menuid, String menusum, String times, String delivery) {
		super();
		this.id = id;
		this.userid = userid;
		this.menuid = menuid;
		this.menusum = menusum;
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

	public String getMenuid() {
		return menuid;
	}

	public void setMenuid(String menuid) {
		this.menuid = menuid;
	}

	public String getMenusum() {
		return menusum;
	}

	public void setMenusum(String menusum) {
		this.menusum = menusum;
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
		return "Orders [id=" + id + ", userid=" + userid + ", menuid=" + menuid + ", menusum=" + menusum + ", times="
				+ times + ", delivery=" + delivery + "]";
	}

}
