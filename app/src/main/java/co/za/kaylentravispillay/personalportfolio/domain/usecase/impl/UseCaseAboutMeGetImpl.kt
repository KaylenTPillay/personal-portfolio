package co.za.kaylentravispillay.personalportfolio.domain.usecase.impl

import co.za.kaylentravispillay.personalportfolio.domain.entity.EntityResult
import co.za.kaylentravispillay.personalportfolio.domain.entity.aboutme.EntityAboutMe
import co.za.kaylentravispillay.personalportfolio.domain.entity.aboutme.EntityAboutMeProfile
import co.za.kaylentravispillay.personalportfolio.domain.entity.aboutme.section.EntityAboutMeParagraphSection
import co.za.kaylentravispillay.personalportfolio.domain.entity.aboutme.section.EntityAboutMeTitleSection
import co.za.kaylentravispillay.personalportfolio.domain.usecase.UseCaseAboutMeGet
import kotlinx.coroutines.delay

class UseCaseAboutMeGetImpl : UseCaseAboutMeGet {

    override suspend fun getAboutMeData(): EntityResult<EntityAboutMe> {
        delay(5000)
        val dummyResponse = EntityAboutMe(
            profile = EntityAboutMeProfile(
                fullName = "Kaylen Travis Pillay",
                careerTitle = "Android Software Engineer",
                thumbnail = "https://media-exp1.licdn.com/dms/image/C5603AQHAwsUCx_x6nQ/profile-displayphoto-shrink_200_200/0/1547707726993?e=1634169600&v=beta&t=XoYcm_yUgpOu14QyzWNUlmRP-YCIPcDdzKGxeqB9VnQ"
            ),
            sections = listOf(
                EntityAboutMeTitleSection(
                    id = "1",
                    title = "Who am I?"
                ),
                EntityAboutMeParagraphSection(
                    id = "2",
                    paragraph = "I am an Android engineer with 3 years of professional development."
                )
            )
        )
        return EntityResult.Success(dummyResponse)
    }
}