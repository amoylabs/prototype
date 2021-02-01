package com.bn.web;

import io.undertow.server.handlers.accesslog.AccessLogReceiver;
import lombok.extern.slf4j.Slf4j;

@Slf4j(topic = "UNDERTOW_ACCESS_LOG")
class Slf4jAccessLogReceiver implements AccessLogReceiver {
    @Override
    public void logMessage(String message) {
        log.info(message);
    }
}