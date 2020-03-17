package de.eucalypto.marchtwentysquared

data class Expert(
    val firstName: String,
    val lastName: String,
    val phone: String,
    val profilePicture: Int = R.drawable.avatar01,
    val email: String = "${firstName.toLowerCase()}.${lastName.toLowerCase()}@eucalypto.de"
)
