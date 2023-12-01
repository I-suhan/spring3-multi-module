package com.suhan.config.analyzer;

import org.springframework.boot.diagnostics.FailureAnalysis;
import org.springframework.boot.diagnostics.FailureAnalyzer;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SuFailureAnalyzer implements FailureAnalyzer {
    @Override
    public FailureAnalysis analyze(Throwable failure) {
        return null;
    }
}
