package com.sparta.hanghaememo.service;


import com.sparta.hanghaememo.dto.MemoRequestDto;
import com.sparta.hanghaememo.entity.Memo;
import com.sparta.hanghaememo.repository.MemoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service //이 부분은 서비스라는 것을 알려주는 표식!! 같은거
@RequiredArgsConstructor
public class MemoService {

    private final MemoRepository memoRepository; // 데이터베이스와 연결하는 부분

    @Transactional
    public Memo createMemo(MemoRequestDto requestDto) {
        Memo memo = new Memo(requestDto);
        memoRepository.save(memo); //memoRepository에 .save연산자로(memo) 값을 넣어주면 자동으로 쿼리가 생성되면서 db에 연결되어 저장
        return memo;
    }

    @Transactional(readOnly = true)
    public List<Memo> getMemos(){ //MemoRepository에 연결을 해서 findAll로 가지고 온다 저장된데이터를!!
        return memoRepository.findAllByOrderByModifiedAtDesc(); //가져온 데이터 내림차순 정리
    }

    @Transactional
    public Long update(Long id, MemoRequestDto requestDto) {
        Memo memo = memoRepository.findById(id).orElseThrow( //수정을 할때는 findById(id)을 통하여 해당 id가 데이터 베이스에 있는지 확인 후 수정
                                                             //orElseThrow로 예외처리
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다.") //IllegalArgumentException(예외발생시) 아이디가 존재하지 않습니다
        );
        memo.update(requestDto); //memo에 있는 값을 update메소드로 requestDto에 있는 값으로 수정// entity안에 memo에 update 메소드에서 실행
        return memo.getId();
    }

    @Transactional
    public Long deleteMemo(Long id) {
        memoRepository.deleteById(id); //deleteById 이 메소드로 id메소드에서 생성한 값을 넣어서 삭제
        return id;
    }

}