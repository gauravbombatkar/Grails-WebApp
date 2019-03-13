package com.jarvis

class Employee {
	
	String name
	String email
	String position
	Double salary 
	Date created = new Date()
	
	//static hasOne = [address:Address]
  
	static constraints = {
	  email email: true
	 // address unique: true
	}
}
