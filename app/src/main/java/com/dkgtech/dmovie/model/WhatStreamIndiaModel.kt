package com.dkgtech.dmovie.model

data class WhatStreamIndiaModel(
    val data: List<DataModel>,
    val message: String,
    val status: Boolean,
    val timestamp: Long
)

data class DataModel(
    val edges: List<Edge>,
    val providerName: String
)

data class Edge(
    val titleModel: TitleModel
)

data class TitleModel(
    val canRateTitle: CanRateTitle,
    val id: String,
    val isAdult: Boolean,
    val originalTitleText: OriginalTitleText,
    val primaryImage: PrimaryImage,
    val ratingsSummary: RatingsSummary,
    val releaseYear: ReleaseYear,
    val titleEpisode: Any,
    val titleText: TitleText,
    val titleType: TitleType
)

data class TitleType(
    val canHaveEpisodes: Boolean,
    val categories: List<Category>,
    val displayableProperty: DisplayableProperty,
    val id: String,
    val isEpisode: Boolean,
    val isSeries: Boolean,
    val text: String
)

data class TitleText(
    val text: String
)

data class Category(
    val id: String,
    val text: String,
    val value: String
)

data class CanRateTitle(
    val isRatable: Boolean
)

data class DisplayableProperty(
    val value: Value
)

data class OriginalTitleText(
    val text: String
)

data class PrimaryImage(
    val id: String,
    val imageHeight: Int,
    val imageUrl: String,
    val imageWidth: Int
)

data class RatingsSummary(
    val aggregateRating: Double,
    val topRanking: TopRanking,
    val voteCount: Int
)

data class ReleaseYear(
    val endYear: Int,
    val year: Int
)

data class TopRanking(
    val rank: Int
)

data class Value(
    val plainText: String
)
