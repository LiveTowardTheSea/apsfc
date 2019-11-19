package po;

public class CarItem {
	private int menuid;
	private String menuname;
	private String price;
	private int count; // 订购数量

	public CarItem() {
		super();
	}

	public CarItem(int menuid, String menuname, String price, int count) {
		super();
		this.menuid = menuid;
		this.menuname = menuname;
		this.price = price;
		this.count = count;
	}

	public int getMenuid() {
		return menuid;
	}

	public void setMenuid(int menuid) {
		this.menuid = menuid;
	}

	public String getMenuname() {
		return menuname;
	}

	public void setMenuname(String menuname) {
		this.menuname = menuname;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return "CarItem [menuid=" + menuid + ", menuname=" + menuname + ", price=" + price + ", count=" + count + "]";
	}
	
	public void addCount() {
		count++;
	}
}
