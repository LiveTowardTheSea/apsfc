package vo;

/**
 * @author Pisces
 *
 */
/**
 * @author Pisces
 *
 */
public class MenusInfo {
	private int id;
	private String name;
	private String typeid;
	private String typename;
	private String burden;
	private String brief;
	private String price;
	private String sums;
	private String price1;
	private String sums1;
	private String imgpath;

	public MenusInfo() {
		// 默认构造函数
	}

	public MenusInfo(int id, String name, String typeid, String typename, String burden, String brief, String price,
			String sums, String price1, String sums1, String imgpath) {
		this.id = id;
		this.name = name;
		this.typeid = typeid;
		this.typename = typename;
		this.burden = burden;
		this.brief = brief;
		this.price = price;
		this.sums = sums;
		this.price1 = price1;
		this.sums1 = sums1;
		this.imgpath = imgpath;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTypeid() {
		return typeid;
	}

	public void setTypeid(String typeid) {
		this.typeid = typeid;
	}

	public String getTypename() {
		return typename;
	}

	public void setTypename(String typename) {
		this.typename = typename;
	}

	public String getBurden() {
		return burden;
	}

	public void setBurden(String burden) {
		this.burden = burden;
	}

	public String getBrief() {
		return brief;
	}

	public void setBrief(String brief) {
		this.brief = brief;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getSums() {
		return sums;
	}

	public void setSums(String sums) {
		this.sums = sums;
	}

	public String getPrice1() {
		return price1;
	}

	public void setPrice1(String price1) {
		this.price1 = price1;
	}

	public String getSums1() {
		return sums1;
	}

	public void setSums1(String sums1) {
		this.sums1 = sums1;
	}

	public String getImgpath() {
		return imgpath;
	}

	public void setImgpath(String imgpath) {
		this.imgpath = imgpath;
	}

	@Override
	public String toString() {
		return "MenusInfo [userid=" + id + ", name=" + name + ", typeid=" + typeid + ", typename=" + typename + ", burden="
				+ burden + ", brief=" + brief + ", price=" + price + ", sums=" + sums + ", price1=" + price1
				+ ", sums1=" + sums1 + ", imgpath=" + imgpath + "]";
	}

}
