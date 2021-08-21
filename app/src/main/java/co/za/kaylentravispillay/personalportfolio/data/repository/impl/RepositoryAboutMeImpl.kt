package co.za.kaylentravispillay.personalportfolio.data.repository.impl

import co.za.kaylentravispillay.personalportfolio.data.dto.DTOResult
import co.za.kaylentravispillay.personalportfolio.data.dto.aboutme.DTOAboutMe
import co.za.kaylentravispillay.personalportfolio.data.dto.aboutme.DTOAboutMeProfile
import co.za.kaylentravispillay.personalportfolio.data.dto.aboutme.DTOAboutMeSection
import co.za.kaylentravispillay.personalportfolio.data.repository.RepositoryAboutMe
import kotlinx.coroutines.delay

class RepositoryAboutMeImpl : RepositoryAboutMe {

    override suspend fun getAboutMe(): DTOResult<DTOAboutMe> {
        delay(5000)
        return DTOResult.Success(
            response = DTOAboutMe(
                profile = DTOAboutMeProfile(
                    name = "Kaylen Travis Pillay",
                    title = "Android Software Engineer",
                    image = "https://media-exp1.licdn.com/dms/image/C5603AQHAwsUCx_x6nQ/profile-displayphoto-shrink_200_200/0/1547707726993?e=1634169600&v=beta&t=XoYcm_yUgpOu14QyzWNUlmRP-YCIPcDdzKGxeqB9VnQ"
                ),
                sections = listOf(
                    DTOAboutMeSection(
                        id = "0",
                        type = "title",
                        value = "Who Am I ?"
                    ),
                    DTOAboutMeSection(
                        id = "1",
                        type = "paragraph",
                        value = "BSc Computer Science & Information Systems. Huge DC Comics FAN!\uD83D\uDC7B  Professional Android developer and Manchester United fan \uD83D\uDD34 !"
                    )
                )
            )
        )
    }
}