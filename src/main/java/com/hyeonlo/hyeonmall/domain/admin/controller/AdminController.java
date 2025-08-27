package com.hyeonlo.hyeonmall.domain.admin.controller;

import com.hyeonlo.hyeonmall.domain.admin.dto.CreateAdminRequest;
import com.hyeonlo.hyeonmall.domain.admin.dto.response.CreateAdminResponse;
import com.hyeonlo.hyeonmall.domain.admin.dto.response.SellerPendingResponse;
import com.hyeonlo.hyeonmall.domain.admin.service.AdminService;

import com.hyeonlo.hyeonmall.domain.admin.status.AdminSuccessStatus;
import com.hyeonlo.hyeonmall.global.payload.BaseResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class AdminController {

    private final AdminService adminService;
    /**
     * TODO: 관리자 기능 구현
     * - 상품 관리 (수정, 삭제)
     * - 유저 관리 (전체 유저 리스트 강제 탈퇴, 권한 변경)
     * - 판매자 관리 (승인, 거절, 정지, 조회)
     * - 리뷰 관리 (삭제)
     * - 쿠폰 이벤트 관리
     * - 공지사항
     * - 관리자 로그
     */

    //최초 관리자 생성 후 기능 삭제
    @PostMapping("/v1/admins")
    public BaseResponse<CreateAdminResponse> createAdmin(@RequestBody CreateAdminRequest request) {
        CreateAdminResponse response = adminService.createAdmin(request);
        return BaseResponse.adminSuccess(AdminSuccessStatus.ADMIN_SUCCESS_STATUS, response);
    }

    //판매자(셀러) 관리
    //1 - 1 판매자 신청 목록 조회
    @GetMapping("/v1/admins/sellers")
    public BaseResponse<List<SellerPendingResponse>> getSellerPendingList() {
        List<SellerPendingResponse> response = adminService.getSellerPendingList();
        return BaseResponse.adminSuccess(AdminSuccessStatus.SELLER_PENDING_LIST_SUCCESS, response);
    }

    //1 - 2 판매자 신청 승인
    @PostMapping("/v1/admins/sellers/{sellerId}/approve")
    public BaseResponse<Void> approveSeller(/*관리자 인증 토큰 , */@PathVariable Long sellerId) {
        adminService.approveSeller(sellerId);
        return BaseResponse.adminSuccess(AdminSuccessStatus.SELLER_APPROVE_SUCCESS, null);
    }
    //1 - 3 판매자 신청 거절
    //1 - 4 판매자 정지
    //1 - 5 판매자 정지 해제
}