package com.hyeonlo.hyeonmall.domain.admin.service;

import com.hyeonlo.hyeonmall.domain.admin.domain.Admin;
import com.hyeonlo.hyeonmall.domain.admin.dto.CreateAdminRequest;
import com.hyeonlo.hyeonmall.domain.admin.dto.response.CreateAdminResponse;
import com.hyeonlo.hyeonmall.domain.admin.dto.response.SellerPendingResponse;
import com.hyeonlo.hyeonmall.domain.admin.repository.AdminRepository;
import com.hyeonlo.hyeonmall.domain.seller.domain.Seller;
import com.hyeonlo.hyeonmall.domain.seller.service.SellerService;
import com.hyeonlo.hyeonmall.global.utils.PasswordEncoder;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AdminService {

    private final AdminRepository adminRepository;
    private final PasswordEncoder passwordEncoder;
    private final SellerService sellerService;

    //최초 관리자 생성
    @Transactional
    public CreateAdminResponse createAdmin(CreateAdminRequest request) {

        if(adminRepository.existByLoginId(request.getLoginId())){
            throw new IllegalArgumentException("이미 존재하는 관리자 아이디입니다.");
        }

        String password = passwordEncoder.encode(request.getPassword());

        Admin admin = Admin.of(request.getLoginId(), password, request.getAdminName());

        adminRepository.save(admin);

        return new CreateAdminResponse(admin.getAminId());
    }

    //판매자 신청 목록 조회
    public List<SellerPendingResponse> getSellerPendingList() {

        List<Seller> pendingSellers = sellerService.getPendingSellers();

        List<SellerPendingResponse> responseList = new ArrayList<>();

        for(Seller seller : pendingSellers) {
            SellerPendingResponse response = SellerPendingResponse.of(seller.getSellerId(), seller.getShopName());
            responseList.add(response);
        }

        return responseList;
    }

    //판매자 승인
    @Transactional
    public void approveSeller(Long sellerId) {
        Seller seller = sellerService.getSellerById(sellerId);
        sellerService.approveSeller(seller);
    }
}