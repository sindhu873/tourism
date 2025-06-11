package com.tourism.controller;

import com.tourism.model.Order;
import com.tourism.model.Package;
import com.tourism.model.User;
import com.tourism.service.OrderService;
import com.tourism.service.PackageService;
import com.tourism.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/user")
public class CustomerController {

    @Autowired
    private PackageService packageService;

    @Autowired
    private OrderService orderService;

    @Autowired
    private UserService userService;

    @GetMapping("/dashboard")
    public String userDashboard() {
        return "user-dashboard";
    }

    @GetMapping("/packages")
    public String viewPackages(Model model) {
        model.addAttribute("packages", packageService.getAllPackages());
        return "user-packages";
    }

    @GetMapping("/package/book/{id}")
    public String bookPackage(@PathVariable Long id, Model model) {
        Package tourismPackage = packageService.getPackageById(id);
        if (tourismPackage != null) {
            model.addAttribute("package", tourismPackage);
            // In a real application, you'd get the logged-in user here
            // For now, let's assume a user with ID 1 exists or create one for testing
            User currentUser = userService.getUserById(1L); // Placeholder for logged-in user
            if (currentUser == null) {
                // Handle case where user does not exist (e.g., redirect to login)
                return "redirect:/login";
            }
            model.addAttribute("currentUser", currentUser);
            return "book-package";
        } else {
            return "redirect:/user/packages";
        }
    }

    @PostMapping("/package/confirm-book")
    public String confirmBooking(Long packageId, Long userId) {
        Package tourismPackage = packageService.getPackageById(packageId);
        User user = userService.getUserById(userId);

        if (tourismPackage != null && user != null) {
            Order order = new Order();
            order.setUser(user);
            order.setTourismPackage(tourismPackage);
            order.setOrderDate(LocalDate.now());
            order.setTotalPrice(tourismPackage.getPrice());
            order.setStatus("CONFIRMED"); // Or "PENDING" for payment processing
            orderService.placeOrder(order);
            return "redirect:/user/orders";
        } else {
            // Handle error, e.g., package or user not found
            return "redirect:/user/packages";
        }
    }

    @GetMapping("/orders")
    public String viewOrders(Model model) {
        // In a real application, you'd filter orders by logged-in user
        List<Order> orders = orderService.getAllOrders(); // Placeholder for user-specific orders
        model.addAttribute("orders", orders);
        return "user-orders";
    }
}