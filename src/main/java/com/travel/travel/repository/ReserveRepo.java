package com.travel.travel.repository;

import com.travel.travel.entity.Reserve;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ReserveRepo extends CrudRepository<Reserve,Long> {

    @Query(value = "SELECT * FROM reserve r WHERE r.customerid = 'customerIdd'",
            nativeQuery=true
    )
    List<Reserve> findByReservationAuthorId(@Param("searchTerm") Long customerIdd);

}
