package com.sparta.hanghaememo.dto;

import lombok.Getter;

@Getter
public class MemoRequestDto {
    private String username; //클라이언트에서 보내는 username을 이 곳을 통해서 서버가 받음
    private String contents; //클라이언트에서 보내는 contents를 이 곳을 통해서 서버가 받음
}