package com.hyeonlo.hyeonmall.domain.seller.service;

import com.hyeonlo.hyeonmall.domain.seller.domain.Seller;
import com.hyeonlo.hyeonmall.domain.seller.enums.SellerStatus;
import com.hyeonlo.hyeonmall.domain.seller.repository.SellerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SellerService {

    private final SellerRepository sellerRepository;

    //판매자 신청 목록 조회
    public List<Seller> getPendingSellers() {
        return sellerRepository.findAllByStatus(SellerStatus.PENDING);
    }

    //판매자 승인
    public Seller getSellerById(Long sellerId) {
        return sellerRepository.findById(sellerId)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 판매자입니다."));
    }

    //판매자 승인 처리
    public void approveSeller(Seller seller) {
        if(seller.getStatus().equals(SellerStatus.APPROVED)) {
            throw new IllegalArgumentException("이미 승인된 판매자입니다.");
        }

        if(seller.getStatus().equals(SellerStatus.REJECTED)) {
            throw new IllegalArgumentException("거절된 판매자입니다.");
        }

        seller.approve();
        sellerRepository.save(seller);
    }
}