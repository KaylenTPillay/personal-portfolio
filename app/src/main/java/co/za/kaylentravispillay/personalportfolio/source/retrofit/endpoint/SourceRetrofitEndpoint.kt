package co.za.kaylentravispillay.personalportfolio.source.retrofit.endpoint

object SourceRetrofitEndpoint {
    private const val GITHUB_BASE_URL = "https://api.github.com/"

    const val BASE_URL = "https://6172aff6-7f4a-495c-a8f2-5b5aff36010b.mock.pstmn.io/"

    const val ABOUT_ME = "aboutme/{userId}"
    const val ABOUT_ME_PROFILE = "aboutme/{userId}/profile"

    const val GITHUB_USER_REPOSITORIES = "${GITHUB_BASE_URL}users/{username}/repos"
}