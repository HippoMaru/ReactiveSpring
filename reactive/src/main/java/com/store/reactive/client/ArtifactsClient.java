package com.store.reactive.client;

import com.store.reactive.entity.Artifact;
import reactor.core.publisher.Flux;

public interface ArtifactsClient {
    Flux<Artifact> findAllArtifacts(String filter);
}
