package com.example.cleanarchitecture_mvvm.data.model

import com.example.cleanarchitecture_mvvm.domain.model.GithubRepo
import com.google.gson.annotations.SerializedName

data class GithubRepoRes(
    @SerializedName("name")
    private val _name: String,
    @SerializedName("id")
    private val _id: String,
    @SerializedName("created_at")
    private val _date: String,
    @SerializedName("html_url")
    private val _url: String
) : GithubRepo {
    override val name: String
        get() = _name
    override val url: String
        get() = _url
}
