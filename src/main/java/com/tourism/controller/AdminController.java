package com.tourism.controller;

import com.tourism.model.Hotel;
import com.tourism.model.Package;
import com.tourism.model.User;
import com.tourism.model.Order;
import com.tourism.model.Vehicle;
import com.tourism.model.Food;
import com.tourism.model.Transport;
import com.tourism.service.HotelService;
import com.tourism.service.PackageService;
import com.tourism.service.UserService;
import com.tourism.service.OrderService;
import com.tourism.service.VehicleService;
import com.tourism.service.FoodService;
import com.tourism.service.TransportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private HotelService hotelService;

    @Autowired
    private PackageService packageService;

    @Autowired
    private UserService userService;

    @Autowired
    private OrderService orderService;

    @Autowired
    private VehicleService vehicleService;

    @Autowired
    private FoodService foodService;

    @Autowired
    private TransportService transportService;

    @GetMapping("/dashboard")
    public String adminDashboard() {
        return "admin-dashboard";
    }

    // Hotel Management
    @GetMapping("/hotels")
    public String manageHotels(Model model) {
        model.addAttribute("hotels", hotelService.getAllHotels());
        model.addAttribute("hotel", new Hotel()); // For add form
        return "manage-hotels";
    }

    @PostMapping("/hotels/add")
    public String addHotel(@ModelAttribute Hotel hotel) {
        hotelService.addHotel(hotel);
        return "redirect:/admin/hotels";
    }

    @PostMapping("/hotels/update")
    public String updateHotel(@ModelAttribute Hotel hotel) {
        hotelService.updateHotel(hotel);
        return "redirect:/admin/hotels";
    }

    @GetMapping("/hotels/delete/{id}")
    public String deleteHotel(@PathVariable Long id) {
        hotelService.deleteHotel(id);
        return "redirect:/admin/hotels";
    }

    // Package Management
    @GetMapping("/packages")
    public String managePackages(Model model) {
        model.addAttribute("packages", packageService.getAllPackages());
        model.addAttribute("package", new Package()); // For add form
        model.addAttribute("hotels", hotelService.getAllHotels()); // For selecting hotels in package
        return "manage-packages";
    }

    @PostMapping("/packages/add")
    public String addPackage(@ModelAttribute Package tourismPackage) {
        packageService.addPackage(tourismPackage);
        return "redirect:/admin/packages";
    }

    @PostMapping("/packages/update")
    public String updatePackage(@ModelAttribute Package tourismPackage) {
        packageService.updatePackage(tourismPackage);
        return "redirect:/admin/packages";
    }

    @GetMapping("/packages/delete/{id}")
    public String deletePackage(@PathVariable Long id) {
        packageService.deletePackage(id);
        return "redirect:/admin/packages";
    }

    // User Management
    @GetMapping("/users")
    public String manageUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        model.addAttribute("user", new User()); // For add/update form
        return "manage-users";
    }

    @PostMapping("/users/add")
    public String addUser(@ModelAttribute User user) {
        userService.registerUser(user);
        return "redirect:/admin/users";
    }

    @PostMapping("/users/update")
    public String updateUser(@ModelAttribute User user) {
        userService.updateUser(user);
        return "redirect:/admin/users";
    }

    @GetMapping("/users/delete/{id}")
    public String deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return "redirect:/admin/users";
    }

    // Order Management
    @GetMapping("/orders")
    public String manageOrders(Model model) {
        model.addAttribute("orders", orderService.getAllOrders());
        return "manage-orders";
    }

    @PostMapping("/orders/update")
    public String updateOrder(@ModelAttribute Order order) {
        orderService.updateOrder(order);
        return "redirect:/admin/orders";
    }

    @GetMapping("/orders/delete/{id}")
    public String deleteOrder(@PathVariable Long id) {
        orderService.deleteOrder(id);
        return "redirect:/admin/orders";
    }

    // Vehicle Management
    @GetMapping("/vehicles")
    public String manageVehicles(Model model) {
        model.addAttribute("vehicles", vehicleService.getAllVehicles());
        model.addAttribute("vehicle", new Vehicle());
        return "manage-vehicles";
    }

    @PostMapping("/vehicles/add")
    public String addVehicle(@ModelAttribute Vehicle vehicle) {
        vehicleService.addVehicle(vehicle);
        return "redirect:/admin/vehicles";
    }

    @PostMapping("/vehicles/update")
    public String updateVehicle(@ModelAttribute Vehicle vehicle) {
        vehicleService.updateVehicle(vehicle);
        return "redirect:/admin/vehicles";
    }

    @GetMapping("/vehicles/delete/{id}")
    public String deleteVehicle(@PathVariable Long id) {
        vehicleService.deleteVehicle(id);
        return "redirect:/admin/vehicles";
    }

    // Food Management
    @GetMapping("/foods")
    public String manageFoods(Model model) {
        model.addAttribute("foods", foodService.getAllFoods());
        model.addAttribute("food", new Food());
        return "manage-foods";
    }

    @PostMapping("/foods/add")
    public String addFood(@ModelAttribute Food food) {
        foodService.addFood(food);
        return "redirect:/admin/foods";
    }

    @PostMapping("/foods/update")
    public String updateFood(@ModelAttribute Food food) {
        foodService.updateFood(food);
        return "redirect:/admin/foods";
    }

    @GetMapping("/foods/delete/{id}")
    public String deleteFood(@PathVariable Long id) {
        foodService.deleteFood(id);
        return "redirect:/admin/foods";
    }

    // Transport Management
    @GetMapping("/transports")
    public String manageTransports(Model model) {
        model.addAttribute("transports", transportService.getAllTransports());
        model.addAttribute("transport", new Transport());
        model.addAttribute("vehicles", vehicleService.getAllVehicles()); // For selecting vehicle in transport
        return "manage-transports";
    }

    @PostMapping("/transports/add")
    public String addTransport(@ModelAttribute Transport transport) {
        transportService.addTransport(transport);
        return "redirect:/admin/transports";
    }

    @PostMapping("/transports/update")
    public String updateTransport(@ModelAttribute Transport transport) {
        transportService.updateTransport(transport);
        return "redirect:/admin/transports";
    }

    @GetMapping("/transports/delete/{id}")
    public String deleteTransport(@PathVariable Long id) {
        transportService.deleteTransport(id);
        return "redirect:/admin/transports";
    }
}