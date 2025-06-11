package com.tourism.service;

import com.tourism.model.Transport;
import com.tourism.repository.TransportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransportService {

    @Autowired
    private TransportRepository transportRepository;

    public List<Transport> getAllTransports() {
        return transportRepository.findAll();
    }

    public Transport getTransportById(Long id) {
        return transportRepository.findById(id).orElse(null);
    }

    public Transport addTransport(Transport transport) {
        return transportRepository.save(transport);
    }

    public Transport updateTransport(Transport transport) {
        return transportRepository.save(transport);
    }

    public void deleteTransport(Long id) {
        transportRepository.deleteById(id);
    }
}