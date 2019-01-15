package br.com.projuris.challengealgorithm.entities;

import java.math.BigDecimal;

public class CostDepartment {
	private String department;
	private BigDecimal cost;

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public BigDecimal getCost() {
		return cost;
	}

	public void setCost(BigDecimal cost) {
		this.cost = cost;
	}
}
