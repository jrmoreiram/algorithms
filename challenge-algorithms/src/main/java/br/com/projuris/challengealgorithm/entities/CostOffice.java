package br.com.projuris.challengealgorithm.entities;

import java.math.BigDecimal;

public class CostOffice {
	private String office;
	private BigDecimal cost;

	public String getOffice() {
		return office;
	}

	public void setOffice(String office) {
		this.office = office;
	}

	public BigDecimal getCost() {
		return cost;
	}

	public void setCost(BigDecimal cost) {
		this.cost = cost;
	}
}
