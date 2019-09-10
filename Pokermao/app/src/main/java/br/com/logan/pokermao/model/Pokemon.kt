package br.com.logan.pokermao.model

data class Pokemon (
    @SerializedName("number") val numero: String,
    @SerializedName("name") val nome : String,
    @SerializedName("imageURL") val urlImage : String
)