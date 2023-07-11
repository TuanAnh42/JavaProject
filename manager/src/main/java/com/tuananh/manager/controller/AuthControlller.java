package com.tuananh.manager.controller;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = {"api/v1/manager"})
@ComponentScan
public class AuthControlller {

}
