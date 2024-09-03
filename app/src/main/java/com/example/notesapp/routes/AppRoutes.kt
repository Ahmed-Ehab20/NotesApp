import Route.ADD_NOTE
import Route.EDIT_NOTE
import Route.HOME
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.notesapp.ui.screens.AddingNoteScreen
import com.example.notesapp.ui.screens.EditingNoteScreen
import com.example.notesapp.ui.screens.HomeScreen

object Route {
    const val HOME = "home"
    const val ADD_NOTE = "add_note"
    const val EDIT_NOTE = "edit_note"
}

@Composable
fun AppNavHost() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = HOME) {
        composable(route = HOME) {
            HomeScreen(navController = navController)
        }
        composable(route = ADD_NOTE) {
            AddingNoteScreen(navController = navController)
        }
        composable(
            route = "$EDIT_NOTE/{id}/{title}/{details}",
            arguments = listOf(
                navArgument("id") { type = NavType.IntType },
                navArgument("title") { type = NavType.StringType },
                navArgument("details") { type = NavType.StringType }
            )
        ) {
            val id = it.arguments?.getInt("id")!!
            val title = it.arguments?.getString("title")!!
            val details = it.arguments?.getString("details")!!
            EditingNoteScreen(id, title, details, navController = navController)
        }
    }
}
