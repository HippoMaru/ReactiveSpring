package com.store.reactive.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import reactor.core.publisher.Mono;
import com.store.reactive.client.ArtifactsClient;

@Controller
@RequiredArgsConstructor
@RequestMapping("store/artifacts")
public class ArtifactsController {

    private ArtifactsClient artifactsClient;

    @GetMapping("list")
    public Mono<String> getArtifactsListPage(Model model,
                                             @RequestParam(name = "filter", required = false) String filter) {
        return this.artifactsClient.findAllArtifacts(filter)
                .collectList()
                .doOnNext(artifacts -> model.addAttribute("artifacts", artifacts))
                .thenReturn("store/artifacts/list");
    }
}
