package jana60.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;



	@Entity
	@Table(name = "teachers")
	public class Insegnanti {
		
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Integer id;
		
        private String name;
		
		private String surname;
		
		private String phone;
		
		private String email;
		
		private String officeAddress;
		

		public String getOfficeAddress() {
			return officeAddress;
		}

		public void setOfficeAddress(String officeAddress) {
			this.officeAddress = officeAddress;
		}

//		public List<Insegnanti> getTeachers() {
//			return teachers;
//		}
//
//		public void setTeachers(List<Insegnanti> teachers) {
//			this.teachers = teachers;
//		}

//		@ManyToMany
//		@JoinTable(
//		name="course_teachers",
//		joinColumns = { @JoinColumn(name = "course_id") },
//		inverseJoinColumns = { @JoinColumn(name = "teacher_id") }
//		)
//		
//		private List<Insegnanti> teachers;
//		
//		
	  
		@ManyToMany         //nome tabella        //foreignkey dell'altra tabella (tabella ponte)            //foreignkey di questa tabella
		@JoinTable(name = "course_teacher", joinColumns = { @JoinColumn(name = "teacher_id") }, inverseJoinColumns = { @JoinColumn(name = "course_id") })		
		private List<courses> ListaCorsi;
		
		
		public List<courses> getListaCorsi() {
			return ListaCorsi;
		}

		public void setListaCorsi(List<courses> listaCorsi) {
			ListaCorsi = listaCorsi;
		}

		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getSurname() {
			return surname;
		}

		public void setSurname(String surname) {
			this.surname = surname;
		}

		public String getPhone() {
			return phone;
		}

		public void setPhone(String phone) {
			this.phone = phone;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public boolean isPresent() {
			// TODO Auto-generated method stub
			return false;
		}

		
		


	}


