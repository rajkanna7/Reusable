package com.augusta.reaction_popup


interface FavouriteEmojiProvider {

    operator fun invoke(): List<Emoji>
}