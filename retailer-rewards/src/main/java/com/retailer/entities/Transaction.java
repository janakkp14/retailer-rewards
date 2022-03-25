package com.retailer.entities;

import java.math.BigDecimal;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * 
 * @author Janak Patel
 */

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@NamedQuery(name = "Transaction.findAllCustomers",
query = "select distinct t.customerId from Transaction t")
@Table(name = "Transaction") 
public class Transaction {
	@Id
	private String transactionId;
	
	private String customerId;
	
	private String customerName;
	
	private BigDecimal transactionAmount;
	
	private Date transactionDate;

	@Override
	public String toString() {
		return "Transaction [transactionId=" + transactionId + ", customerId=" + customerId + ", customerName="
				+ customerName + ", transactionAmount=" + transactionAmount + ", transactionDate=" + transactionDate
				+ "]";
	}
}
