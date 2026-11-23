package com.josamtechie.controller;

import com.josamtechie.service.OpenAIChatService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/openai/api")
public class OpenAIChatController
{
    private final OpenAIChatService service;

    public OpenAIChatController(OpenAIChatService service)
    {
        this.service = service;
    }

    @GetMapping("/chat")
    public String chat(@RequestParam String message)
    {
        return service.chatWithOpenAILLM(message);
    }
}
