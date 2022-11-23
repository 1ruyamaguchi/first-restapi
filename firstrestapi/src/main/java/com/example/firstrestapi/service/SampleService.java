package com.example.firstrestapi.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.firstrestapi.dto.InputDto;
import com.example.firstrestapi.dto.OutputDto;
import com.example.firstrestapi.dto.UpdateDto;

/**
 * サンプルのサービスインターフェース CURDをそれぞれ定義する
 * 
 */
@Service
@RestController
@RequestMapping("/sample")
public interface SampleService {

    /**
     * 入力情報をDBに登録する 返却値は登録成否のメッセージ
     * 
     * @param inputDto
     */
    @PostMapping(value = "/post")
    String postSample(@RequestBody InputDto inputDto);

    /**
     * 名前を指定してあいまい検索で登録情報を取得する
     * 
     * @param userName
     * @return
     */
    @GetMapping(value = "/get")
    List<OutputDto> getSample(String userName);

    /**
     * 入力情報をもとにDBを更新 返却値は更新成否のメッセージ
     * 
     * @param inputDto
     */
    @PutMapping(value = "/put")
    String putSample(@RequestBody UpdateDto updateDto);

    /**
     * IDを指定して登録情報を削除する 返却値は削除成否のメッセージ
     * 
     * @param userId
     * @return
     */
    @DeleteMapping(value = "/delete")
    String deleteSample(String userId);
}
