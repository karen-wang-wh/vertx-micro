package com.karen

import io.vertx.kotlin.coroutines.CoroutineVerticle
import io.vertx.servicediscovery.ServiceDiscovery
import io.vertx.servicediscovery.ServiceDiscoveryOptions

class MainVerticle : CoroutineVerticle() {
    override suspend fun start() {
        println(config.encodePrettily())
        ServiceDiscovery.create(
            vertx,
            ServiceDiscoveryOptions(config)
        )
    }
}