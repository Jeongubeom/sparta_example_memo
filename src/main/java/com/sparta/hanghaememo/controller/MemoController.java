package com.sparta.hanghaememo.controller;


import com.sparta.hanghaememo.dto.MemoRequestDto;
import com.sparta.hanghaememo.entity.Memo;
import com.sparta.hanghaememo.service.MemoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MemoController {

    private final MemoService memoService;

    @GetMapping("/") //메인페이지
    public ModelAndView home() {
        return new ModelAndView("index"); // 객체를 생성해서 templates에 반환할 값을 넣어줄 수 있고, html(클라이언트)부분에 반환할 값을 넣어줄 수 있는데 그때는 html파일 이름을 넣어야한다
    }

    @PostMapping("/api/memos") //메모 생성
    public Memo creatMemo(@RequestBody MemoRequestDto requestDto) { //객체형식으로 값이 post형식으로 넘어오니깐 @RequestBody를 사용함
        return memoService.createMemo(requestDto); //클라이언트에서 가져 온 requestDto 안에 있는 값을 파라미터에 입력해서 사용
    }
    @GetMapping("/api/memos")
    public List<Memo> getMemos(){
        return memoService.getMemos();
    }

    @PutMapping("/api/memos/{id}") //pathVariable 방식으로 id값을 송수신
    public Long updateMemo(@PathVariable Long id, @RequestBody MemoRequestDto requestDto){
        return memoService.update(id, requestDto);
    }

    @DeleteMapping("api/memos/{id}") //pathVariable 방식으로 id값을 송수신
    public Long deleteMemo(@PathVariable Long id){
        return memoService.deleteMemo(id);
    }
}