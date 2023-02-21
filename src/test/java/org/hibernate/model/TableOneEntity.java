package org.hibernate.model;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class TableOneEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	@OneToMany(mappedBy = "three", cascade = CascadeType.ALL, orphanRemoval = true)
	@LazyCollection(LazyCollectionOption.FALSE)
	@Fetch(value = FetchMode.SUBSELECT)
	private List<TableTwoEntity> twos = new ArrayList<>();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<TableTwoEntity> getTwos() {
		return twos;
	}

	public void setTwos(List<TableTwoEntity> twos) {
		this.twos = twos;
	}
}
