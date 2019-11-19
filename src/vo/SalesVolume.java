package vo;

public class SalesVolume {
	
	private String menuname;
	private String menusum;
	private String price;
	private String totalprice;

	public SalesVolume() {
		super();
	}

	public SalesVolume(String menuname, String menusum, String price, String totalprice) {
		super();
		this.menuname = menuname;
		this.menusum = menusum;
		this.price = price;
		this.totalprice = totalprice;
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

	@Override
	public String toString() {
		return "SalesVolume [menuname=" + menuname + ", menusum=" + menusum + ", price=" + price + ", totalprice="
				+ totalprice + "]";
	}

}
