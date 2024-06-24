package ru.netology
import org.junit.Test
import org.junit.Assert.*
import org.junit.Before

class WallServiceTest {

    @Before
    fun clearBeforeTest() {
        WallService.clear()
    }

    @Test
    fun addPost_idIsNotZero() {
        val post = Post("Test post")
        val addedPost = WallService.addPost(post)
        assertNotEquals(0, addedPost.id)
    }

    @Test
    fun updatePost_goodId_isTrue() {
        val initialPost = Post("Initial post", id = 1)
        WallService.addPost(initialPost)

        val updatePost = Post(text = "Updated text", id = 1)
        val result = WallService.updatePost(updatePost)

        assertTrue(result)
    }

    @Test
    fun updatePost_badId_isFalse() {
        val updatePost = Post(text = "Updated text", id = 123)
        val result = WallService.updatePost(updatePost)

        assertFalse(result)
    }
}
