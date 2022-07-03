package com.triple.mileage.controller;

import com.triple.mileage.dto.UserPointLogResponseDTO;
import com.triple.mileage.dto.UserPointResponseDTO;
import com.triple.mileage.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/point")
    public ResponseEntity<UserPointResponseDTO> showUserPoint(@RequestParam String userId) {
        return ResponseEntity.ok(userService.showUserPoint(userId));
    }

    @GetMapping("/pointLog")
    public ResponseEntity<UserPointLogResponseDTO> showUserPointLog(@RequestParam String userId) {
        return ResponseEntity.ok(userService.showUserPointLog(userId));
    }
}
