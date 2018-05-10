package com.travel.travel.repository;

import com.travel.travel.entity.Reserve;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ReserveRepo extends CrudRepository<Reserve,Long> {


    List<Reserve> findByReservationAuthorId(Long customerid);

}
