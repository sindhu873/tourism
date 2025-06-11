package com.tourism.service;

import com.tourism.model.Package;
import com.tourism.repository.PackageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PackageService {

    @Autowired
    private PackageRepository packageRepository;

    public List<Package> getAllPackages() {
        return packageRepository.findAll();
    }

    public Package getPackageById(Long id) {
        return packageRepository.findById(id).orElse(null);
    }

    public Package addPackage(Package tourismPackage) {
        return packageRepository.save(tourismPackage);
    }

    public Package updatePackage(Package tourismPackage) {
        return packageRepository.save(tourismPackage);
    }

    public void deletePackage(Long id) {
        packageRepository.deleteById(id);
    }
}