package com.example.demo.models;

import org.springframework.stereotype.Component;

@Component
public class ThongKe {
    private int month;
    private int cost;

    public ThongKe() {
    }

    public ThongKe(int month, int cost) {
        this.month = month;
        this.cost = cost;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

	@Override
	public String toString() {
		return "ThongKe [month=" + month + ", cost=" + cost + "]";
	}
    
}
