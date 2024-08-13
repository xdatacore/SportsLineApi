package com.xdatacore.sportslineapi.models

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "counters")
data class Counter(
    @Id val id: String,
    var seq: Int
)
