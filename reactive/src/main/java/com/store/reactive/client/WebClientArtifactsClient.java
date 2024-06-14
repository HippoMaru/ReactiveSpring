package com.store.reactive.client;

import com.store.reactive.entity.Artifact;
import lombok.RequiredArgsConstructor;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

@RequiredArgsConstructor
public class WebClientArtifactsClient implements ArtifactsClient {

    private final WebClient webClient;
    @Override
    public Flux<Artifact> findAllArtifacts(String filter) {
        return this.webClient.get()
                .uri("/store-api/products?filter={filter}", filter)
                .retrieve()
                .bodyToFlux(Artifact.class);
    }
}
