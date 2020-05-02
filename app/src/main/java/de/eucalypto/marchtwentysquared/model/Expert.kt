package de.eucalypto.marchtwentysquared.model

import de.eucalypto.marchtwentysquared.R
import java.io.Serializable

data class Expert(
    val firstName: String = "",
    val lastName: String = "",
    val phone: String = "",
    val profilePicture: Int = R.drawable.avatar01,
    val email: String = ""
) : Serializable
