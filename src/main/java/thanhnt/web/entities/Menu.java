package thanhnt.web.entities;

import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
public class Menu {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String menuName;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreated;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dateUpdated;

    private String status;
    
    @OneToMany(mappedBy = "menu", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<MenuItem> danhSachMucMenu;

	public Menu() {
		super();
	}

	public Menu(Long id, String menuName, Date dateCreated, Date dateUpdated, String status,
			List<MenuItem> danhSachMucMenu) {
		super();
		this.id = id;
		this.menuName = menuName;
		this.dateCreated = dateCreated;
		this.dateUpdated = dateUpdated;
		this.status = status;
		this.danhSachMucMenu = danhSachMucMenu;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public Date getDateUpdated() {
		return dateUpdated;
	}

	public void setDateUpdated(Date dateUpdated) {
		this.dateUpdated = dateUpdated;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<MenuItem> getDanhSachMucMenu() {
		return danhSachMucMenu;
	}

	public void setDanhSachMucMenu(List<MenuItem> danhSachMucMenu) {
		this.danhSachMucMenu = danhSachMucMenu;
	}
    
    
}
