package br.com.projuris.challengealgorithm.entities;

import java.math.BigDecimal;

public class Employee {
	private String office;
	private String department;
	private BigDecimal salary;

	public Employee(String office, String department, BigDecimal salary) {
		this.office = office;
		this.department = department;
		this.salary = salary;
	}

	public String getOffice() {
		return office;
	}

	public void setOffice(String office) {
		this.office = office;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public BigDecimal getSalary() {
		return salary;
	}

	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}
}
