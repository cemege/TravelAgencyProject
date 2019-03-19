package com.travel.travel.services;

import com.travel.travel.entity.Hotel;
import com.travel.travel.entity.Reserve;
import com.travel.travel.repository.ReserveRepo;
import com.travel.travel.viewmodel.HotelDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;
import java.util.Optional;

@Service
public class ReserveService {

    @Autowired
    ReserveRepo reserveRepo;



    public Iterable<Reserve> getAllRevers(){

        return reserveRepo.findAll();
    }

    public List<Reserve> getUsersReserve(Long customerId){
        return reserveRepo.findByReservationAuthorId(customerId);
    }


    public void saveService(Reserve reserve) {
        reserveRepo.save(reserve);
    }

    public Optional<Reserve> findById(long id) {
        return reserveRepo.findById(id);
    }

    public void deleteReserve(Reserve reserve) {
        reserveRepo.delete(reserve);
    }
}
