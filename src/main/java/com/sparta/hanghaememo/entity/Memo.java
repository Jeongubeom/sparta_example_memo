package com.sparta.hanghaememo.entity;

import com.sparta.hanghaememo.dto.MemoRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Entity
@NoArgsConstructor

//데이터 테이블 역할을 하는 entity부분 초기설정 완료
public class Memo extends Timestamped {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id; //priate ket 부분인 id

    @Column(nullable = false)
    private String username; //private key 부분인 userName

    @Column(nullable = false)
    private String contents; //private key 부분인 contents

    public Memo(MemoRequestDto requestDto) {
        this.username = requestDto.getUsername();
        this.contents = requestDto.getContents();
    }

    public Memo(String username, String contents) {
        this.username = username;
        this.contents = contents;
    }
    public void update(MemoRequestDto requestDto) {
        this.username = requestDto.getUsername(); //requestDto로 값을 입력받아서 Memo의 username과 contents 값에 넣어줘서 수정
        this.contents = requestDto.getContents();
    }


}