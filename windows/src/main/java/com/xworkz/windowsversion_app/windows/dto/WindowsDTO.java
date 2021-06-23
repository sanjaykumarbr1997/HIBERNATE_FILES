package com.xworkz.windowsversion_app.windows.dto;

	import java.io.Serializable;

	import javax.persistence.Column;
	import javax.persistence.Entity;
	import javax.persistence.GeneratedValue;
	import javax.persistence.GenerationType;
	import javax.persistence.Id;
	import javax.persistence.Table;
	@Entity
	@Table(name ="=windows_table")
	public class  WindowsDTO implements Serializable{
		@Id
		@Column(name="id")
		@GeneratedValue(strategy = GenerationType.AUTO)
		private int id;
		@Column(name="windows_name")
		private String name;
		@Column(name ="windows_releaseYear")
		private String year;
		@Column(name ="windows_new_features")
		private String newFeatures;
		@Override
		public String toString() {
			return "WindowsDTO [id=" + id + ", name=" + name + ", year=" + year + ", newFeatures=" + newFeatures + "]";
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
		public String getYear() {
			return year;
		}
		public void setYear(String year) {
			this.year = year;
		}
		public String getNewFeatures() {
			return newFeatures;
		}
		public void setNewFeatures(String newFeatures) {
			this.newFeatures = newFeatures;
		}
		
		

}
