package com.jarvis


class Customer {
	
	String firstName
	String lastName
	Long phone 
	String email
	Integer totalPoints
	static hasMany= [awards:Award, onlineOrders:OnlineOrder]

    static constraints = {
    }
}
