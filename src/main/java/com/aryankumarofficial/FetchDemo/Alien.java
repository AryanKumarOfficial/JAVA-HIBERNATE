package com.aryankumarofficial.FetchDemo;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Alien {

	@Id
	private int aid;
	private String aname;
	@OneToMany
	private Collection<Laptop> laptops = new ArrayList<Laptop>();

	public int getAid() {
		return aid;
	}

	public void setAid(int aid) {
		this.aid = aid;
	}

	public String getAname() {
		return aname;
	}

	public void setAname(String aname) {
		this.aname = aname;
	}

	public Collection<Laptop> getLaptops() {
		return laptops;
	}

	public void setLaptops(Collection<Laptop> laptops) {
		this.laptops = laptops;
	}

}
