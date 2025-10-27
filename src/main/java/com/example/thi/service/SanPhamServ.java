package com.example.thi.service;

import java.util.ArrayList;
import java.util.List;

import com.example.thi.entity.SanPham;

public class SanPhamServ {
    private final List<SanPham> list = new ArrayList<>();

    // public SanPhamServ() {
    // list.add(new SanPham("Banh keo", 12.000F, "SP01", 2, 23, "Oreo"));
    // }

    public SanPham findByID(String id) {
        for (SanPham sp : list) {
            if (sp.getMa().equals(id)) {
                return sp;
            }
        }
        return null;
    }

    public List<SanPham> getAll() {
        return list;
    }

    public void add(SanPham sanPham) {
        if (sanPham.getMa() == null || sanPham.getMa().isEmpty()) {
            throw new IllegalArgumentException("Ma san pham khong duoc rong hoac null");
        }
        if (findByID(sanPham.getMa()) != null) {
            throw new IllegalArgumentException("Ma san pham khong duoc trung lap");
        }
        if (sanPham.getSoLuong() < 1 || sanPham.getSoLuong() > 100) {
            throw new IllegalArgumentException("So lhuong cua san pham phai >= 1 va <= 100");
        }
        list.add(sanPham);
    }

}
