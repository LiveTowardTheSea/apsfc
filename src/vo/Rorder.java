package vo;

public class Rorder {
	private int menuid;
	private String menuname;
	private String sum;

	public Rorder() {
		super();
	}

	public Rorder(int menuid, String menuname, String sum) {
		super();
		this.menuid = menuid;
		this.menuname = menuname;
		this.sum = sum;
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

	public String getSum() {
		return sum;
	}

	public void setSum(String sum) {
		this.sum = sum;
	}

	@Override
	public String toString() {
		return "Ranking [menuid=" + menuid + ", menuname=" + menuname + ", sum=" + sum + "]";
	}

}
