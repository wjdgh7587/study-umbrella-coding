/*
 * ResultCode.java
 *
 *
 * 15/06/21, 02:00 PM
 *
 *
 * Copyright (c) 2021 NURIFLEX, Inc.
 * All rights reserved.
 *
 *
 * This software is the confidential and proprietary information of NURIFLEX, Inc. ("Confidential Information").
 * You shall not disclose such Confidential Information and shall use it only in accordance with the terms of the license agreement you entered into with NURIFLEX, Inc.
 *
 *
 * For more information on this product, please see
 * http://www.nuritelecom.co.kr
 *
 */

package com.jeongho.template.entity.enums;

import lombok.AllArgsConstructor;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@AllArgsConstructor
public enum BaseResultErrorCode {

  /* 400 BadRequest */
  MANDATORY_PARAM_ERROR(),
  INVALID_PARAM_ERROR(),
  BAD_FORMAT_ERROR(),
  BAD_REQUEST_ERROR(),

  /* 401 Unauthenticated (인증) */
  LOGIN_REQUIRED(),
  AUTHCODE_CHECK_REQUIRED(),
  EXPIRED_AUTHCODE(),
  ALREADY_AUTHENTICATED_ERROR(),
  AUTHENTICATION_FAILED_ERROR(),

  /* 403 Forbidden(Unauthorized) (토큰관련)  */
  EXPIRED_TOKEN_ERROR(),
  INVALID_TOKEN_ERROR(),
  FORBIDDEN_TO_ERROR(),
  FORBIDDEN_ERROR(),

  /* 404 Not Found */
  RESOURCE_NOT_FOUND(),

  /* 500 Internal Server Error */
  QUERY_FAILED(),
  REGISTRATION_FAILED(),
  GENERATION_FAILED(),
  MODIFICATION_FAILED(),
  REMOVAL_FAILED(),
  DUPLICATED_ERROR(),
  ENTITY_NOT_FOUND(),
  INVALID_ENTITY_ERROR(),
  EXTERNAL_SERVER_ERROR(),
  INTERNAL_SERVER_ERROR()
  ;

//  /* 400 Bad Request */
//  NO_NEED_TO_UPDATE(),
//
//  /* 403 Unauthorized */
//  TOKEN_EXPIRED_ERROR(),
//  TOKEN_INVALID_ERROR(),
//  TOKEN_ACCESS_DENIED(), // token 권한 에러
//  AUTHORIZED_ERROR(), // 기타 에러
//
//  /* 404 Not Found */
//  USER_NOT_FOUND(),
//  RESULT_NOT_FOUND(),
//  UDID_NOT_FOUND(),
//  NOT_FOUND_ERROR(),// 기타 에러
//
//  /* 500 Internal Server Error */
//  USER_REGISTRATION_ERROR(),
//  USERID_DUPLICATED_ERROR(),
//  USER_UPDATE_ERROR(),
//  INVALID_USER_INFO_ERROR(),
//  COMPANY_REGISTRATION_ERROR(),
//  COMPANY_DUPLICATED_ERROR(),
//  COMPANY_UPDATE_ERROR(),
//  COMPANY_DELETE_ERROR(),
//  INTERNAL_SERVER_ERROR(),
//  EXTERNAL_SERVER_ERROR(),
//  LOGIN_PASSWD_FAIL(),
//  UMS_SEND_FAIL(),
//  USER_ALREADY_EXISTS(),
//  USER_INACTIVE_ERROR(),
//  USER_WITHDRAWAL_ERROR(),
//  USER_FORCED_WITHDRAWAL_ERROR(),
//  USER_DELETED_ERROR(),
//  DUPLICATED_DATA_ERROR(),
//  USER_INFO_INVALID(),
//  UPDATE_ERROR(),
//  INSERT_ERROR();

  private static final Map<String, BaseResultErrorCode> lookup = Maps.uniqueIndex(
      Arrays.asList(BaseResultErrorCode.values()),
      BaseResultErrorCode::name
  );

//  private static final Map<String, BaseResultErrorCode> lookup =
//          Arrays.stream(BaseResultErrorCode.values())
//                  .collect(Collectors.toMap(Enum::name, Function.identity()));


  public static BaseResultErrorCode get(String name) {
    return lookup.get(name);
  }

}
