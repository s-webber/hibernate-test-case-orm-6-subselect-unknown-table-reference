package org.hibernate.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class TableTwoEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "three", nullable = true)
	private TableThreeEntity three;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public TableThreeEntity getThree() {
		return three;
	}

	public void setThree(TableThreeEntity three) {
		this.three = three;
	}
}
