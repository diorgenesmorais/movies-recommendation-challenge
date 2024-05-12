fun main() {
    // 1. Create a list containing information about movies (title, year, genre) in an array
    val movies = listOf(
        Movie("The Shawshank Redemption", 1994, listOf("Drama", "Crime")),
        Movie("The Godfather", 1972, listOf("Crime", "Drama")),
        Movie("The Dark Knight", 2008, listOf("Action", "Crime", "Drama")),
        Movie("Inception", 2010, listOf("Action", "Sci-Fi", "Thriller"))
    )

    // 2. Scroll through the data in this list
    while (true) {
        // 3. Through a prompt, allow the user to search by title or genre and display relevant information
        print("Enter a movie title or genre (or 'exit' to quit): ")
        val input = readlnOrNull()?.trim() ?: ""
        if (input == "exit") break

        val matchingMovies = searchMovies(movies, input)
        if (matchingMovies.isEmpty()) {
            println("No movies found matching '$input'.")
        } else {
            println("Matching movies:")
            for (movie in matchingMovies) {
                println(movie)
            }
        }
    }
}

data class Movie(val title: String, val year: Int, val genres: List<String>)

fun searchMovies(movies: List<Movie>, query: String): List<Movie> {
    return movies.filter { movie ->
        movie.title.contains(query, ignoreCase = true) || movie.genres.any { it.contains(query, ignoreCase = true) || movie.year.toString() == query }
    }
}
