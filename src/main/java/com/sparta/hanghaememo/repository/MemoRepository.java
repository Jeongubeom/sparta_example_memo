package com.sparta.hanghaememo.repository;


import com.sparta.hanghaememo.entity.Memo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MemoRepository extends JpaRepository<Memo, Long> { //JpaRepository의 상속을 받아서 MemoRepository와 데이터베이스와 연결
    List<Memo> findAllByOrderByModifiedAtDesc(); //List<Memo>안으로 값이 들어오면 최신순으로 데이터 정리, 내임차순으로 정리
}