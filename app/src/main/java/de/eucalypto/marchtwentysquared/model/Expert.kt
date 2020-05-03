package de.eucalypto.marchtwentysquared.model

import java.io.Serializable

data class Expert(
    val firstName: String = "",
    val lastName: String = "",
    val phone: String = "",
    val profilePicture: String = "",
    val email: String = ""
) : Serializable
