package com.project.project1.records.request;

import jakarta.validation.constraints.Min;

public record CreateTaskRequest(
        @Min(5)
        String title
) {}
