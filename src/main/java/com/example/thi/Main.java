package com.example.thi;

import com.example.thi.entity.SanPham;
import com.example.thi.service.SanPhamServ;
import com.example.thi.utility.MathFunction;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        System.out.println(MathFunction.tongSoLe());
        SanPhamServ phamServ = new SanPhamServ();
        for (SanPham sp : phamServ.getAll()) {
            System.out.println(sp);
        }
    }
}