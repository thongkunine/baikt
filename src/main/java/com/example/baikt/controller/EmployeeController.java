package com.example.baikt.controller;

import com.example.baikt.model.Employee;
import com.example.baikt.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping("/employees")
    public String listEmployees(Model model, @RequestParam(defaultValue = "0") int page) {
        // Số lượng nhân viên trên mỗi trang
        int pageSize = 5;

        // Lấy danh sách nhân viên từ repository, phân trang
        Page<Employee> employeePage = employeeRepository.findAll(PageRequest.of(page, pageSize));

        // Danh sách nhân viên trên trang hiện tại
        List<Employee> employees = employeePage.getContent();

        // Tổng số trang
        int totalPages = employeePage.getTotalPages();

        // Số trang hiện tại
        int currentPage = employeePage.getNumber();

        model.addAttribute("employees", employees);
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("currentPage", currentPage);

        return "products-list"; // Đổi tên của file thymeleaf

    }
}
