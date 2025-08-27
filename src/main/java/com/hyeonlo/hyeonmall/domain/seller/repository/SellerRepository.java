package com.hyeonlo.hyeonmall.domain.seller.repository;


import com.hyeonlo.hyeonmall.domain.seller.domain.Seller;
import com.hyeonlo.hyeonmall.domain.seller.enums.SellerStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SellerRepository extends JpaRepository<Seller, Long> {
    List<Seller> findAllByStatus(SellerStatus sellerStatus);

    void updateStatus(Long sellerId, SellerStatus sellerStatus);
}
