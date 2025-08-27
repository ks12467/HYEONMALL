package com.hyeonlo.hyeonmall.domain.admin.dto.response;

import lombok.Getter;

@Getter
public class CreateAdminResponse {

    private final Long adminId;

    public CreateAdminResponse(Long adminId) {
        this.adminId = adminId;
    }
}