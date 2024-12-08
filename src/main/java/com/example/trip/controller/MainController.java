package com.example.trip.controller;

import com.example.trip.dto.Board;
import com.example.trip.dto.Item;
import com.example.trip.service.BoardService;
import com.example.trip.service.ItemApiService;
import com.example.trip.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class MainController {
    private final ItemApiService itemApiService;
    private final BoardService boardService;

    @GetMapping("/")
    public String index(Model model){

        //API를 통해 각 카테고리별 데이터 가져오기
        List<Item> tripList = itemApiService.searchItem("여행");
        //최근 게시글 4개 가져오기
        List<Board> recentBoard = boardService.getPosts(4);

        //배열 선언
        List<Item> tripItems1 = new ArrayList<>();
        List<Item> tripItems2 = new ArrayList<>();
        List<Item> tripItems3 = new ArrayList<>();
        List<Item> tripItems4 = new ArrayList<>();

        if (tripList.size() > 5) {
            tripItems1 = tripList.subList(0, 8);   //0번이미지 ~ 7번이미지(8개)
            tripItems2 = tripList.subList(8, 17);  //8번이미지 ~ 16번이미지(8개)
            tripItems3 = tripList.subList(17, 25);  //17번이미지 ~ 24번이미지(8개)
            tripItems4 = tripList.subList(25, 32);  //25번이미지 ~ 31번이미지(8개)
        } else {
            tripItems1 = tripList;
        }
        model.addAttribute("tripItems1", tripItems1);
        model.addAttribute("tripItems2", tripItems2);
        model.addAttribute("tripItems3", tripItems3);
        model.addAttribute("tripItems4", tripItems4);
        model.addAttribute("recentBoard", recentBoard);


        return "index";
    }
}
