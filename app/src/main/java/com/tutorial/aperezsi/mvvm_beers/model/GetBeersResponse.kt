package com.tutorial.aperezsi.mvvm_beers.model

import java.io.Serializable

/**
 * Parent class
 */
data class BeerResponse (
    val id: Number?,
    val name: String?,
    val tagline: String?,
    val first_brewed: String?,
    val description: String?,
    val image_url: String?,
    val abv: Number?,
    val ibu: Number?,
    val target_fg: Number?,
    val target_og: Number?,
    val ebc: Number?,
    val srm: Number?,
    val ph: Number?,
    val attenuation_level: Number?,
    val volume: Volume?,
    val boil_volume: Boil_volume?,
    val method: Method?,
    val ingredients: Ingredients?,
    val food_pairing: List<String>?,
    val brewers_tips: String?,
    val contributed_by: String?
) : Serializable


/**
 * Secondary classes
 */
data class Amount(val value: Number?,
                  val unit: String?) : Serializable

data class Boil_volume(val value: Number?,
                       val unit: String?) : Serializable

data class Fermentation(val temp: Temp?) : Serializable

data class Hops(val name: String?,
                val amount: Amount?,
                val add: String?,
                val attribute: String?) : Serializable

data class Ingredients(val malt: List<Malt>?,
                       val hops: List<Hops>?,
                       val yeast: String?) : Serializable

data class Malt(val name: String?,
                val amount: Amount?) : Serializable

data class Mash_temp(val temp: Temp?,
                     val duration: Number?) : Serializable

data class Method(val mash_temp: List<Mash_temp>?,
                  val fermentation: Fermentation?,
                  val twist: Any?) : Serializable

data class Temp(val value: Number?,
                val unit: String?) : Serializable

data class Volume(val value: Number?,
                  val unit: String?) : Serializable
