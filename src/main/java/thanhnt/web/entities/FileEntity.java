//package thanhnt.web.entities;
//
//import jakarta.persistence.Column;
//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//import jakarta.persistence.Table;
//
//@Entity
//@Table(name = "files")
//public class FileEntity {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name="id")
//    private Long id;
//    @Column(name="fileName")
//    private String fileName;
//    @Column(name="filePath")
//    private String filePath;
//    @Column(name="description")
//    private String description;
//	public Long getId() {
//		return id;
//	}
//	public void setId(Long id) {
//		this.id = id;
//	}
//	public String getFileName() {
//		return fileName;
//	}
//	public void setFileName(String fileName) {
//		this.fileName = fileName;
//	}
//	public String getFilePath() {
//		return filePath;
//	}
//	public void setFilePath(String filePath) {
//		this.filePath = filePath;
//	}
//	public String getDescription() {
//		return description;
//	}
//	public void setDescription(String description) {
//		this.description = description;
//	}
//    
//	
//}
