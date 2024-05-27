package thanhnt.web.entities;

import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
public class MenuItem {

	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long id;

	 private String menuItemName;

	 private String url;

	 private Integer oder;
	 
	 @ManyToOne
	 @JoinColumn(name = "menu_parent_id")
	 private MenuItem menuParent;
	 @OneToMany(mappedBy = "menuParent", cascade = CascadeType.ALL, orphanRemoval = true)
	 private List<MenuItem> menuCon;
	 @ManyToOne
	 @JoinColumn(name = "menu_id")
	 private Menu menu;
	 @Temporal(TemporalType.TIMESTAMP)
	 private Date ngayTao;

	 @Temporal(TemporalType.TIMESTAMP)
	 private Date ngayCapNhat;

	 private String trangThai;

	
	public MenuItem() {
		super();
	}
	
	public MenuItem(Long id, String menuItemName, String url, Integer oder, MenuItem menuParent, List<MenuItem> menuCon,
			Menu menu, Date ngayTao, Date ngayCapNhat, String trangThai) {
		super();
		this.id = id;
		this.menuItemName = menuItemName;
		this.url = url;
		this.oder = oder;
		this.menuParent = menuParent;
		this.menuCon = menuCon;
		this.menu = menu;
		this.ngayTao = ngayTao;
		this.ngayCapNhat = ngayCapNhat;
		this.trangThai = trangThai;
	}

	public List<MenuItem> getMenuCon() {
		return menuCon;
	}

	public void setMenuCon(List<MenuItem> menuCon) {
		this.menuCon = menuCon;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMenuItemName() {
		return menuItemName;
	}

	public void setMenuItemName(String menuItemName) {
		this.menuItemName = menuItemName;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Integer getOder() {
		return oder;
	}

	public void setOder(Integer oder) {
		this.oder = oder;
	}

	public MenuItem getMenuParent() {
		return menuParent;
	}

	public void setMenuParent(MenuItem menuParent) {
		this.menuParent = menuParent;
	}

	public Menu getMenu() {
		return menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}

	public Date getNgayTao() {
		return ngayTao;
	}

	public void setNgayTao(Date ngayTao) {
		this.ngayTao = ngayTao;
	}

	public Date getNgayCapNhat() {
		return ngayCapNhat;
	}

	public void setNgayCapNhat(Date ngayCapNhat) {
		this.ngayCapNhat = ngayCapNhat;
	}

	public String getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
	}
	

}
