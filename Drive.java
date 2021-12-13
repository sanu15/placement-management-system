package net.codejava;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Drive")
public class Drive {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "company_name", nullable = false, length = 100)
	private String companyName;
	
	@Column(name = "drive_date", nullable = false, length = 100)
	private String driveDate;
	
	@Column(name = "location", nullable = false, length = 100)
	private String location;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getDriveDate() {
		return driveDate;
	}

	public void setDriveDate(String driveDate) {
		this.driveDate = driveDate;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	@Override
	public String toString() {
		return "Drive [id=" + id + ", companyName=" + companyName + ", driveDate=" + driveDate + ", location="
				+ location + "]";
	}
	
}
