package com.santy.mvvmprueba.Model

class MailProvider {
    companion object {
        fun random(): List<MailModel> {
            val message = listOf(
                MailModel(
                    message = "It’s not a bug. It’s an undocumented feature!",
                    title = "Anonymous",
                    star = 1,
                    flags = 1,
                    circle = 1
                ),
                MailModel(
                    message = "“Software Developer” – An organism that turns caffeine into software",
                    title = "Anonymous",
                    star = 1,
                    flags = 1,
                    circle = 1

                ),
                MailModel(
                    message = "If debugging is the process of removing software bugs, then programming must be the process of putting them in",
                    title = "Edsger Dijkstra",
                    star = 1,
                    flags = 1,
                    circle = 1
                ),
                MailModel(
                    message = "A user interface is like a joke. If you have to explain it, it’s not that good.",
                    title = "Anonymous",
                    star = 1,
                    flags = 1,
                    circle = 1
                ),
                MailModel(
                    message = "I don’t care if it works on your machine! We are not shipping your machine!",
                    title = "Vidiu Platon",
                    star = 1,
                    flags = 1,
                    circle = 1
                ),
                MailModel(
                    message = "Measuring programming progress by lines of code is like measuring aircraft building progress by weight.",
                    title = "Bill Gates",
                    star = 1,
                    flags = 1,
                    circle = 1
                ),
                MailModel(
                    message = "My code DOESN’T work, I have no idea why. My code WORKS, I have no idea why.",
                    title = "Anonymous",
                    star = 1,
                    flags = 1,
                    circle = 1
                ),
                MailModel(
                    message = "Things aren’t always #000000 and #FFFFFF",
                    title = "Anonymous",
                    star = 1,
                    flags = 1,
                    circle = 1),
                MailModel(
                    message = "Talk is cheap. Show me the code.",
                    title = "Linus Torvalds",
                    star = 1,
                    flags = 1,
                    circle = 1),
                MailModel(
                    message = "Software and cathedrals are much the same — first we build them, then we pray.",
                    title = "Anonymous",
                    star = 1,
                    flags = 1,
                    circle = 1
                ),
                MailModel(
                    message = "¿A que esperas?, suscríbete.",
                    title = "AristiDevs",
                    star = 1,
                    flags = 1,
                    circle = 1)
            )
            return message
        }
    }

}