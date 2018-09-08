package com.example.asus.myapplication;

public class EmpoyeePartTime extends Employee {
    @Override
    public double TinhLuong() {
        return 150;
    }

    @Override
    public String toString() {
        return super.toString() + "--> Part Time = "+TinhLuong();
    }
}
