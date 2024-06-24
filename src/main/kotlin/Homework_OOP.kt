package ru.netology

data class Post(
    val text: String = "Text",
    val id: Int = 1,
    val ownerId: Int = 1,
    val fromId: Int = 2,
    val createdBy: Int = 3,
    val likesCount: Int = 0,
    val postType: String = "post",
    val canDelete: Boolean = true,
    val isFavorite: Boolean = false,
    val comments: Comments = Comments()
)

data class Comments(
    val count: Int = 0,
    val canPost: Boolean = true,
    val groupsCanPost: Boolean = true,
    val canClose: Boolean = false,
    val canOpen: Boolean = true
)

object WallService {

    private var posts = emptyArray<Post>()
    private var lastId = 0

    fun addPost(post: Post): Post {
        posts += post.copy(text = "Changed", id = ++lastId)
        return posts.last()
    }

    fun printPost() {
        for (post in posts) {
            print(post)
            print(" ")
        }
        println()
    }

    fun updatePost(newPost: Post): Boolean {
        for ((index, existingPost) in posts.withIndex()) {
            if (existingPost.id == newPost.id) {
                posts[index] = newPost.copy(comments = existingPost.comments)
                return true
            }
        }
        return false
    }

    fun clear() {
        posts = emptyArray()
        lastId = 0
    }
}

fun main() {
    WallService.addPost(Post("Hi", comments = Comments(count = 30)))
    WallService.addPost(Post("wow"))
    WallService.printPost()
    WallService.updatePost(Post(id = 1, text = "New text"))
    WallService.printPost()
}
